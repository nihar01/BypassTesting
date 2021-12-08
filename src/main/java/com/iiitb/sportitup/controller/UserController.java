package com.iiitb.sportitup.controller;

import com.iiitb.sportitup.bean.User;
import com.iiitb.sportitup.service.ActivityService;
import com.iiitb.sportitup.service.UserService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("api")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/user")
    public User createUser(@RequestBody User user)  //mapping the JSON Body tot he object directly
    {
        String regex_firstName="[A-Za-z]+";
        String regex_email = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        String regex_lastName="[A-Za-z]+";
        String regex_contactNumber="^\\d{10}$";
        String regex_password ="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=!])"
                + "(?=\\S+$).{8,20}$";

        Pattern pattern_firstName= Pattern.compile(regex_firstName);
        Matcher matcher_firstName= pattern_firstName.matcher(user.getFirstName());
        System.out.println("FirstName check ->" +" : "+ matcher_firstName.matches());

        Pattern pattern_lastName= Pattern.compile(regex_lastName);
        Matcher matcher_lastName= pattern_lastName.matcher(user.getLastName());
        System.out.println("LastName check ->" +" : "+ matcher_lastName.matches());

        Pattern pattern_email= Pattern.compile(regex_email);
        Matcher matcher_email= pattern_email.matcher(user.getEmailId());
        System.out.println("Email check ->" +" : "+ matcher_email.matches());

        Pattern pattern_contactNumber= Pattern.compile(regex_contactNumber);
        Matcher matcher_contactNumber= pattern_contactNumber.matcher(Long.toString(user.getContactNumber()));
        System.out.println("contactNumber check ->" +" : "+ matcher_contactNumber.matches());

        Pattern pattern_password= Pattern.compile(regex_password);
        Matcher matcher_password= pattern_password.matcher(user.getPassword());
        System.out.println("password check ->" +" : "+ matcher_password.matches());

        if(matcher_firstName.matches() && matcher_lastName.matches() && matcher_email.matches() && matcher_contactNumber.matches()
        && matcher_password.matches()) {
            User u = userService.createUser(user);
            logger.info("[New user created with id] - " + u.getUser_id());
            return u;
        }
        else
        {
            System.out.println("User Registration validation failed");
            return null;
        }
    }



    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user)
    {
        return userService.updateUser(id,user);
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody User user){

//         System.out.println("Login email id check -> "+
//                 Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]" +
//                         "+(?:\\\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]" +
//                         "+(?:\\\\.[a-zA-Z0-9-]+)*$", user.getEmailId()));

        String regex_email = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern_email = Pattern.compile(regex_email);
        Matcher matcher_email = pattern_email.matcher(user.getEmailId());
        System.out.println("Login email check ->" +" : "+ matcher_email.matches());

        String regex_password ="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern pattern_password = Pattern.compile(regex_password);
         Matcher matcher_password = pattern_password.matcher(user.getPassword());
        System.out.println("Login password id check ->" +" : "+ matcher_password.matches());


//        System.out.println("Login Password check -> "
//                +Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", user.getPassword()));

        String email = user.getEmailId();
        String pass = user.getPassword();
        System.out.println("email:"+ email+" "+pass);
        User loggedIn = userService.getUserByEmailId(email);
        //System.out.println("Size" + li.size());

        if( matcher_password.matches() && matcher_email.matches()){
            if(loggedIn.getEmailId().equals(email) && loggedIn.getPassword().equals(pass)) {
                System.out.println("Password Matched");
                logger.info("[Login by user with id] - " + loggedIn.getUser_id());

//               System.out.println("flag after:"+ check.isLog_status());
                return ResponseEntity.ok(loggedIn);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        else {
//            logger.error("[Login by user failed] ");
            System.out.println("Pattern Not matched");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }



    }
}
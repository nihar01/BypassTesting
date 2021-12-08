package com.iiitb.sportitup.controller;

import com.iiitb.sportitup.bean.Activity;
import com.iiitb.sportitup.service.ActivityService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/")
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);
    @GetMapping("/activity")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }


    @PostMapping("/activity")
    public Activity createActivity(@RequestBody Activity activity)  //mapping the JSON Body tot he object directly
    {
        System.out.println(activity.getActivityTime());
       System.out.println( activity.getActivityDate());
        System.out.println(activity.getVenue_id());
        String regex_time="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        Pattern pattern_time= Pattern.compile(regex_time);
        Matcher matcher_time= pattern_time.matcher(activity.getActivityTime());
        System.out.println("Activity Time check ->" +" : "+ matcher_time.matches());
        Activity obj=null;
        if(matcher_time.matches())
        {
            obj = activityService.createActivity(activity);
            System.out.println("Activity Time check ->" +" : "+ matcher_time.matches());
            System.out.println("Activity Created");
//         return obj;
        }
        else
        {
            System.out.println("INVALID Time Format.Activity creation failed.");
        }
        return obj;
//        String regex_date=" ^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        Pattern pattern_date= Pattern.compile(regex_date);

//        try {
//          Activity obj = activityService.createActivity(activity);
//         return obj;
//        }
//        catch(HttpMessageNotReadableException e)
//     {
////            e.printStackTrace();
//            System.out.println("Date format INVALID");
//
//        }
//        return null;
        }



    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Integer id) {
        Activity activity = activityService.getActivityById(id);
        if(activity!=null) {
            return ResponseEntity.ok(activity);
        }
        return null;
    }

    @PutMapping("/activity/join/{activity_id}")
    public ResponseEntity<Activity> joinActivity( @PathVariable Integer activity_id)
{

    System.out.println(activity_id);
          Activity updatedActivity= activityService.joinActivity(activity_id);

          if(updatedActivity!=null) {
              logger.info("[User joined the activity] - " + updatedActivity.getActivity_id());
              return ResponseEntity.ok(updatedActivity);
          }
          else
              return null;
//              logger.warn("[Maximum limit reached for activity] - " + updatedActivity.getActivity_id());

}

}

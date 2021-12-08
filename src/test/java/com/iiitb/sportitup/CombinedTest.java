package com.iiitb.sportitup;

import com.iiitb.sportitup.bean.Activity;
import com.iiitb.sportitup.bean.User;
import com.iiitb.sportitup.bean.Venue;
import com.iiitb.sportitup.repository.ActivityRepository;
import com.iiitb.sportitup.repository.UserRepository;
import com.iiitb.sportitup.repository.VenueRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CombinedTest {
    @Test
    public void registerCheckOne() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        js.executeScript("document.getElementsByName('firstName')[0].setAttribute('pattern', '(.*?)')");
        fname.sendKeys("Harry123");
        WebElement lname = driver.findElement(By.name("lastName"));
        js.executeScript("document.getElementsByName('lastName')[0].setAttribute('pattern', '(.*?)')");
        lname.sendKeys("Potter");
        Thread.sleep(1000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry@gmail.com");
        Thread.sleep(1000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('minlength', '4')");
        contact.sendKeys("1452311234");
        Thread.sleep(1000);
        WebElement password_field = driver.findElement(By.name("password"));
        js.executeScript("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password!1");
        Thread.sleep(1000);
        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//
        login_button.click();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void registerCheckTwo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        js.executeScript("document.getElementsByName('firstName')[0].setAttribute('pattern', '(.*?)')");
        fname.sendKeys("Harry");
        WebElement lname = driver.findElement(By.name("lastName"));
        js.executeScript("document.getElementsByName('lastName')[0].setAttribute('pattern', '(.*?)')");
        lname.sendKeys("Potter123");
        Thread.sleep(1000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry@gmail.com");
        Thread.sleep(1000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('minlength', '4')");
        contact.sendKeys("1452311234");
        Thread.sleep(1000);
        WebElement password_field = driver.findElement(By.name("password"));
        js.executeScript("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password!1");
        Thread.sleep(1000);

        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//
        login_button.click();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void registerCheckThree() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        js.executeScript("document.getElementsByName('firstName')[0].setAttribute('pattern', '(.*?)')");
        fname.sendKeys("Harry");
        WebElement lname = driver.findElement(By.name("lastName"));
        js.executeScript("document.getElementsByName('lastName')[0].setAttribute('pattern', '(.*?)')");
        lname.sendKeys("Potter");
        Thread.sleep(1000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry-gmail.com");
        Thread.sleep(1000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('minlength', '4')");
        contact.sendKeys("1452311234");
        Thread.sleep(1000);
        WebElement password_field = driver.findElement(By.name("password"));
        js.executeScript("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password!1");
        Thread.sleep(1000);

        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//
        login_button.click();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void registerCheckFour() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        js.executeScript("document.getElementsByName('firstName')[0].setAttribute('pattern', '(.*?)')");
        fname.sendKeys("Harry");
        WebElement lname = driver.findElement(By.name("lastName"));
        js.executeScript("document.getElementsByName('lastName')[0].setAttribute('pattern', '(.*?)')");
        lname.sendKeys("Potter");
        Thread.sleep(1000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry@gmail.com");
        Thread.sleep(1000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('minlength', '4')");
        contact.sendKeys("1452");
        Thread.sleep(1000);
        WebElement password_field = driver.findElement(By.name("password"));
        js.executeScript("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password!1");
        Thread.sleep(1000);

        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//
        login_button.click();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void registerCheckFive() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        js.executeScript("document.getElementsByName('firstName')[0].setAttribute('pattern', '(.*?)')");
        fname.sendKeys("Harry");
        WebElement lname = driver.findElement(By.name("lastName"));
        js.executeScript("document.getElementsByName('lastName')[0].setAttribute('pattern', '(.*?)')");
        lname.sendKeys("Potter");
        Thread.sleep(1000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry@gmail.com");
        Thread.sleep(1000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('contactNumber')[0].setAttribute('minlength', '4')");
        contact.sendKeys("1452311234");
        Thread.sleep(1000);
        WebElement password_field = driver.findElement(By.name("password"));
        js.executeScript("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password");
        Thread.sleep(1000);

        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//
        login_button.click();
        Thread.sleep(3000);
        driver.close();
    }

}

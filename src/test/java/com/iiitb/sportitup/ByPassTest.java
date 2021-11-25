package com.iiitb.sportitup;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByPassTest {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userSignInComponent");
        //Locating the email field element via Name tag and storing it in the webelement
        WebElement email_field = driver.findElement(By.name("emailId"));

        //Entering text into the email field
        email_field.sendKeys("shwetamasrani19@gmail.com");

        //Locating the password field element via Name tag and storing it in the webelement
        WebElement password_field=driver.findElement(By.name("password"));

        //Entering text into the password field
        password_field.sendKeys("cosmos99");

        //Clicking on the login button to login to the application
        WebElement login_button=driver.findElement(By.xpath("//button[text()='Sign In']"));

        //Clicking on the 'login' button
        login_button.click();
        driver.switchTo().alert().accept();
        //Closing the window
        driver.close();
//        obj.quit();
    }
}

package com.iiitb.sportitup;
import java.lang.Thread;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByPassTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userSignInComponent");
        //Locating the email field element via Name tag and storing it in the webelement
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement email_field = driver.findElement(By.name("emailId"));

        String typeValue = email_field.getAttribute("type");
        //Entering text into the email field
        email_field.sendKeys("nihar@gmail.com");
        Thread.sleep(3000);
        //Locating the password field element via Name tag and storing it in the webelement
        WebElement password_field=driver.findElement(By.name("password"));
        js.executeScript
                ("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript
                ("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("cosmos99");
        Thread.sleep(3000);
        //Clicking on the login button to login to the application
        WebElement login_button=driver.findElement(By.xpath("//button[text()='Sign In']"));
//        sleep(2000);
        Thread.sleep(3000);
        //Clicking on the 'login' button
        login_button.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        //Closing the window
        driver.close();
//        obj.quit();
    }
}

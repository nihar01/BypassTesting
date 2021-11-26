package com.iiitb.sportitup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResigterPageTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userRegisterComponent");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement fname = driver.findElement(By.name("firstName"));
        fname.sendKeys("Harry");
        WebElement lname = driver.findElement(By.name("lastName"));
        lname.sendKeys("Potter");
        Thread.sleep(3000);
        WebElement email_field = driver.findElement(By.name("emailId"));
        js.executeScript
                ("document.getElementsByName('emailId')[0].setAttribute('type', 'text')");
        js.executeScript
                ("document.getElementsByName('emailId')[0].setAttribute('pattern', '(.*?)')");
        email_field.sendKeys("harry@gmail.com");
        Thread.sleep(3000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript
                ("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        contact.sendKeys("1234567890");
        Thread.sleep(3000);
        WebElement password_field=driver.findElement(By.name("password"));
        js.executeScript
                ("document.getElementsByName('password')[0].setAttribute('type', 'text')");
        js.executeScript
                ("document.getElementsByName('password')[0].setAttribute('pattern', '(.*?)')");
        //Entering text into the password field
        password_field.sendKeys("Password!1");
        Thread.sleep(3000);
        //Select sc = new Select(driver.findElement(By.id("isAdmin")));
//        js.executeScript("document.getElementsByName('isAdmin')[0].setAttribute('value', 'unknown')");
        //sc.selectByValue("unknown");

//        WebElement register_button = driver.findElement(By.xpath("//button[text()='Register']"));

//        driver.findElement(By.name("//form[@name='registerform']")).submit();
        //register_button.submit();
        WebElement login_button=driver.findElement(By.xpath("//button[text()='Register']"));
//        sleep(2000);
        Thread.sleep(3000);
        HttpURLConnection c=
                (HttpURLConnection)new
                        URL("http://localhost:3000/userRegisterComponent")
                        .openConnection();
        // set the HEAD request with setRequestMethod
        c.setRequestMethod("HEAD");
        // connection started and get response code
        c.connect();
        int r = c.getResponseCode();
        System.out.println("Http response code: " + r);
        //Clicking on the 'login' button
        login_button.click();
        Thread.sleep(3000);
        driver.close();

    }
}

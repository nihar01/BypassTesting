package com.iiitb.sportitup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResigterPageTest {

    public static void main(String[] args) throws InterruptedException {
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
        email_field.sendKeys("harry123");
        Thread.sleep(3000);
        WebElement contact = driver.findElement(By.name("contactNumber"));
        js.executeScript
                ("document.getElementsByName('contactNumber')[0].setAttribute('type', 'text')");
        contact.sendKeys("cosmos1234");
        Thread.sleep(3000);
        WebElement password_field=driver.findElement(By.name("password"));
        js.executeScript
                ("document.getElementsByName('password')[0].setAttribute('type', 'Number')");
        //Entering text into the password field
        password_field.sendKeys("1234");
        Thread.sleep(3000);
        //Select sc = new Select(driver.findElement(By.id("isAdmin")));
        js.executeScript
                ("document.getElementsByName('isAdmin')[0].setAttribute('value', 'unknown')");
        //sc.selectByValue("unknown");

        //WebElement register_button = driver.findElement(By.xpath("//button[text()='Register']"));

        driver.findElement(By.name("//form[@name='registerform']")).submit();
        //register_button.submit();
        Thread.sleep(3000);
        driver.close();

    }
}

package com.iiitb.sportitup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateActivityTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/AddActivity");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement sportName = driver.findElement(By.name("sportName"));
        sportName.sendKeys("Tennis");

        js.executeScript("document.getElementsByName('activityDate')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('activityDate')[0].setAttribute('pattern', '[A-Za-z]+')");
        WebElement activityDate = driver.findElement(By.name("activityDate"));
        activityDate.sendKeys("andom");

        js.executeScript("document.getElementsByName('activityTime')[0].setAttribute('type', 'text')");
        js.executeScript("document.getElementsByName('activityTime')[0].setAttribute('pattern', '[A-Za-z]+')");
        WebElement activityTime = driver.findElement(By.name("activityTime"));
        activityTime.sendKeys("RandomValue");

//        WebElement Venue = driver.findElement(By.name("venue_id"));
//        Venue.sendKeys("100");

        WebElement Venue = driver.findElement(By.xpath("//select[@name='venue_id']"));

// Create an object of Select class and pass the dropdown of type WebElement as an argument.
        Select select = new Select(Venue);

// Select the option "USA" by sending its value attribute.
        select.selectByIndex(1);

        WebElement NumberOfPlayers = driver.findElement(By.name("numberOfPlayers"));
        NumberOfPlayers.sendKeys("10");

        WebElement ChargePerPerson = driver.findElement(By.name("chargesPerPerson"));
        ChargePerPerson.sendKeys("1000");


        WebElement button=driver.findElement(By.xpath("//button[text()='Create Activity']"));
        Thread.sleep(8000);
        //Clicking on the 'login' button
        button.click();
//        driver.switchTo().alert().accept();
        //Closing the window
        driver.close();
    }
}

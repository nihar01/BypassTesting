package com.iiitb.sportitup;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByPassTest {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/palak/Downloads/chromedriver");
        WebDriver obj = new ChromeDriver();
        obj.get("https://www.github.com/");
        obj.quit();
    }
}

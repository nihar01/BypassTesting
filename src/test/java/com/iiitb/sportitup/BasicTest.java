package com.iiitb.sportitup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class BasicTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/Documents/Testing/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/userSignInComponent");
//        driver.get("https://www.google.com");
        HttpURLConnection c=
                (HttpURLConnection)new
                        URL("http://localhost:3000/userSignInComponent")
                        .openConnection();
        // set the HEAD request with setRequestMethod
        c.setRequestMethod("HEAD");
        // connection started and get response code
        c.connect();
        int r = c.getResponseCode();
        System.out.println("Http response code: " + r);
        Thread.sleep(4000);
        driver.close();
    }
}

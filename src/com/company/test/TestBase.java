package com.company.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static String PASSWORD = "nastya28a";
    public static String LOGIN = "a.kurkova59@icloud.com";

    WebDriver driver;

    @BeforeMethod
    public void startUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://trello.com/");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

package com.company.test;

import com.company.pages.HomePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static String PASSWORD = "nastya28a";
    public static String LOGIN = "a.kurkova59@icloud.com";
    HomePageHelper homePage;


    WebDriver driver;

    @BeforeMethod
    public void startUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("lang=" + "en");
        driver = new ChromeDriver(options);
        driver.get("http://trello.com/");
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}




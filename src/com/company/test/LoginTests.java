package com.company.test;

import com.company.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void initTests() throws InterruptedException {
        waitUntilElementIsClickable(By.cssSelector(".text-primary"),40);
        driver.findElement(By.cssSelector(".text-primary")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
    }


    @Test
    public void positiveLogin() throws InterruptedException {
       // driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
       // Thread.sleep(1000);

        WebElement userField = driver.findElement(By.cssSelector("#user"));
        //userField.click();
        //userField.sendKeys("a.kurkova59@icloud.com");
        editField(userField, LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"), 7);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));
        loginAsAttl.click();
       waitUntilElementIsClickable(By.id("password"), 5);

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        // password.click();
        //password.sendKeys("nastya28a");
        editField(password, PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"), 5);

        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.xpath("(//button]@data-test-id='header-boards-menu-button']/span[2]"), 25);

        Assert.assertEquals(driver
                        .findElement(By.xpath("(//button[@data-test-id='header-boards-menu-button']/span)[2]")).getText(),"Boards",
                "Name of the button is not 'Boards'");


    }

    @Test
    public void negativeLogin() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);
        WebElement userField = driver.findElement(By.cssSelector("#user"));
        //userField.click();
        //userField.sendKeys("a.kurkova59@icloud.com");
        editField(userField,"test");

        //fill in password field
        WebElement passwordField = driver.findElement(By.id("password"));

        /*passwordField.click();
        passwordField.sendKeys("password");*/
        editField(passwordField,"password");
        driver.findElement(By.id("login")).click();
        waitUntilElementIsVisible(By.cssSelector("p.error-message"),10);

        Assert.assertEquals(driver
                .findElements(By.cssSelector("p.error-message")).get(0).getText(),
                "Your account has been updated. Please check your email to continue using Trello.",
                "The error message is not correct");

    }
}




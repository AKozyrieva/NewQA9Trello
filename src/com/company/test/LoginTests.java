package com.company.test;

import com.company.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {



    @Test
    public void positiveLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        Thread.sleep(1000);

        WebElement userField = driver.findElement(By.cssSelector("#user"));
        userField.click();
        userField.sendKeys("a.kurkova59@icloud.com");
        Thread.sleep(1000);

        WebElement loginField = driver.findElement(By.cssSelector("#login"));
        loginField.click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.click();
        password.sendKeys("naskacrazy1993");
        Thread.sleep(3000);

        WebElement loginInField = driver.findElement(By.id("login-submit"));
        loginInField.click();
        Thread.sleep(15000);

        System.out.println("Boards button name: " + driver
                .findElement(By.xpath("(//button[@data-test-id='header-boards-menu-button']/span)[2]")).getText());


    }

    @Test
    public void negativeLogin() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);
        WebElement userField = driver.findElement(By.cssSelector("#user"));
        userField.click();
        userField.sendKeys("test");
        Thread.sleep(1000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("password");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        System.out.println("Error-message: " + driver
                .findElements(By.cssSelector("p.error-message")).get(0).getText());
    }

}




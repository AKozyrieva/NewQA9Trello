package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        waitUntilElementIsClickable(By.cssSelector(".text-primary"), 40);
        driver.findElement(By.cssSelector(".text-primary")).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.id("login"), 10);
    }

    public void loginNotAttl(String login, String password) {
        fillInUserField(login);
        fillInPasswordField(password);
        submitLoginNotAttl();
    }

    public void loginAsAttl (String login, String password) {
        fillInUserField(login);
        pressLoginAsAttlButton();
        fillInPasswordAttl(password);
        submitLoginAttl();

    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(By.cssSelector("p.error-message"),10);
        return driver.findElement(By.cssSelector("p.error-message")).getText();

    }

    public void fillInUserField(String value) {
        WebElement userField = driver.findElement(By.cssSelector("#user"));
        editField(userField, value);
    }

    public void fillInPasswordField(String value) {
        WebElement passwordField = driver.findElement(By.id("password"));
        editField(passwordField, value);
    }

    public void submitLoginNotAttl() {
        driver.findElement(By.id("login")).click();    }

    public void pressLoginAsAttlButton() {
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"),5);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));
        loginAsAttl.click();    }

    public void fillInPasswordAttl(String value) {
        waitUntilElementIsClickable(By.id("password"), 5);
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        editField(password, value);
    }

    public void submitLoginAttl() {
        waitUntilElementIsClickable(By.id("login-submit"), 5);
        driver.findElement(By.id("login-submit")).click();
    }
}

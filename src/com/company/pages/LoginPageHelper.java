package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(css = ".text-primary")
    WebElement logInIcon;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(id = "user")
    WebElement userField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy (css = "p.error-message")
    WebElement errorMessage;
    @FindBy(xpath = "//input[@value = 'Log in with Atlassian']")
    WebElement loginAsAttlButton;
    @FindBy (id = "login-submit")
    WebElement submitAsAtllButton;

    public LoginPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        waitUntilElementIsClickable(logInIcon, 15);
        logInIcon.click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginButton, 10);
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
        waitUntilElementIsVisible(errorMessage, 10);
        return errorMessage.getText();

    }

    public void fillInUserField(String value) {
        editField(userField, value);
    }

    public void fillInPasswordField(String value) {
        editField(passwordField, value);
    }

    public void submitLoginNotAttl() {
       loginButton.click();   }

    public void pressLoginAsAttlButton() {
        waitUntilElementIsClickable(loginAsAttlButton,5);
        loginAsAttlButton.click();  }

    public void fillInPasswordAttl(String value) {
        waitUntilElementIsClickable(passwordField, 5);
        editField(passwordField, value);
    }

    public void submitLoginAttl() {
        waitUntilElementIsClickable(submitAsAtllButton, 5);
        submitAsAtllButton.click();
    }
}

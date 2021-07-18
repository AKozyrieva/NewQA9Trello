package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends PageBase{
    @FindBy(css = ".text-primary")
    WebElement logInIcon;

    public HomePageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(logInIcon,40);
    }
    public boolean isCorrectPage() {
        return logInIcon.getText().equals("Log in");
    }


    }




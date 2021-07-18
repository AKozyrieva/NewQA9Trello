package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPageHelper extends PageBase{
    @FindBy (css = ".phenom-desc")
    List<WebElement> activityList;

    public  ActivityPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilAllElementsAreVisible(activityList,15);
        }

        public boolean lastActivityContains(String text){

        return activityList.get(0).getText().contains(text);
        }
}

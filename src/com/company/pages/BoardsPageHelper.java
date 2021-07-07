package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardsPageHelper extends PageBase {

    public BoardsPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("(//button]@data-test-id='header-boards-menu-button']/span[2]"), 25);
    }

    public String getBoardsButtonName() {
        return driver
                .findElement(By.xpath("(//button[@data-test-id='header-boards-menu-button']/span)[2]")).getText();
    }
}
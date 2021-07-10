package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void openBoardsMenu() {
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id = 'home-team-boards-tab']"),10);
        driver.findElement(By.xpath("//a[@data-test-id = 'home-team-boards-tab']")).click();
        waitUntilElementTextIs(By.xpath("//h3"),"Your Workspace boards",10);
    }

    private void waitUntilElementTextIs(By locator, String text, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

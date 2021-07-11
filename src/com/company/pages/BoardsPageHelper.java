package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardsPageHelper extends PageBase {
    @FindBy (xpath = "(//button[@data-test-id='header-boards-menu-button']/span)[2]")
    WebElement boardsIcon;
    @FindBy(xpath = "//a[@data-test-id = 'home-team-boards-tab']")
    WebElement boardsMenuLeft;
    @FindBy(xpath = "//h3")
    WebElement headerYourWorkspace;

    public BoardsPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(boardsIcon,30);
    }

    public String getBoardsButtonName() {
        return boardsIcon.getText();
    }

    public void openBoardsMenu() {
        waitUntilElementIsClickable(boardsMenuLeft,10);
        boardsMenuLeft.click();
        waitUntilElementTextIs(headerYourWorkspace,"Your Workspace boards",10);
    }

    }

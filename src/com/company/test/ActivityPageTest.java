package com.company.test;

import com.company.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityPageTest extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper boardQa9Haifa;
    MenuPageHelper menuPage;
    ActivityPageHelper activityPage;

    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        boardQa9Haifa = new CurrentBoardPageHelper(driver, "QA Haifa9");
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
        activityPage = PageFactory.initElements(driver, ActivityPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttl(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openBoardsMenu();
        boardQa9Haifa.openPage();
        boardQa9Haifa.waitUntilPageIsLoaded();

    }
    @Test
    public void creatingListActivityTest(){
        String listName = "New Activity Test";
        boardQa9Haifa.addNewList(listName);
        menuPage.openPage();
        menuPage.waitUntilPageIsLoaded();
        menuPage.openActivityPage();
        activityPage.waitUntilPageIsLoaded();
        Assert.assertTrue(activityPage.lastActivityContains(listName));
    }
}
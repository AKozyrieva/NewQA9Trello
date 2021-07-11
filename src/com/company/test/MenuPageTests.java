package com.company.test;

import com.company.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class MenuPageTests extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper boardQa9Haifa;
    MenuPageHelper menuPage;

    @BeforeMethod
    public void initTests(){

        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        boardQa9Haifa = new CurrentBoardPageHelper(driver, "QA Haifa 9");
        menuPage = new MenuPageHelper(driver);

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openBoardsMenu();
        boardQa9Haifa.openPage();
        boardQa9Haifa.waitUntilPageIsLoaded();
        menuPage.openPage();
        menuPage.waitUntilPageIsLoaded();

    }

    public void profileVisibilityMenuExist(){
        Assert.assertEquals(menuPage.getProfileVisibilityMenuName(), "Profile and visibility");
    }
}

package com.company.test;

import com.company.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuPageTests extends TestBase{
   // HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper boardQa9Haifa;
    MenuPageHelper menuPage;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        boardQa9Haifa = new CurrentBoardPageHelper(driver, "QA Haifa 9");
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);

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
    @Test
    public void profileVisibilityMenuExist(){
        Assert.assertEquals(menuPage.getProfileVisibilityMenuName(), "Profile and visibility");
    }
}

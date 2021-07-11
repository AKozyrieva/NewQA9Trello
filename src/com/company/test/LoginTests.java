package com.company.test;

import com.company.pages.BoardsPageHelper;
import com.company.pages.HomePageHelper;
import com.company.pages.LoginPageHelper;
import com.company.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends TestBase {
   // HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests()  {
       //homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();

    }


    @Test
    public void positiveLogin() {
       loginPage.loginAsAttl(LOGIN, PASSWORD);
       boardsPage.waitUntilPageIsLoaded();
        Assert.assertEquals(boardsPage.getBoardsButtonName(),"Boards",
                "Name of the button is not 'Boards'");
    }

    @Test
    public void negativeLogin()  {
        loginPage.loginNotAttl("aaaaaaaa", "rererere");
       Assert.assertEquals(loginPage.getErrorMessage(),"There isn't an account for this username",
               "The error message is not correct");
    }
}




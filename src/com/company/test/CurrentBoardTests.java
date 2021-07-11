package com.company.test;

import com.company.pages.BoardsPageHelper;
import com.company.pages.CurrentBoardPageHelper;
import com.company.pages.HomePageHelper;
import com.company.pages.LoginPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.List;

public class CurrentBoardTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper boardQa9Haifa;


    @BeforeMethod
    public void initTests() {
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        boardQa9Haifa = new CurrentBoardPageHelper(driver, "QA Haifa9");

        homePage.waitUntilPageIsLoaded();
        loginPage
                .openPage()
                .waitUntilPageIsLoaded()
                .loginAsAttl(LOGIN, PASSWORD);
        boardsPage
                .waitUntilPageIsLoaded()
                .openBoardsMenu();
        boardQa9Haifa.openPage();
        boardQa9Haifa.waitUntilPageIsLoaded();


    }


    @Test
    public void newListCreatingTest() throws InterruptedException {
        int beginListsQuantity = boardQa9Haifa.getListsQuantity();
        boardQa9Haifa.addNewList("New List");
        int endListsQuantity = boardQa9Haifa.getListsQuantity();
        Assert.assertEquals(endListsQuantity,beginListsQuantity+1,
                "endListsQuantity is not beginListsQuantity+1");
    }

    @Test
    public void addNewCardTest() throws InterruptedException {

        int beginList = boardQa9Haifa.getListsQuantity();
        if(beginList==0) {
            boardQa9Haifa.addNewList("New List1");
        }
        int beginCards = boardQa9Haifa.getCardQuantity();
        boardQa9Haifa.addCardToTheList("Card name");
        int endCardsQuantity = boardQa9Haifa.getCardQuantity();
        Assert.assertEquals(endCardsQuantity,beginCards+1,
                "endCardsQuantity is not beginCards+1");
        }


    @Test
    public void archiveList(){
        int beginList = boardQa9Haifa.getListsQuantity();
        if(beginList==0) {
            boardQa9Haifa.addNewList("New List1");
            beginList++;
        }
        boardQa9Haifa.archiveList();
        int endList = boardQa9Haifa.getListsQuantity();
        Assert.assertEquals(beginList-1,endList,
                "beginLists-1 is not endLists");

    }

    @Test
    public void copyList(){

        int beginList = boardQa9Haifa.getListsQuantity();
        if(beginList==0) {

            boardQa9Haifa.addNewList("New List2");
            beginList++;
        }

        boardQa9Haifa.copyList("Copy List");
        int endLists = boardQa9Haifa.getListsQuantity();
        Assert.assertEquals(endLists,beginList+1, "endLists is not beginLists+1");

    }
}










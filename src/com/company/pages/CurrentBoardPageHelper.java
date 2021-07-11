package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CurrentBoardPageHelper extends PageBase {
    @FindBy(css = ".placeholder")
    WebElement addListButton;
    @FindBy(css = ".js-list-content")
    List<WebElement> listQuantity;
    String boardName;

    public CurrentBoardPageHelper(WebDriver driver, String boardName) {
        this.driver = driver;
        this.boardName = boardName;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        waitUntilElementIsClickable(boardButtonLocatorLoaded(), 25);
        WebElement boardQaHaifa9 = driver.findElement(boardButtonLocatorLoaded());
        boardQaHaifa9.click();
    }

    public By boardButtonLocatorLoaded() {
        return By.xpath("//a[@class = 'board-tile'][.//div[@title='"+boardName+"']]");
        
    }


    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(addListButton,10);
        if (addListButton.getText().equals("Add another list")){
            //waitUntilAllElementsArePresent(By.cssSelector(".js-list-content"),5);
            waitUntilAllElementsAreVisible(listQuantity, 10);
        }
    }

    public int getListsQuantity() {
        //List<WebElement> listQuantity = driver.findElements(By.cssSelector(".js-list-content"));
        return listQuantity.size();
    }

    public void addNewList(String name) {
        int beginListsQuantity = this.getListsQuantity();
        WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
        createList.click();
        //Thread.sleep(1000);

        WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
        editField(listTitle, "New List");
        //Thread.sleep(3000);

        WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
        saveNewList.click();
        waitUntilElementIsVisible(By.cssSelector(".js-save-edit"),10);

        System.out.println("After adding new list: " + this.getListsQuantity());
        waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"),5);
        WebElement cancelListCreating= driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelListCreating.click();
        waitUntilElementIsClickable(By.cssSelector(".placeholder"),5);
    }

    public int getCardQuantity() {
        List<WebElement> cardQuantity = driver.findElements(By.cssSelector(".list-card-title"));
        return cardQuantity.size();
    }

    public void addCardToTheList(String name) {
        int beginCards = this.getCardQuantity();

        WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
        addCardButton.click();

        WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
        editField(cardTitleField, "Card name");

        driver.findElement(By.cssSelector(".js-add-card")).click();
        waitUntilElementBecome(By.cssSelector(".list-card-title"),beginCards+1, 10);
        waitUntilElementIsClickable(By.cssSelector(".js-cancel"),5);
        driver.findElement(By.cssSelector(".js-cancel")).click();

    }

    public void archiveList() {
        int beginLists = this.getListsQuantity();
        waitUntilElementIsClickable(By.cssSelector(".list-header-extras"),7);
        driver.findElement(By.cssSelector(".list-header-extras")).click();

        waitUntilElementIsClickable(By.cssSelector(".js-close-list"),5);
        driver.findElement(By.cssSelector(".js-close-list")).click();
        waitUntilElementBecome(By.cssSelector(".js-list-content"),beginLists-1,5);
    }


    public void copyList(String name) {
        int beginLists = this.getListsQuantity();
        waitUntilElementIsClickable(By.cssSelector(".list-header-extras-menu"),5);
        driver.findElement(By.cssSelector(".list-header-extras")).click();
        waitUntilElementIsClickable(By.cssSelector(".js-copy-list"),10);

        driver.findElement(By.cssSelector(".js-copy-list")).click();


        WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
        waitUntilElementIsClickable(By.cssSelector(".js-submit"),10);
        driver.findElement(By.cssSelector(".js-submit")).click();
        waitUntilElementBecome(By.cssSelector(".js-list-content"),beginLists+1,5);
    }
}


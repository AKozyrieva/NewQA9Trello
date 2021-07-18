package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CurrentBoardPageHelper extends PageBase {
    @FindBy(css = ".placeholder")
    WebElement addListButton;
    @FindBy(css = ".js-list-content")
    List<WebElement> listQuantity;
    @FindBy(css = "input[name='name']")
    WebElement listName;
    @FindBy (css = ".js-save-edit")
    WebElement saveList;
    @FindBy (css = ".js-cancel-edit")
    WebElement xCancelEditList;
    @FindBy (css = ".card-composer-container")
    WebElement addCard;
    @FindBy (css =".js-card-title")
    WebElement cardName;
    @FindBy (css = ".js-add-card")
    WebElement submitCard;
    @FindBy (css = ".js-cancel")
    WebElement xCancelButton;
    @FindBy (css = ".list-header-extras-menu")
    WebElement listMenuButton;
    @FindBy (css = ".js-copy-list")
    WebElement copyMenu;
    @FindBy (css = ".js-autofocus")
    WebElement copyTitleListField;
    @FindBy (css = ".js-submit")
    WebElement submitCopyListButton;
    @FindBy (css = ".list-header-extras-menu")
    List<WebElement> collumnsMenuList;
    @FindBy (css = ".js-close-list")
    WebElement archiveMenuOption;
    String boardName;

    public CurrentBoardPageHelper(WebDriver driver, String boardName) {
        this.driver = driver;
        this.boardName = boardName;
        PageFactory.initElements(driver, this);
    }

    public CurrentBoardPageHelper openPage() {
        waitUntilElementIsClickable(boardButtonLocatorLoaded(), 25);
        WebElement boardQaHaifa9 = driver.findElement(boardButtonLocatorLoaded());
        boardQaHaifa9.click();
        return this;
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
        addListButton.click();
        editField(listName, name);
        saveList.click();
        // click 'x' button to cancel new list creating
        waitUntilElementsBecome(By.cssSelector(".js-list-content"),beginListsQuantity+1,10);
        System.out.println("After adding: " + this.getListsQuantity());
        waitUntilElementIsClickable(xCancelEditList,5);
        //WebElement cancelListCreatingButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
        xCancelEditList.click();
        waitUntilElementIsClickable(addListButton,5);
    }

    public int getCardQuantity() {
        List<WebElement> cardQuantity = driver.findElements(By.cssSelector(".list-card-title"));
        return cardQuantity.size();
    }

    public void addCardToTheList(String name) {
        int beginCards = this.getCardQuantity();

        addCard.click();
        editField(cardName, "new card");
        submitCard.click();
        waitUntilElementsBecome(By.cssSelector(".list-card-title"),beginCards+1,10);
        waitUntilElementIsClickable(xCancelEditList,5);
        xCancelButton.click();

    }
    public void archiveFirstList() {
        this.archiveList(0);
    }
    
    public void archiveList(int number) {
        int beginLists = this.getListsQuantity();
        waitUntilElementIsClickable(collumnsMenuList.get(number),5);
        collumnsMenuList.get(number).click();
        waitUntilElementIsClickable(archiveMenuOption,5);
        archiveMenuOption.click();
        waitUntilElementsBecome(By.cssSelector(".js-list-content"),beginLists-1,5);
    }


    public void copyList(String name) {
        int beginLists = this.getListsQuantity();
        waitUntilElementIsClickable(listMenuButton,5);
        listMenuButton.click();

        // -- click on "Copy menu"
        waitUntilElementIsClickable(copyMenu,10);
        copyMenu.click();

        //-- fill in title---
        waitUntilElementIsClickable(copyTitleListField,5);
        copyTitleListField.sendKeys(name);

        //--- submit copy list option ---
        waitUntilElementIsClickable(submitCopyListButton,10);
        submitCopyListButton.click();

        waitUntilElementsBecome(By.cssSelector(".js-list-content"),beginLists+1,5);
    }
}


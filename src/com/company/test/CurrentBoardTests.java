package com.company.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.List;

public class CurrentBoardTests extends TestBase {


    @BeforeMethod
    public void initTests() throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector(".text-primary"));
                button.click();

        WebElement userField = driver.findElement(By.cssSelector("#user"));
        editField(userField, LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"),5);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));

        // press 'Log in with Atlassian' button
        loginAsAttl.click();
        waitUntilElementIsClickable(By.id("password"),5);

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        editField(password, PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"), 5);

        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsClickable(By.xpath("(//button]@data-test-id='header-boards-menu-button']/span[2]"), 25);


        //click on specific board
        WebElement board = driver.findElement((By.cssSelector("div[title='QA Haifa9']")));
        board.click();
        //wait while "Add another button" is uploading
        waitUntilElementIsClickable(By.cssSelector(".placeholder"), 10);
        //wait while all lists are uploading
        waitUntilAllElementsArePresent(By.cssSelector(".list js-list-content"), 10);

    }


    @Test
    public void newListCreatingTest() throws InterruptedException {
        List<WebElement> listQuantity = driver.findElements(By.cssSelector(".js-editing-target"));
        listQuantity.toString();
        System.out.println("Quantity of the list at the beginning: " + listQuantity.size());
        WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
        createList.click();
        //Thread.sleep(1000);

        WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
        editField(listTitle, "New");
        //Thread.sleep(3000);

        WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
        saveNewList.click();
        waitUntilElementIsVisible(By.cssSelector(".js-save-edit"),10);

        waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"), 5);
        WebElement cancelListCreating = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelListCreating.click();

        waitUntilElementIsClickable(By.cssSelector(".placeholder"), 5);
        List<WebElement> listQuantity2 = driver.findElements(By.cssSelector(".js-editing-target"));
        listQuantity2.toString();
        Assert.assertNotEquals(listQuantity,listQuantity2);
    }



    @Test
    public void addNewCardTest() throws InterruptedException {

        int beginList = getListsQuantity();
        if(beginList==0) {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();
            //Thread.sleep(2000L);
            waitUntilElementBecome(By.cssSelector(".js-list-content"), beginList + 1, 10);
        }
        int beginCard = getCardQuantity();
            //fill in card title
            WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
            addCardButton.click();

            WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
            editField(cardTitleField, "card title");

            driver.findElement(By.cssSelector(".js-add-card")).click();
            waitUntilElementBecome(By.cssSelector(".list-card-title"),beginCard+1, 10);
            waitUntilElementIsClickable(By.cssSelector(".js-cancel"),5);
            driver.findElement(By.cssSelector(".js-cancel")).click();
            int endCardQuantity = getCardQuantity();
            Assert.assertEquals(endCardQuantity,beginCard+1,"endCardQuantity is not beginCard+1");


        }

    private int getListsQuantity() {
        List<WebElement> collumnsList = driver.findElements(By.cssSelector(".js-list-content"));
        return collumnsList.size();
    }

    private int getCardQuantity() {
        List<WebElement> collumnList = driver.findElements(By.cssSelector(".list-card-title"));
        return collumnList.size();
    }


    @Test
    public void archiveList() throws InterruptedException {
        int beginList = getListsQuantity();
        if(beginList==0) {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();

            waitUntilElementBecome(By.cssSelector(".js-list-content"),beginList+1,10);
            beginList++;
        }
           waitUntilElementIsClickable(By.cssSelector(".list-header-extras"),7);
           driver.findElement(By.cssSelector(".list-header-extras")).click();

            waitUntilElementIsClickable(By.cssSelector(".js-close-list"),5);
            driver.findElement(By.cssSelector(".js-close-list")).click();
            waitUntilElementBecome(By.cssSelector(".js-list-content"),beginList+1,10);

            int endList = getListsQuantity();
            Assert.assertEquals(beginList-1,endList, "beginList-1 is not endList");

    }


    @Test
    public void copyList() throws InterruptedException {

        int beginList = getListsQuantity();
        if(beginList==0) {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();

            waitUntilElementBecome(By.cssSelector(".js-list-content"),beginList+1,10);
            waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"),10);
            WebElement cancelListCreatingButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
            cancelListCreatingButton.click();
            beginList++;
        }
            waitUntilElementIsClickable(By.cssSelector(".list-header-extras-menu"),5);
            driver.findElement(By.cssSelector(".list-header-extras")).click();
            waitUntilElementIsClickable(By.cssSelector(".js-copy-list"),10);

            driver.findElement(By.cssSelector(".js-copy-list")).click();


            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            waitUntilElementIsClickable(By.cssSelector(".js-submit"),10);
            driver.findElement(By.cssSelector(".js-submit")).click();
            waitUntilElementBecome(By.cssSelector(".js-list-content"),beginList+1,5);

            int endLists = getListsQuantity();
            Assert.assertEquals(endLists,beginList+1, "endList is not beginList+1");






    }
}









package com.company.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests extends TestBase {


    @BeforeMethod
    public void initTests() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        button.click();

        WebElement userField = driver.findElement(By.cssSelector("#user"));
        editField(userField, LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"), 7);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));
        loginAsAttl.click();
        waitUntilElementIsClickable(By.id("password"), 5);

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        // password.click();
        //password.sendKeys("nastya28a");
        editField(password, PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"), 5);

        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(5000);
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

        WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
        createList.click();
        //Thread.sleep(1000);

        WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
        editField(listTitle, "New");
        //Thread.sleep(3000);

        WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
        saveNewList.click();
        //Thread.sleep(2000L);
        waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"), 5);
        WebElement cancelListCreating = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelListCreating.click();

        waitUntilElementIsInvisible(By.cssSelector(".js-cancel-edit"), 5);

    }


    @Test
    public void addNewCardTest() throws InterruptedException {
        // press 'Add a card' ('Add another card')
        WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
        addCardButton.click();
        //fill in card title
        WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
        editField(cardTitleField, "card title");
        waitUntilElementIsVisible(By.cssSelector(".js-card-title"), 5);
        driver.findElement(By.cssSelector(".js-add-card")).click();
        driver.findElement(By.cssSelector(".js-cancel")).click();
        waitUntilElementIsInvisible(By.cssSelector(".js-cancel"), 5);

    }


    @Test
    public void archiveList() throws InterruptedException {
        List<WebElement> existList = driver.findElements(By.cssSelector(".js-editing-target"));
        if (existList.size() > 0) {
            System.out.println("Before the archive, the number of list " + existList.size());
            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            WebElement archiveList = driver.findElement(By.cssSelector(".js-close-list"));
            archiveList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-close-list"), 5);
        } else {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");
            waitUntilElementIsVisible(By.cssSelector("input[name='name']"), 3);

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-save-edit"), 2);

            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            WebElement archiveList = driver.findElement(By.cssSelector(".js-close-list"));
            archiveList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-close-list"), 5);


        }


        List<WebElement> existList2 = driver.findElements(By.cssSelector(".js-editing-target"));
        System.out.println("Before the archive, the number of list " + existList2.size());
        Assert.assertEquals(existList.size(), existList2.size());

    }


    @Test
    public void copyList() throws InterruptedException {
        List<WebElement> existList = driver.findElements(By.cssSelector(".js-editing-target"));
        if (existList.size() > 0) {
            System.out.println("Before the copy, the number of list " + existList.size());
            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            WebElement copyList = driver.findElement(By.cssSelector(".js-copy-list"));
            copyList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-copy-list"), 5);
        } else {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");
            waitUntilElementIsVisible(By.cssSelector("input[name='name']"), 3);

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-save-edit"), 2);

            System.out.println("Before the copy, the number of list " + existList.size());
            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            WebElement copyList = driver.findElement(By.cssSelector(".js-copy-list"));
            copyList.click();
            waitUntilElementIsClickable(By.cssSelector(".js-copy-list"), 5);


        }


        List<WebElement> existList2 = driver.findElements(By.cssSelector(".js-editing-target"));
        System.out.println("Before the copy, the number of list " + existList2.size());
        Assert.assertEquals(existList.size(), existList2.size());

    }
}









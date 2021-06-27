package com.company.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests extends TestBase {
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        Thread.sleep(1000);

        WebElement userField = driver.findElement(By.cssSelector("#user"));
        editField(userField, LOGIN);
        Thread.sleep(1000);

        WebElement loginField = driver.findElement(By.cssSelector("#login"));
        loginField.click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        editField(password, PASSWORD);
        Thread.sleep(3000);

        WebElement loginInField = driver.findElement(By.id("login-submit"));
        loginInField.click();
        Thread.sleep(15000);


        this.driver.findElement(By.xpath("//a[@data-test-id = 'home-team-boards-tab']")).click();
        Thread.sleep(3000L);
        this.driver.findElement(By.xpath("//a[@class = 'board-tile'][.//div[@title='QA Haifa9']]")).click();
        Thread.sleep(3000L);


    }

    @Test
    public void newListCreatingTest() throws InterruptedException {

        WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
        createList.click();
        Thread.sleep(1000);

        WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
        editField(listTitle, "New");
        Thread.sleep(3000);

        WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
        saveNewList.click();
        Thread.sleep(2000L);

    }
    @Test
    public void addNewCardTest() throws InterruptedException {
        // press 'Add a card' ('Add another card')
        WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
        addCardButton.click();
        //fill in card title
        WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
        editField(cardTitleField, "card title");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".js-add-card")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-cancel")).click();
        Thread.sleep(3000);

    }

    private void editField(WebElement field, String value) {
        field.click();
        field.sendKeys(value);
    }

    @Test
    public void archiveList() throws InterruptedException {
        List<WebElement> existList = driver.findElements(By.cssSelector(".js-editing-target"));
        if (existList.size() > 0) {
            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            Thread.sleep(1000);
            WebElement archiveList = driver.findElement(By.cssSelector(".js-close-list"));
            archiveList.click();
            Thread.sleep(5000);
        } else {
            WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
            createList.click();
            Thread.sleep(1000);

            WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
            editField(listTitle, "New");
            Thread.sleep(3000);

            WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
            saveNewList.click();
            Thread.sleep(2000L);

            WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
            buttonAction.click();
            Thread.sleep(3000);
            WebElement archiveList = driver.findElement(By.cssSelector(".js-close-list"));
            archiveList.click();
            Thread.sleep(3000);


        }
    }

        @Test
        public void copyList() throws InterruptedException {
            List<WebElement> existList1 = driver.findElements(By.cssSelector(".js-editing-target"));
            if (existList1.size() > 0) {
                WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
                buttonAction.click();
                Thread.sleep(1000);
                WebElement copyList = driver.findElement(By.cssSelector(".js-copy-list"));
                copyList.click();
                Thread.sleep(1000);
                WebElement copyButton = driver.findElement(By.cssSelector(".js-submit"));
                copyButton.click();
                Thread.sleep(5000);

            } else {
                WebElement createList = driver.findElement(By.cssSelector(".placeholder"));
                createList.click();
                Thread.sleep(1000);

                WebElement listTitle = driver.findElement(By.cssSelector("input[name='name']"));
                editField(listTitle, "New");
                Thread.sleep(3000);

                WebElement saveNewList = driver.findElement(By.cssSelector(".js-save-edit"));
                saveNewList.click();
                Thread.sleep(2000L);

                WebElement buttonAction = driver.findElement(By.cssSelector(".list-header-extras"));
                buttonAction.click();
                Thread.sleep(1000);
                WebElement copyList = driver.findElement(By.cssSelector(".js-copy-list"));
                copyList.click();
                Thread.sleep(1000);
                WebElement copyButton = driver.findElement(By.cssSelector(".js-submit"));
                copyButton.click();
                Thread.sleep(5000);

            }}
            }









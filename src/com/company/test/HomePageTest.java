package com.company.test;

import com.company.pages.HomePageHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests(){
        homePage = new HomePageHelper(driver);
        homePage.waitUntilPageIsLoaded();
    }

    @Test
    public void verifyApplTest(){
        Assert.assertTrue(homePage.isCorrectPage());

    }
}

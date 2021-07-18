package com.company.test;

import com.company.pages.HomePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
   @Test
    public void verifyApplTest(){
        Assert.assertTrue(homePage.isCorrectPage());

    }
}

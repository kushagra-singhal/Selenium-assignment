package com.amazon.qa.tests;

import com.amazon.qa.base.BaseTest;
import com.amazon.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.amazon.qa.pages.ShoppingCartPage.txtQuantity;
//import static com.amazon.qa.utility.testUtil.screenShotFailedTestCases;

public class WithOutLoginCredentialsTest extends BaseTest {
    HomePage homePage;
    TodaySDealsPage todaySDealsPage;
    AddToCartPage addToCartPage;
   ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;

    int dealsCount=2;

    public WithOutLoginCredentialsTest() throws IOException {
        super();
    }
    @BeforeClass
    public void setup() throws IOException {
        initialization();
        homePage=new HomePage();
        todaySDealsPage=new TodaySDealsPage();
        addToCartPage=new AddToCartPage();
        productsPage=new ProductsPage();
        shoppingCartPage=new ShoppingCartPage();

    }
    @BeforeMethod
    public void screenShotTest() throws IOException {
//        screenShotFailedTestCases();
    }
    @AfterClass()
    public void closeBrowser()
   {
       driver.close();
   }


    @Test(priority = 1)
    public void verifyHomePage()
    {
        Boolean logo=homePage.seeAmazonLogo();
        Assert.assertTrue(logo);
            }
    @Test(priority=2)
    public void verifyTodaySDeals() throws IOException {
        Boolean flag=homePage.validateTodaySDealBtn();
        Assert.assertTrue(flag);
        todaySDealsPage=homePage.clickOnTodaySDeals();

        String title=todaySDealsPage.verifyTodaySDealPage();

        Assert.assertEquals(title,"Amazon.in - Deals");


    }
    @Test(priority=3)
    public void verifyAddingOfThirdDealToCart() throws IOException, InterruptedException {
       todaySDealsPage.clickOnThirdDeal(dealsCount);
        todaySDealsPage.clickOnThirdDealInnerProduct();

       addToCartPage.selectQuantityPage();
       addToCartPage.addToCartProduct();

    }
    @Test(priority=4)
    public void verifyMinimumQuantitiesAdded() throws IOException {
        homePage.clickOnCart();
        String verify= shoppingCartPage.verifyCartPage();
        Assert.assertEquals(verify,"Subtotal ("+txtQuantity+" items):");


    }

    //Search for mobiles
    @Test(priority=5)
    public void verifySearchBarFunctionality()
    {
        Boolean flag=homePage.verifySearchBarFunctionalityPage();
        Assert.assertTrue(flag);
        homePage.searchMobile();
    }
    @Test(priority=6)
    public void verifyGettingOfLastMobileDetails() {
        productsPage.mobileDisplayPage();
        String lastDisplayTxt = productsPage.verifyScrollPage();
        Assert.assertEquals(lastDisplayTxt, "Related searches");
        productsPage.mobileLastDisplayItem();
        homePage.windowsHandle();
//        String title = homePage.childWindow();
//        Assert.assertEquals(title, "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
    }
    @Test(priority=7)
    public void verifyNavigatingBackToHomeTest()
    {
       String parentWindowTitle=homePage.verifyNavigatingBackToHomePage();
       Assert.assertEquals(parentWindowTitle,"Amazon.in : mobiles");
    }



    }




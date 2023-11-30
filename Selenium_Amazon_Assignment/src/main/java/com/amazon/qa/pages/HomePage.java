package com.amazon.qa.pages;

import com.amazon.qa.utility.testUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.amazon.qa.base.BaseTest.driver;

public class HomePage extends testUtil {
     public static String txtUserName;


     @FindBy(id="nav-logo-sprites")WebElement logo;
     //click on Today's Deals
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement todaySDeals;
    //click on cart
    @FindBy(id="nav-cart-text-container")WebElement cartBtn;
    //search bar
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")WebElement searchMobile;
    By visibleSearch=By.xpath("//input[@id='twotabsearchtextbox']");
    //verify Searchbar
    @FindBy(id="nav-search-submit-button")WebElement searchbar;
    //Child Window
    @FindBy(css=".hm-icon-label")WebElement navigateToAll;

    @FindBy(xpath="//div[text()='Mobiles, Computers']")WebElement selectMobiles;
    @FindBy(xpath="//a[text()='All Mobile Phones']") WebElement selectAllMobilePhones;
//        By visibleMobilePhones=By.xpath("//a[text()='All Mobile Phones']");
    @FindBy(xpath="//a[text()='All Mobile Phones']") WebElement visibleMobilePhones;
    //Sign in to account
    @FindBy(xpath="//div[@class='nav-line-1-container']/span")WebElement signInBtn;
    //verify After login page with txt
    @FindBy(xpath="//span[contains(text(),'Hello,')]")WebElement verifyTxtBtn;
    //click on Order
    @FindBy(id="nav-orders")WebElement clickOnOrder;




public HomePage()
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public TodaySDealsPage clickOnTodaySDeals()
    {
        todaySDeals.click();
        return new TodaySDealsPage();
    }
    public Boolean seeAmazonLogo()
    {
        boolean flag=logo.isDisplayed();
        return flag;
    }
    public Boolean validateTodaySDealBtn()
    {
      Boolean flag=todaySDeals.isEnabled();
      return flag;
    }
    public void clickOnCart()
    {
        cartBtn.click();
    }
    public void searchMobile()
    {
        visibilityOfWait(visibleSearch);
        searchMobile.sendKeys("mobiles",Keys.ENTER);
    }

    public Boolean verifySearchBarFunctionalityPage()
    {
       Boolean flag= searchbar.isEnabled();
       return flag;
    }
    public String childWindow()
    {

        navigateToAll.click();
        selectMobiles.click();
//        visibilityOfWait(visibleMobilePhones);
        visibleMobilePhones.click();
        selectAllMobilePhones.click();
       String title= driver.getTitle();
        System.out.println(title);
        return title;


    }
    public  String verifyNavigatingBackToHomePage()
    {
        navigateBack();
        driver.switchTo().window(parentWindow);
        String parentWindowTitle=driver.getTitle();
        System.out.println(parentWindowTitle);
        return parentWindowTitle;
    }

    public Boolean verifySignInHomePage()
    {
       Boolean flag=signInBtn.isEnabled();
       return flag;
    }
    public void clickOnSignIn()
    {
        signInBtn.click();
    }
    public String verifySignInPage()
    {
       String title=driver.getTitle();
       return title;
    }
    public String verifyAfterLoginPage()
    {
        String verifyAfterLogin=verifyTxtBtn.getText();
        System.out.println(verifyAfterLogin);//Hello, pradad
       // String[] txtSplit=verifyAfterLogin.split(",");
         //txtUserName=txtSplit[1];//pradad
        //System.out.println(txtUserName);
        return verifyAfterLogin;
    }
    public void clickOnOrderPage()
    {
        clickOnOrder.click();
    }

}

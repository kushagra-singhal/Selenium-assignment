package com.amazon.qa.pages;

import com.amazon.qa.utility.testUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.amazon.qa.base.BaseTest.driver;

public class ProductsPage extends testUtil {

    @FindBy(css=".sg-col-inner")
    List<WebElement> mobileLastDisplay;
    By visible= By.cssSelector(".sg-col-inner");
    //Last display item
    @FindBy(xpath="//img[@data-image-index='22']")WebElement lastDisplayItem;
    //verify the lastDisplayed item and scroll
    @FindBy(xpath="//span[contains(text(),'Related searches')]")WebElement verifyScroll;
    public ProductsPage()
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> mobileDisplayPage()
    {
        visibilityOfWait(visible);
        System.out.println("Mobile display size:"+mobileLastDisplay.size());
        javaScriptExecutor();
        // WebElement lastDisplayItem=mobileLastDisplay.get(mobileLastDisplay.size()-1);
      // System.out.println(lastDisplayItem);
        return mobileLastDisplay;
    }
    public String verifyScrollPage()
    {
        String lastTxt=verifyScroll.getText();
        System.out.println(lastTxt);
        return lastTxt;
    }
    public void mobileLastDisplayItem()
    {
        lastDisplayItem.click();
    }









}

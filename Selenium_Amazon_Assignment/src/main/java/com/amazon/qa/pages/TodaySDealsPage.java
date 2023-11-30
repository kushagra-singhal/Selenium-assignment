package com.amazon.qa.pages;

import com.amazon.qa.utility.testUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.amazon.qa.base.BaseTest.driver;

public class TodaySDealsPage extends testUtil {


    //click on Today's deals
    @FindBy(xpath="//div[@data-testid='grid-deals-container']/div")List<WebElement> dealsContainer;
    By visibleContainer=By.xpath("//div[@data-testid='grid-deals-container']/div");

    //click on third deal of open no of products
    @FindBy(xpath="//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-none']/li")List<WebElement> clickOnThirdProduct;
    //div[@id='octopus-dlp-asin-stream']//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-none']/li
   By visibleThirdDeal=By.xpath("//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-none']/li");

    //verify Today's dealsPage
    @FindBy(xpath = "//h1[contains(@class,'a-spacing-micro')]") WebElement todaySDealTxt;
    public TodaySDealsPage()
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

public String verifyTodaySDealPage()
{
    String title=driver.getTitle();
    System.out.println(title);
    return title;
}

   public void clickOnThirdDeal(int count) throws IOException
    {
       visibilityOfWait(visibleContainer);
        System.out.println(dealsContainer.size());
        dealsContainer.get(count).click();

    }
    public void clickOnThirdDealInnerProduct()
    {
        visibilityOfWait(visibleThirdDeal);

        System.out.println(clickOnThirdProduct.size());
        clickOnThirdProduct.get(3).click();
    }
    /*public void getThirdDeal()
    {
        if(!(clickOnThirdDealInnerProduct(int count)))
        {
            dealsContainer.get(count).click();
        }
        else
        dealsContainer.get(count).click();

    }*/
}

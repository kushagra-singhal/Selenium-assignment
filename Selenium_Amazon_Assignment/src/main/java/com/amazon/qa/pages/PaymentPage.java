package com.amazon.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.amazon.qa.base.BaseTest.driver;

public class PaymentPage {

    @FindBy(xpath="//div[@data-card-identifier='PaymentOptions']")
    WebElement clickOnPaymentOptions;
    @FindBy(xpath="//a[@data-testid='cpe-yourAccount-header']")
    WebElement addressAccount;
    //click on manage bank accounts
   /* @FindBy(xpath="//a[text()='Manage Bank Accounts']")WebElement clkManageBankAcc;
    //click on add new account
    @FindBy(xpath="//span[normalize-space()='Add a New Bank Account']")WebElement clkAddNewAcc;
    //select radio button
    @FindBy(xpath="//input[@id='IFSC_no']/following-sibling::i ")WebElement selectRadioBtn;
    //Enter Bank name
    @FindBy(css="#enterBankNameInput")WebElement enterBankName;
    @FindBy(xpath="//ul[@style='max-height: 180px; overflow: auto;']//parent::div")
   List<WebElement> selectBankName;
   //Enter CityName
    @FindBy(css="#enterCityNameInput")WebElement enterCityName;
    @FindBy(xpath="//ul[@style='max-height: 180px; overflow: auto;']/li")List<WebElement> cities;*/






    public PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }
    public String paymentOptionsPage()
    {
        clickOnPaymentOptions.click();
       String paymentTitle=driver.getTitle();
        System.out.println(paymentTitle);
       return paymentTitle;
    }
    public void selectYourAccount()
    {
         addressAccount.click();
    }

}

package com.amazon.qa.pages;

import com.amazon.qa.utility.testUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.amazon.qa.base.BaseTest.driver;

public class OrderPage extends testUtil {


//select the delivery checkbox
    @FindBy(id="time-filter")
    WebElement selectOrder;

    //get the first order
    @FindBy(xpath="//div[@class='a-column a-span3']")WebElement getFirstOrder;////div[@class='a-column a-span3']

  //check the delivery status
    @FindBy(xpath="//a[@class='a-link-normal yohtmlc-order-details-link'][1]")WebElement viewOrder;
    @FindBy(xpath="//bdi[text()='408-8927527-0803535']")WebElement orderId;

//go to your orders
    @FindBy(xpath="//a[@title='Return to Your Orders']")WebElement yourOrder;

//check the previous order
    @FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']")WebElement selectPreOrder;
    //select your account
    @FindBy(css=".breadcrumbs__crumb a")WebElement clickOnYourAccount;
    @FindBy(xpath="//span[text()='Your Account']")WebElement selectYourAccount;



    public OrderPage(){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public String verifyOrderPage()
    {
        String orderTitle=driver.getTitle();
        System.out.println(orderTitle);
        return orderTitle;
    }
    public void selectDeliveryOrderPage()
    {
        staticDropDown(selectOrder);

    }
    public Boolean getFirstOrderPage()
    {
        getFirstOrder.click();
        boolean flag=getFirstOrder.isDisplayed();
        return flag;
    }
    public Boolean checkOrderStatus()
    {
        viewOrder.click();
       Boolean flag=orderId.isDisplayed();
       return flag;
    }
    public void returnToYourOrderPage()
    {
        yourOrder.click();
    }
    public String selectPreviousOrderPage()
    {
        Select select=new Select(selectOrder);
        select.selectByValue("year-2021");
        String previousOrderTxt=selectPreOrder.getText();
        System.out.println(previousOrderTxt);
        return previousOrderTxt;
    }
    public void clickOnYourAccountPage()
    {
        clickOnYourAccount.click();
    }
        public String selectYourAccountPage(){
        String yourAccountTitle=driver.getTitle();
        System.out.println(yourAccountTitle);
        return yourAccountTitle;
    }


}

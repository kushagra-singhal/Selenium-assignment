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

public class AddressPage extends testUtil {

    //select the Address page
    @FindBy(xpath="//h2[normalize-space()='Your Addresses']")WebElement selectAddress;
   //add new Address
    @FindBy(xpath="//div[@class='a-box first-desktop-address-tile']")WebElement addNewAdd;
    @FindBy(xpath="//span[@id='address-ui-widgets-countryCode']//span[@role='button']")WebElement clickOnCountryDropDown;
    @FindBy(xpath="//div[@class='a-popover-wrapper']//ul[@class='a-nostyle a-list-link']/li")
    List<WebElement> countries;
    //FullName
    @FindBy(xpath="//input[@name='address-ui-widgets-enterAddressFullName']")WebElement fullName;
    //mobile number
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")WebElement mobileNumber;
    //Pin Number
    @FindBy(css="#address-ui-widgets-enterAddressPostalCode")WebElement pinNumber;
    //enter address
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")WebElement address;
    //give area
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")WebElement area;
    //landmark
    @FindBy(xpath="//input[@id='address-ui-widgets-landmark']")WebElement landmark;
    //give city name
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")WebElement cityName;
    //choose state
    @FindBy(xpath="//span[@id='address-ui-widgets-enterAddressStateOrRegion']")WebElement stateDropDown;
    //select state
    @FindBy(xpath="//div[@class='a-popover-inner a-lgtbox-vertical-scroll']//ul[@role='listbox']/li")
    List<WebElement> states;
    //delivery instructions
    @FindBy(xpath="//span[@id='address-ui-widgets-addr-details-address-type-and-business-hours']//span[@data-action='a-dropdown-button']")WebElement addressType;
    @FindBy(xpath="//div[@id='a-popover-8']//ul[@role='listbox']/li")List<WebElement> addresses;
    //add address
    @FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    WebElement addAddress;
    //verify the address
    @FindBy(xpath="//*[@id=\"address-ui-widgets-AddressLineOne\"]")WebElement verifyAdd;
    public AddressPage()
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public String gotoAddressPage()
    {

        selectAddress.click();
        String addTitle=driver.getTitle();
        System.out.println(addTitle);
        return addTitle;
    }
    public void addNewAddressPage()
    {
        addNewAdd.click();
        clickOnCountryDropDown.click();
        for(WebElement country:countries)
        {
            if(country.getText().equalsIgnoreCase("India"))
            {
                country.click();
                break;
            }

        }

    }
    By clickName= By.cssSelector("#address-ui-widgets-enterAddressFullName");
    public void addressPageDetails(String fUName,String mobNm,String pinNum,
                                   String yourAdrs,String cityArea,String landMark,String cityNam)
    {
        visibilityOfWait(clickName);
        mobileNumber.sendKeys(mobNm);
        pinNumber.sendKeys(pinNum);
        address.sendKeys(yourAdrs);
        fullName.sendKeys(fUName);
        area.sendKeys(cityArea);
        landmark.sendKeys(landMark);
        cityName.sendKeys(cityNam);

    }

    By waitStates=By.xpath("//span[@id='address-ui-widgets-enterAddressStateOrRegion']");
    public void selectStates()
    {
        elementTobeClickable(waitStates);
        for(WebElement state:states)
        {
            if(state.getText().equalsIgnoreCase("UTTAR PRADESH"))
            {
                state.click();
                break;
            }

        }
    }
    By waitAddress=By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']");
public void selectAddressType()
{
    elementTobeClickable(waitAddress);
    address.click();
//    for(WebElement address:addresses)
//    {
//        if(address.getText().equalsIgnoreCase("Home (7 am – 9 pm delivery)"))
//        {
//            address.click();
//            break;
//        }
//    }
}
public void addAddressPage()
{
    addAddress.click();
}
public String verifyAddNewAddressPage()
{
    String addNewAddressTxt=verifyAdd.getText();
    System.out.println("Address text is : " + addNewAddressTxt);
    return addNewAddressTxt;
}
}

package com.amazon.qa.tests;

import com.amazon.qa.base.BaseTest;
import com.amazon.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.amazon.qa.utility.testUtil.gettingData;
import static com.amazon.qa.utility.testUtil.screenShotFailedTestCases;

public class WithLoginCredentialsTest extends BaseTest {


    HomePage homePage;
    LoginPage loginPage;
    OrderPage orderPage;
    PaymentPage paymentPage;
    AddressPage addressPage;
    public WithLoginCredentialsTest() throws IOException {
        super();

    }

    @DataProvider
    public static Object[][] getData() {
        return gettingData();
    }

    @BeforeClass
    public void setup() throws IOException {
        initialization();
         homePage=new HomePage();
         loginPage=new LoginPage();
         orderPage=new OrderPage();
         paymentPage=new PaymentPage();
         addressPage=new AddressPage();
    }
    @BeforeMethod
    public void screenShotTest() throws IOException {
        screenShotFailedTestCases();
    }
   /* @AfterClass()
    public void closeBrowser()
    {
        driver.close();
    }*/
    @Test(priority=1)
    public void verifySignInPage() throws IOException {
        Boolean flag=homePage.verifySignInHomePage();
        Assert.assertTrue(flag);

    }
    @Test(priority=2)
    public void verifyClickOnSign() throws IOException {
        homePage.clickOnSignIn();
        String title=homePage.verifySignInPage();
        Assert.assertEquals(title,"Amazon Sign In");


    }
    @Test(priority=3)
    public void verifySignInAccountTest() throws IOException {
        loginPage.signInAccount(getUserName(),getPassword());
        String verifyAfterLogin=homePage.verifyAfterLoginPage();
       // String txtUserName=homePage.verifyAfterLoginPage();
      // Assert.assertEquals(verifyAfterLogin,"Hello,"+getSignInName()+"");
        Assert.assertEquals(verifyAfterLogin,"Hello, UserA");





    }
    @Test(priority=4)
     public void verifyClickOnOrderTest() throws IOException {
        homePage.clickOnOrderPage();
        String orderPageTitle=orderPage.verifyOrderPage();
        Assert.assertEquals(orderPageTitle,"Your Orders");


    }
    @Test(priority=5)
    public void verifySelectDeliveryOrderTest()
    {
        orderPage.selectDeliveryOrderPage();
    }
    @Test(priority=6, enabled = false)
    public void verifyGetFirstOrderTest()
    {
       Boolean flag=orderPage.getFirstOrderPage();
       Assert.assertTrue(flag);
    }
    @Test(priority=7, enabled = false)
    public void verifyViewOrderStatusTest()
    {
        Boolean flag=orderPage.checkOrderStatus();
        Assert.assertTrue(flag);
    }
    @Test(priority=8, enabled = false)
    public void verifyReturnToYourOrderTest() {
    orderPage.returnToYourOrderPage();
   String previousOrderTxt=orderPage.selectPreviousOrderPage();
   Assert.assertEquals(previousOrderTxt,"You have not placed any orders in 2021. View orders in 2020");

    }
    @Test(priority=9)
    public void verifyClickOnYourAccountTest()  {
        orderPage.clickOnYourAccountPage();
       String yourAccountTitle= orderPage.selectYourAccountPage();
        Assert.assertEquals(yourAccountTitle,"Your Account");

    }
    @Test(priority=10)
    public void verifyPaymentOptionTest()
    {
       String paymentTitle=paymentPage.paymentOptionsPage();
       Assert.assertEquals(paymentTitle,"Manage Payment Methods");
        paymentPage.selectYourAccount();

    }
    @Test(dataProvider="getData",priority=11 )
    public void verifyAddNewAddressTest(String fullUName,String mobileNum,String pinNum,
                                        String yourAddress,String cityArea,String landmarkArea,String city)
    {

       String addTitle=addressPage.gotoAddressPage();
       Assert.assertEquals(addTitle,"Your Addresses");
       addressPage.addNewAddressPage();
       addressPage.addressPageDetails(fullUName,mobileNum,pinNum,
               yourAddress,cityArea,landmarkArea,city);
       addressPage.selectStates();
       addressPage.selectAddressType();
       addressPage.addAddressPage();
       String addNewAddressTxt= addressPage.verifyAddNewAddressPage();
       Assert.assertEquals(addNewAddressTxt,yourAddress);

    }




}

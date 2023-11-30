package com.amazon.qa.pages;

import com.amazon.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseTest {

  //email
    @FindBy(xpath="//input[@id='ap_email']")
    WebElement userEmail;
    //Email continue button
  @FindBy(xpath="//span[@id='continue']")WebElement continueEmailBtn;

  //password field
  @FindBy(xpath="//input[@id='ap_password']")WebElement userPassword;
  //signIn btn
  @FindBy(id="signInSubmit")WebElement signInBtn;
    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public void signInAccount(String userName,String userPwd)
    {
      userEmail.sendKeys(userName);
      continueEmailBtn.click();
      userPassword.sendKeys(userPwd);
      signInBtn.click();
    }
}

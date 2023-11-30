package com.amazon.qa.pages;

import com.amazon.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShoppingCartPage extends BaseTest {
    public static String txtQuantity;
    @FindBy(id="sc-subtotal-label-activecart")
    WebElement verifyCart;
    public ShoppingCartPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
    public String verifyCartPage()
    {
        String verifyMsg=verifyCart.getText();
        System.out.println("Shopping cart quantity"+verifyMsg);//Subtotal (2 items):
        txtQuantity=verifyMsg.substring(10,11);
        System.out.println(txtQuantity);
        return verifyMsg;

    }

}

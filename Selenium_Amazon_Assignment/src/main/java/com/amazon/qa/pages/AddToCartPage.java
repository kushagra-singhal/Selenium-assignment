package com.amazon.qa.pages;

import com.amazon.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static com.amazon.qa.base.BaseTest.driver;

public class AddToCartPage extends BaseTest {

    @FindBy(xpath = "//select[@name='quantity']")
    WebElement selectQuantity;
    //Add to cart
    @FindBy(id="add-to-cart-button")WebElement addToCart;
    @FindBy(css="#attach-close_sideSheet-link")WebElement closeButton;

    public AddToCartPage() throws IOException {


        PageFactory.initElements(driver, this);
    }

    public void selectQuantityPage() throws InterruptedException {

        Select select = new Select(selectQuantity);
        select.selectByIndex(1);
    }

    public void addToCartProduct() throws InterruptedException {
                addToCart.click();
                closeButton.click();
    }




}




package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnCheckout() {
        return driver.findElement(By.id("checkout"));
    }

    public List<WebElement> getListOfProducts() {
        return driver.findElements(By.xpath("//div[@class='cart_item']"));
    }
    public WebElement getBtnContinueShopping(){
        return driver.findElement(By.id("continue-shopping"));
    }
}

package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final List<String> cartPageProductNameStringList = new ArrayList<>();

    public List<String> getCartPageProductNameStringList() {
        return cartPageProductNameStringList;
    }

    public WebElement getBtnCheckout() {
        return driver.findElement(By.id("checkout"));
    }

    public List<WebElement> getListOfProducts() {
        return driver.findElements(By.xpath("//div[@class='cart_item']"));
    }

    public WebElement getBtnContinueShopping() {
        return driver.findElement(By.id("continue-shopping"));
    }

    public void updateCartPageProductList() {
        List<WebElement> confPageProductList = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        for (WebElement webElement : confPageProductList) {
            cartPageProductNameStringList.add(webElement.getAttribute("id").substring(7));
        }
        Collections.sort(cartPageProductNameStringList);
    }
}

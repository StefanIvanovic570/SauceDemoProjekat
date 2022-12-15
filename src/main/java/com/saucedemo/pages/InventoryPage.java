package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    private List<String> addedProductNameStringList = new ArrayList<>();

    public List<String> getAddedProductNameStringList() {
        return addedProductNameStringList;
    }
    public WebElement getBtnAddProductToCartByName(String productName) {
        return driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]/../../..//button", productName)));
    }
    public WebElement getBtnCart() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
    public String getAddedProductName(String productName) {
        return driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", productName))).getText();
    }
    public void addProductByName(String productName) {
        addedProductNameStringList.add(getAddedProductName(productName));
        Collections.sort(addedProductNameStringList);
        getBtnAddProductToCartByName(productName).click();
    }
    public void removeAddedProducts() {
        for (String productName : addedProductNameStringList) {
            driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]/../../..//button", productName))).click();
        }
    }
}

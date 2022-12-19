package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private List<String> addedProductNameStringList = new ArrayList<>();

    public List<String> getAddedProductNameStringList() {
        return addedProductNameStringList;
    }

    public WebElement getBtnAddProductToCartByID(String productID) {
        return driver.findElement(By.id(productID));
    }

    public WebElement getBtnCart() {
        return driver.findElement(By.id("shopping_cart_container"));
    }

    public String getAddedProductName(String productID) {
        return (driver.findElement(By.xpath(String.format("//button[@id='%s']", productID))).getAttribute("id")).substring(12);
    }

    public void addProductByID(String productID) {
        addedProductNameStringList.add(getAddedProductName(productID));
        Collections.sort(addedProductNameStringList);
        getBtnAddProductToCartByID(productID).click();
    }

    public void removeAddedProducts() {
        for (String productID : addedProductNameStringList) {
            driver.findElement(By.xpath(String.format("//button[@id='remove-%s']", productID))).click();
        }
    }
}

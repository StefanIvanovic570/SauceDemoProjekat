package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartTests extends BaseTest {
    private List<String> addedProductsNames = new ArrayList<>();
    private List<WebElement> confPageProductList = new ArrayList<>();
    private List<String> confPageProductNamesList = new ArrayList<>();

    @Test
    public void addProductToCart() {
        loginUser("standard_user", "secret_sauce");
        addProductByName("Sauce Labs Bolt T-Shirt");
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), addedProductsNames.size());
    }

    @Test
    public void goToCheckout() {
        loginUser("standard_user", "secret_sauce");
        addProductByName("Sauce Labs Bolt T-Shirt");
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        fillCheckoutInformation("Test", "Test", "1337");
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(checkoutStepTwo.getBtnFinish().isDisplayed());
    }

    @Test
    public void goToCheckoutSummary() {
        goToCheckout();
        checkoutStepTwo.getBtnFinish().click();
        Assert.assertTrue(checkoutStepThree.getImgLogo().isDisplayed());
    }

    @Test
    public void verifyMultiplePurchase() {
        addedProductsNames.clear();
        loginUser("standard_user", "secret_sauce");
        addProductByName("Sauce Labs Bolt T-Shirt");
        addProductByName("Sauce Labs Onesie");
        addProductByName("Test.allTheThings() T-Shirt (Red)");
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        fillCheckoutInformation("Test", "Test", "1337");
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(assertProductList());
    }

    @Test
    public void removeProductFromCart() {
        addedProductsNames.clear();
        loginUser("standard_user", "secret_sauce");
        addProductByName("Sauce Labs Bolt T-Shirt");
        addProductByName("Sauce Labs Fleece Jacket");
        addProductByName("Sauce Labs Bike Light");
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), addedProductsNames.size());
        cartPage.getBtnContinueShopping().click();
        removeAddedProducts();
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), 0);
    }

    public void loginUser(String username, String password) {
        loginPage.openLoginPage();
        loginPage.getFieldUsername().sendKeys(username);
        loginPage.getFieldPassword().sendKeys(password);
        loginPage.getBtnLogin().click();
    }

    public void addProductByName(String productName) {
        addedProductsNames.add(loginPage.getAddedProductName(productName));
        loginPage.getBtnAddProductToCartByName(productName).click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        checkoutStepOne.getFieldFirstName().sendKeys(firstName);
        checkoutStepOne.getFieldLastName().sendKeys(lastName);
        checkoutStepOne.getFieldZipCode().sendKeys(zipCode);
    }

    public boolean assertProductList() {
        confPageProductList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < confPageProductList.size(); i++) {
            confPageProductNamesList.add(confPageProductList.get(i).getText());
        }
        Collections.sort(confPageProductNamesList);
        Collections.sort(addedProductsNames);

        return confPageProductNamesList.equals(addedProductsNames);

    }

    public void removeAddedProducts() {
        for (String productName : addedProductsNames) {
            driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]" + "/../../..//button")).click();
        }
    }
}

package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BOLT_T_SHIRT;
import static com.saucedemo.constants.Constants.SAUCE_LABS_FLEECE_JACKET;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BIKE_LIGHT;

public class RemoveProductsFromCartTest extends BaseTest {
    @Test
    public void removeProductFromCartTest() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        inventoryPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        inventoryPage.addProductByName(SAUCE_LABS_FLEECE_JACKET);
        inventoryPage.addProductByName(SAUCE_LABS_BIKE_LIGHT);
        inventoryPage.getBtnCart().click();
        Assert.assertEquals(inventoryPage.getAddedProductNameStringList().size(), cartPage.getListOfProducts().size());
        cartPage.getBtnContinueShopping().click();
        inventoryPage.removeAddedProducts();
        inventoryPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), 0);
    }
}

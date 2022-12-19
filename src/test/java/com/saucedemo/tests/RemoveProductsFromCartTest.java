package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BOLT_T_SHIRT_ID;
import static com.saucedemo.constants.Constants.SAUCE_LABS_FLEECE_JACKET_ID;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BIKE_LIGHT_ID;

public class RemoveProductsFromCartTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
    }

    @Test
    public void removeProductFromCartTest() {
        inventoryPage.addProductByID(SAUCE_LABS_BOLT_T_SHIRT_ID);
        inventoryPage.addProductByID(SAUCE_LABS_FLEECE_JACKET_ID);
        inventoryPage.addProductByID(SAUCE_LABS_BIKE_LIGHT_ID);
        inventoryPage.getBtnCart().click();
        Assert.assertEquals(inventoryPage.getAddedProductNameStringList().size(), cartPage.getListOfProducts().size());
        cartPage.getBtnContinueShopping().click();
        inventoryPage.removeAddedProducts();
        inventoryPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), 0);
    }
}

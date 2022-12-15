package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BOLT_T_SHIRT;

public class AddProductToCartTest extends BaseTest{
    @Test
    public void addProductToCartTest() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        inventoryPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        inventoryPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), 1);
    }

}

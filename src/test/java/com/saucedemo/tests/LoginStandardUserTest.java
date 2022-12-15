package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;

public class LoginStandardUserTest extends BaseTest {
    @Test
    public void standardUserLoginTest() {
        loginPage.openLoginPage();
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        loginPage.waitWebElementVisible(inventoryPage.getBtnCart());
        Assert.assertTrue(inventoryPage.getBtnCart().isDisplayed());
    }
}

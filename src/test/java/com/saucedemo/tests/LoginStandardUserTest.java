package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;

public class LoginStandardUserTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage.openLoginPage();
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
    }

    @Test
    public void standardUserLoginTest() {
        loginPage.waitWebElementVisible(inventoryPage.getBtnCart());
        Assert.assertTrue(inventoryPage.getBtnCart().isDisplayed());
    }
}

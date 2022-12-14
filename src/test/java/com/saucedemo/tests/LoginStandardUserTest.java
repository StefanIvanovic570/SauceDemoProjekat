package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;

public class LoginStandardUserTest extends BaseTest {
    @Test(groups = {"login_tests"})
    public void standardUserLoginTest() {
        loginPage.openLoginPage();
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        loginPage.waitWebElementVisible(loginPage.getBtnCart());
        Assert.assertTrue(loginPage.getBtnCart().isDisplayed());
    }
}

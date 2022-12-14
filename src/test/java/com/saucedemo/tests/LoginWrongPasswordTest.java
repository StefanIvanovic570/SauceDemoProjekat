package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.WRONG_PASSWORD;

public class LoginWrongPasswordTest extends BaseTest {
    @Test(groups = { "login_tests" })
    public void wrongPasswordLoginTest() {
        loginPage.loginUser(STANDARD_USERNAME, WRONG_PASSWORD);
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }
}

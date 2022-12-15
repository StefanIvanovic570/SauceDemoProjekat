package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.LOCKED_OUT_USER;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;

public class LoginLockedOutUserTest extends BaseTest {
    @Test
    public void lockedOutUserLoginTest() {
        loginPage.loginUser(LOCKED_OUT_USER, STANDARD_PASSWORD);
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }
}

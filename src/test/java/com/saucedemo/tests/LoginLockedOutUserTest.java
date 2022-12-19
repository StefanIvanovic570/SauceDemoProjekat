package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.LOCKED_OUT_USER;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;

public class LoginLockedOutUserTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage.loginUser(LOCKED_OUT_USER, STANDARD_PASSWORD);
    }

    @Test
    public void lockedOutUserLoginTest() {
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }
}

package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.WRONG_PASSWORD;

public class LoginWrongPasswordTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage.loginUser(STANDARD_USERNAME, WRONG_PASSWORD);
    }
    @Test
    public void wrongPasswordLoginTest() {
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }
}

package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void standardUserLoginTest() {
        loginPage.openLoginPage();

        loginPage.loginStandardUser();
        loginPage.getBtnLogin().click();
        loginPage.waitWebElementVisible(loginPage.getBtnCart());

        Assert.assertTrue(loginPage.getBtnCart().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.loginUser("standard_user", "mustard_sauce");
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }

    @Test
    public void lockedOutUserLoginTest() {
        loginPage.loginUser("locked_out_user", "secret_sauce");
        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }

}

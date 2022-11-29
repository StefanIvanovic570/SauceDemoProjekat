package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void standardUserLoginTest() {
        loginPage.openLoginPage();

        loginPage.getFieldUsername().sendKeys("standard_user");
        loginPage.getFieldPassword().sendKeys("secret_sauce");
        loginPage.getBtnLogin().click();
        loginPage.waitBtnCart();

        Assert.assertTrue(loginPage.getBtnCart().isDisplayed());
    }
    @Test
    public void wrongPasswordLoginTest(){
        loginPage.openLoginPage();

        loginPage.getFieldUsername().sendKeys("standard_user");
        loginPage.getFieldPassword().sendKeys("mustard_sauce");
        loginPage.getBtnLogin().click();

        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }
    @Test
    public void lockedOutUserLoginTest() {
        loginPage.openLoginPage();

        loginPage.getFieldUsername().sendKeys("locked_out_user");
        loginPage.getFieldPassword().sendKeys("secret_sauce");
        loginPage.getBtnLogin().click();

        loginPage.waitErrorMessageLockedOut();
        Assert.assertTrue(loginPage.getErrorLoginMessage().isDisplayed());
    }

}

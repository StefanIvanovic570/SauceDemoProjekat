package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.*;
import static com.saucedemo.constants.Constants.CHCK_INFO_ZIP_CODE;

public class CanGoToCheckoutTest extends BaseTest{
    @Test
    public void canGoToCheckoutTest() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        inventoryPage.addProductByName(SAUCE_LABS_BACKPACK);
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation(CHCK_INFO_FIRST_NAME, CHCK_INFO_LAST_NAME, CHCK_INFO_ZIP_CODE);
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(checkoutStepTwo.getBtnFinish().isDisplayed());
    }
}

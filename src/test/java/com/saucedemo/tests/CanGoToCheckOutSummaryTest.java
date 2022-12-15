package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BACKPACK;
import static com.saucedemo.constants.Constants.CHCK_INFO_FIRST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_LAST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_ZIP_CODE;


public class CanGoToCheckOutSummaryTest extends BaseTest{
    @Test
    public void canGoToCheckOutSummaryTest() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        inventoryPage.addProductByName(SAUCE_LABS_BACKPACK);
        inventoryPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation(CHCK_INFO_FIRST_NAME, CHCK_INFO_LAST_NAME, CHCK_INFO_ZIP_CODE);
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(checkoutStepTwo.getBtnFinish().isDisplayed());

        checkoutStepTwo.getBtnFinish().click();
        loginPage.waitWebElementVisible(checkoutStepThree.getImgLogo());
        Assert.assertTrue(checkoutStepThree.getImgLogo().isDisplayed());
    }
}

package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BOLT_T_SHIRT;
import static com.saucedemo.constants.Constants.SAUCE_LAB_ONESIE;
import static com.saucedemo.constants.Constants.TEST_ALLTHETHINGS_T_SHIRT_RED;
import static com.saucedemo.constants.Constants.CHCK_INFO_FIRST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_LAST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_ZIP_CODE;

public class MultiplePurchaseTest extends BaseTest {
    @Test
    public void multiplePurchaseTest() {
        inventoryPage.getAddedProductNameStringList().clear();
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
        inventoryPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        inventoryPage.addProductByName(SAUCE_LAB_ONESIE);
        inventoryPage.addProductByName(TEST_ALLTHETHINGS_T_SHIRT_RED);
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation(CHCK_INFO_FIRST_NAME, CHCK_INFO_LAST_NAME, CHCK_INFO_ZIP_CODE);
        checkoutStepOne.getBtnContinue().click();
        checkoutStepTwo.updateConfPageProductList();
        Assert.assertEquals(inventoryPage.getAddedProductNameStringList(), checkoutStepTwo.getConfPageProductNameStringList());
    }
}

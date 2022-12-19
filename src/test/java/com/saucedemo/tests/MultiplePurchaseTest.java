package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.STANDARD_USERNAME;
import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.SAUCE_LABS_BOLT_T_SHIRT_ID;
import static com.saucedemo.constants.Constants.SAUCE_LAB_ONESIE_ID;
import static com.saucedemo.constants.Constants.TEST_ALLTHETHINGS_T_SHIRT_RED_ID;
import static com.saucedemo.constants.Constants.CHCK_INFO_FIRST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_LAST_NAME;
import static com.saucedemo.constants.Constants.CHCK_INFO_ZIP_CODE;

public class MultiplePurchaseTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        loginPage.loginUser(STANDARD_USERNAME, STANDARD_PASSWORD);
    }

    @Test
    public void multiplePurchaseTest() {
        inventoryPage.addProductByID(SAUCE_LABS_BOLT_T_SHIRT_ID);
        inventoryPage.addProductByID(SAUCE_LAB_ONESIE_ID);
        inventoryPage.addProductByID(TEST_ALLTHETHINGS_T_SHIRT_RED_ID);
        inventoryPage.getBtnCart().click();
        cartPage.updateCartPageProductList();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation(CHCK_INFO_FIRST_NAME, CHCK_INFO_LAST_NAME, CHCK_INFO_ZIP_CODE);
        checkoutStepOne.getBtnContinue().click();
        Assert.assertEquals(inventoryPage.getAddedProductNameStringList(), cartPage.getCartPageProductNameStringList());
    }
}

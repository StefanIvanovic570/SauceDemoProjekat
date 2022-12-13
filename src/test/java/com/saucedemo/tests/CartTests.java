package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.constants.Constants.*;

public class CartTests extends BaseTest {
    @Test
    public void addProductToCart() {
        loginPage.loginStandardUser();
        loginPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), loginPage.getAddedProductsNames().size());
    }

    @Test
    public void goToCheckout() {
        loginPage.loginStandardUser();
        loginPage.addProductByName(SAUCE_LABS_BACKPACK);
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation();
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(checkoutStepTwo.getBtnFinish().isDisplayed());
    }

    @Test
    public void goToCheckoutSummary() {
        goToCheckout();
        checkoutStepTwo.getBtnFinish().click();
        Assert.assertTrue(checkoutStepThree.getImgLogo().isDisplayed());
    }

    @Test
    public void verifyMultiplePurchase() {
        loginPage.getAddedProductsNames().clear();
        loginPage.loginStandardUser();
        loginPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        loginPage.addProductByName(SAUCE_LAB_ONESIE);
        loginPage.addProductByName(TEST_ALLTHETHINGS_T_SHIRT_RED);
        loginPage.getBtnCart().click();
        cartPage.getBtnCheckout().click();
        checkoutStepOne.fillCheckoutInformation();
        checkoutStepOne.getBtnContinue().click();
        Assert.assertTrue(loginPage.assertProductList());
    }

    @Test
    public void removeProductFromCart() {
        loginPage.getAddedProductsNames().clear();
        loginPage.loginStandardUser();
        loginPage.addProductByName(SAUCE_LABS_BOLT_T_SHIRT);
        loginPage.addProductByName(SAUCE_LABS_FLEECE_JACKET);
        loginPage.addProductByName(SAUCE_LABS_BIKE_LIGHT);
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), loginPage.getAddedProductsNames().size());
        cartPage.getBtnContinueShopping().click();
        loginPage.removeAddedProducts();
        loginPage.getBtnCart().click();
        Assert.assertEquals(cartPage.getListOfProducts().size(), 0);
    }
}

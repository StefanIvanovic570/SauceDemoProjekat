package com.saucedemo.tests;

import com.saucedemo.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;
    protected CartPage cartPage;
    protected CheckoutStepOne checkoutStepOne;
    protected CheckoutStepTwo checkoutStepTwo;
    protected CheckoutStepThree checkoutStepThree;

    @BeforeClass
    public void classSetup() {
        System.setProperty("webdriver.chrome.driver", "F:\\aKurs COMTRADE\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepTwo = new CheckoutStepTwo(driver);
        checkoutStepThree = new CheckoutStepThree(driver);
    }

    @AfterClass
    public void classTeardown() {
        driver.close();
        driver.quit();
    }


}

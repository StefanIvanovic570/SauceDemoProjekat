package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.saucedemo.constants.Constants.*;

public class CheckoutStepOne extends BasePage {

    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    public WebElement getFieldFirstName() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getFieldLastName() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getFieldZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getBtnContinue() {
        return driver.findElement(By.id("continue"));
    }

    public void fillCheckoutInformation() {
        getFieldFirstName().sendKeys(CHCK_INFO_FIRST_NAME);
        getFieldLastName().sendKeys(CHCK_INFO_LAST_NAME);
        getFieldZipCode().sendKeys(CHCK_INFO_ZIP_CODE);
    }
}

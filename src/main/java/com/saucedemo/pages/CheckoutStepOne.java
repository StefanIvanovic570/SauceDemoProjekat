package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        getFieldFirstName().sendKeys(firstName);
        getFieldLastName().sendKeys(lastName);
        getFieldZipCode().sendKeys(zipCode);
    }
}

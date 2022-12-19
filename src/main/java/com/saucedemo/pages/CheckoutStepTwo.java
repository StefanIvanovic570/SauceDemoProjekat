package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwo extends BasePage {
    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnFinish() {
        return driver.findElement(By.id("finish"));
    }
}

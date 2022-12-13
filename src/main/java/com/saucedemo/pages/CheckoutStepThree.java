package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepThree extends BasePage {

    public CheckoutStepThree(WebDriver driver) {
        super(driver);
    }

    public WebElement getImgLogo() {
        return driver.findElement(By.xpath("//img[@alt='Pony Express']"));
    }
}

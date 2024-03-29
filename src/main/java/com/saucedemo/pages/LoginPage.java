package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public WebElement getFieldUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getBtnAddProductToCartByName(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]" + "/../../..//button"));
    }
    public String getAddedProductName(String productName){
        return driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]")).getText();
    }

    public WebElement getFieldPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getBtnLogin() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getBtnCart() {
        return driver.findElement(By.id("shopping_cart_container"));
    }

    public WebElement getErrorLoginMessage() {
        return driver.findElement(By.xpath("//h3[contains(@data-test, 'error')]"));
    }

    public void waitErrorMessageLockedOut() {
        wait.until(ExpectedConditions.visibilityOf(getErrorLoginMessage()));
    }
}

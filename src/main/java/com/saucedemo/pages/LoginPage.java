package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.saucedemo.constants.Constants.STANDARD_PASSWORD;
import static com.saucedemo.constants.Constants.STANDARD_USERNAME;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private List<String> addedProductsNames = new ArrayList<>();

    public List<String> getAddedProductsNames() {
        return addedProductsNames;
    }

    public void setAddedProductsNames(List<String> addedProductsNames) {
        this.addedProductsNames = addedProductsNames;
    }

    private List<WebElement> confPageProductList = new ArrayList<>();
    private List<String> confPageProductNamesList = new ArrayList<>();

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public WebElement getFieldUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getBtnAddProductToCartByName(String productName) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]" + "/../../..//button"));
    }

    public String getAddedProductName(String productName) {
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

    public void loginUser(String username, String password) {
        openLoginPage();
        getFieldUsername().sendKeys(username);
        getFieldPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void loginStandardUser() {
        openLoginPage();
        getFieldUsername().sendKeys(STANDARD_USERNAME);
        getFieldPassword().sendKeys(STANDARD_PASSWORD);
        getBtnLogin().click();
    }

    public void addProductByName(String productName) {
        addedProductsNames.add(getAddedProductName(productName));
        getBtnAddProductToCartByName(productName).click();
    }

    public void removeAddedProducts() {
        for (String productName : addedProductsNames) {
            driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]" + "/../../..//button")).click();
        }
    }

    public boolean assertProductList() {
        confPageProductList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < confPageProductList.size(); i++) {
            confPageProductNamesList.add(confPageProductList.get(i).getText());
        }
        Collections.sort(confPageProductNamesList);
        Collections.sort(addedProductsNames);

        return confPageProductNamesList.equals(addedProductsNames);

    }

}

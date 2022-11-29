package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public WebElement getFieldUserName(){
        return driver.findElement(By.id("user-name"));
    }
    public WebElement getFieldPassword(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getBtnLogin(){
        return driver.findElement(By.id("login-button"));
    }
}

package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutStepTwo extends BasePage {
    private final List<String> confPageProductNameStringList = new ArrayList<>();

    public List<String> getConfPageProductNameStringList() {
        return confPageProductNameStringList;
    }

    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnFinish() {
        return driver.findElement(By.id("finish"));
    }

    public void updateConfPageProductList() {
        List<WebElement> confPageProductList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (WebElement webElement : confPageProductList) {
            confPageProductNameStringList.add(webElement.getText());
            Collections.sort(confPageProductNameStringList);
        }
    }

}

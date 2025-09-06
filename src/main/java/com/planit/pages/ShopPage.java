package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage {

    // Generic locator for a product card by product name, then its Buy button
    private By buyButtonFor(String productName) {
        // Find the product tile by its title (h4) and then the Buy button within the same tile
        String xp = "//h4[normalize-space()='" + productName + "']/ancestor::div[contains(@class,'product')]//a[contains(.,'Buy')]";
        return By.xpath(xp);
    }

    private final By navCart = By.linkText("Cart");

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    /** Clicks the Buy button for the given product qty times. */
    public void buy(String productName, int qty) {
        for (int i = 0; i < qty; i++) {
            click(buyButtonFor(productName));
        }
    }

    public CartPage clickCart() {
        click(navCart);
        return new CartPage(driver);
    }
}

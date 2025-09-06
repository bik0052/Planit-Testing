package com.planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By navShop = By.linkText("Shop");
    private final By navContact = By.linkText("Contact");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ShopPage clickShop() {
        click(navShop);
        return new ShopPage(driver);
    }

    public ContactPage clickContact() {
        click(navContact);
        return new ContactPage(driver);
    }
}

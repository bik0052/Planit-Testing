
package com.planit.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By row(String product) {
        return By.xpath("//tr[.//td[normalize-space()='" + product + "']]");
    }

    private By priceCell(String product) {
        return By.xpath("//tr[.//td[normalize-space()='" + product + "']]/td[2]");
    }

    private By subtotalCell(String product) {
        return By.xpath("//tr[.//td[normalize-space()='" + product + "']]/td[last()-1]");
    }

    private final By totalCell = By.cssSelector("strong.total"); // fallback to 'strong.total' present on site

    public double getProductPrice(String product) {
        String txt = wait.until(ExpectedConditions.visibilityOfElementLocated(priceCell(product))).getText();
        return parsePrice(txt);
    }

    public double getProductSubtotal(String product) {
        String txt = wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalCell(product))).getText();
        return parsePrice(txt);
    }

    public double getTotal() {
        String txt = wait.until(ExpectedConditions.visibilityOfElementLocated(totalCell)).getText();
        return parsePrice(txt);
    }

    private double parsePrice(String text) {
        return Double.parseDouble(text.replace("$","").trim());
    }
}


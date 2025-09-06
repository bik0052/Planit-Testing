package com.planit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement rowFor(String productName) {
        // Row that has a td with the product name
        String xp = "//table//tr[td[normalize-space()='" + productName + "']]";
        return waitVisible(By.xpath(xp));
    }

    /** Returns the unit price shown in the cart row for the product. */
    public double getPrice(String productName) {
        WebElement row = rowFor(productName);
        // Heuristic: first $-containing cell in the row is the unit price
        List<WebElement> moneyCells = row.findElements(By.xpath(".//td[contains(.,'$')]"));
        if (moneyCells.isEmpty()) {
            throw new IllegalStateException("No price cells found for product: " + productName);
        }
        return parseMoney(moneyCells.get(0).getText());
    }

    /** Returns the subtotal shown in the cart row for the product. */
    public double getSubtotal(String productName) {
        WebElement row = rowFor(productName);
        // Heuristic: last $-containing cell in the row is the subtotal
        List<WebElement> moneyCells = row.findElements(By.xpath(".//td[contains(.,'$')]"));
        if (moneyCells.isEmpty()) {
            throw new IllegalStateException("No subtotal cells found for product: " + productName);
        }
        return parseMoney(moneyCells.get(moneyCells.size() - 1).getText());
    }

    /** Returns the cart total shown at the bottom of the table. */
    public double getTotal() {
        // Works with "Total: $XX.XX" found in strong/span/td, etc.
        By totalLocator = By.xpath("//*[self::strong or self::span or self::td][contains(normalize-space(),'Total') and contains(.,'$')]");
        WebElement totalEl = waitVisible(totalLocator);
        return parseMoney(totalEl.getText());
    }
}

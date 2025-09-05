package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By productRow(String productName) {
        return By.xpath("//tr[td[normalize-space()='" + productName + "']]");
    }

    private By priceCell(String productName) {
        return By.xpath("//tr[td[normalize-space()='" + productName + "']]/td[2]");
    }

    private By subtotalCell(String productName) {
        return By.xpath("//tr[td[normalize-space()='" + productName + "']]/td[4]");
    }

    private By total = By.id("total");

    public double getProductPrice(String productName) {
        String priceText = wait.until(ExpectedConditions.visibilityOfElementLocated(priceCell(productName))).getText();
        return parsePrice(priceText);
    }

    public double getProductSubtotal(String productName) {
        String subtotalText = wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalCell(productName))).getText();
        return parsePrice(subtotalText);
    }

    public double getTotal() {
        String totalText = wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText();
        return parsePrice(totalText);
    }

    private double parsePrice(String text) {
        return Double.parseDouble(text.replace("$", "").trim());
    }
}

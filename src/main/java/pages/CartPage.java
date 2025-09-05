package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getRowForProduct(String productName) {
        List<WebElement> rows = driver.findElements(By.cssSelector("table.cart tbody tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                return row;
            }
        }
        throw new RuntimeException("Product not found in cart: " + productName);
    }

    public double getProductPrice(String productName) {
        WebElement row = getRowForProduct(productName);
        return Double.parseDouble(
                row.findElement(By.cssSelector("td:nth-child(2)")).getText().replace("$", "")
        );
    }

    public double getProductSubtotal(String productName) {
        WebElement row = getRowForProduct(productName);
        return Double.parseDouble(
                row.findElement(By.cssSelector("td:nth-child(4)")).getText().replace("$", "")
        );
    }

    public double getTotal() {
        return Double.parseDouble(
                driver.findElement(By.cssSelector("strong.total"))
                      .getText()
                      .replace("Total: ", "")
                      .replace("$", "")
        );
    }
}

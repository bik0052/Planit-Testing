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

    public double getProductPrice(String product) {
        String price = driver.findElement(By.xpath("//td[text()='" + product + "']/following-sibling::td[1]")).getText().replace("$", "");
        return Double.parseDouble(price);
    }

    public double getProductSubtotal(String product) {
        String subtotal = driver.findElement(By.xpath("//td[text()='" + product + "']/following-sibling::td[3]")).getText().replace("$", "");
        return Double.parseDouble(subtotal);
    }

    public int getProductQuantity(String product) {
        WebElement qty = driver.findElement(By.xpath("//td[text()='" + product + "']/following-sibling::td[2]/input"));
        return Integer.parseInt(qty.getAttribute("value"));
    }

    public double getTotal() {
        String total = driver.findElement(By.cssSelector("tfoot .total")).getText().replace("Total: ", "").replace("$", "");
        return Double.parseDouble(total);
    }
}
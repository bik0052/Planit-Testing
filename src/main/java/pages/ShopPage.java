package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void buyProduct(String productName, int quantity) {
        By buyButton = By.xpath("//h4[text()='" + productName + "']/following-sibling::p/a");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        for (int i = 0; i < quantity; i++) {
            button.click();
        }
    }

    public void buyStuffedFrog(int qty) {
        buyProduct("Stuffed Frog", qty);
    }

    public void buyFluffyBunny(int qty) {
        buyProduct("Fluffy Bunny", qty);
    }

    public void buyValentineBear(int qty) {
        buyProduct("Valentine Bear", qty);
    }

    public void goToCart() {
        By cartLink = By.cssSelector("#nav-cart a");
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        cart.click();
    }
}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By buyButton(String productName) {
        // Find the Buy button for a given product name
        return By.xpath("//h4[text()='" + productName + "']/following-sibling::p//a[contains(text(),'Buy')]");
    }

    private By cartLink = By.linkText("Cart");

    public void buyStuffedFrog(int quantity) {
        buyProduct("Stuffed Frog", quantity);
    }

    public void buyFluffyBunny(int quantity) {
        buyProduct("Fluffy Bunny", quantity);
    }

    public void buyValentineBear(int quantity) {
        buyProduct("Valentine Bear", quantity);
    }

    private void buyProduct(String productName, int quantity) {
        for (int i = 0; i < quantity; i++) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buyButton(productName)));
            scrollIntoView(button);
            button.click();
        }
    }

    public void goToCart() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        scrollIntoView(cart);
        cart.click();
        waitForPageLoad();
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void waitForPageLoad() {
        By viewContainer = By.cssSelector("div[ng-view]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewContainer));
    }
}

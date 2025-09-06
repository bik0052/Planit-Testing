package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartLink = By.linkText("Cart");
    private final By ngView = By.cssSelector("div[ng-view]");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ngView));
    }

    private By productCard(String productName) {
        return By.xpath("//h4[normalize-space()='" + productName + "']/ancestor::li");
    }

    private By buyButton(String productName) {
        return By.xpath("//h4[normalize-space()='" + productName + "']/following::a[contains(.,'Buy')][1]");
    }

    public void buyStuffedFrog(int qty) { buyProduct("Stuffed Frog", qty); }
    public void buyFluffyBunny(int qty) { buyProduct("Fluffy Bunny", qty); }
    public void buyValentineBear(int qty) { buyProduct("Valentine Bear", qty); }

    private void buyProduct(String productName, int qty) {
        for (int i = 0; i < qty; i++) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buyButton(productName)));
            scrollIntoView(button);
            button.click();
        }
    }

    public void goToCart() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        scrollIntoView(el);
        el.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ngView));
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
}

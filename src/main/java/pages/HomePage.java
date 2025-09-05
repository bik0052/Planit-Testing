package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By contactLink = By.id("nav-contact");  // ✅ simplified locator
    private By shopLink = By.id("nav-shop");        // ✅ simplified locator
    private By cartLink = By.id("nav-cart");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // increased to 20s
    }

    public void goToContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
        waitForPageLoad();
    }

    public void goToShopPage() {
        wait.until(ExpectedConditions.elementToBeClickable(shopLink)).click();
        waitForPageLoad();
    }

    public void goToCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        waitForPageLoad();
    }

    private void waitForPageLoad() {
        // Angular ng-view takes time → wait until container is visible
        By container = By.cssSelector("div.container-fluid[ng-view]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(container));
    }
}

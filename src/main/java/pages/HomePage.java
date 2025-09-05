package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Use link text instead of fragile CSS ids
    private By contactLink = By.linkText("Contact");
    private By shopLink = By.linkText("Shop");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void goToContactPage() {
        WebElement contact = wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        scrollIntoView(contact);
        contact.click();
        waitForPageLoad();
    }

    public void goToShopPage() {
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(shopLink));
        scrollIntoView(shop);
        shop.click();
        waitForPageLoad();
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void waitForPageLoad() {
        // Wait for Angular ng-view container to show up
        By viewContainer = By.cssSelector("div[ng-view]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewContainer));
    }
}

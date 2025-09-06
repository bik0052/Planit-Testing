package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By linkContact = By.linkText("Contact");
    private final By linkShop = By.linkText("Shop");
    private final By ngView = By.cssSelector("div[ng-view]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ngView));
    }

    public void goToContactPage() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(linkContact));
        scrollIntoView(el);
        el.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ngView));
    }

    public void goToShopPage() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(linkShop));
        scrollIntoView(el);
        el.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ngView));
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}

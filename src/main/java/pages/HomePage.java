package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By contactLink = By.linkText("Contact");
    private By shopLink = By.linkText("Shop");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    public void goToShopPage() {
        wait.until(ExpectedConditions.elementToBeClickable(shopLink)).click();
    }
}
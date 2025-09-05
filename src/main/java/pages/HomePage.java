package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Navbar locators from page source
    private By contactLink = By.cssSelector("#nav-contact a");
    private By shopLink = By.cssSelector("#nav-shop a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToContactPage() {
        WebElement contact = wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        contact.click();
    }

    public void goToShopPage() {
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(shopLink));
        shop.click();
    }
}

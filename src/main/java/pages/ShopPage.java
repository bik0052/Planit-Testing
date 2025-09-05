package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By stuffedFrogBuy = By.xpath("//h4[text()='Stuffed Frog']/following-sibling::p/a");
    private By fluffyBunnyBuy = By.xpath("//h4[text()='Fluffy Bunny']/following-sibling::p/a");
    private By valentineBearBuy = By.xpath("//h4[text()='Valentine Bear']/following-sibling::p/a");
    private By cartLink = By.id("nav-cart");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void buyStuffedFrog(int qty) {
        for (int i = 0; i < qty; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(stuffedFrogBuy)).click();
        }
    }

    public void buyFluffyBunny(int qty) {
        for (int i = 0; i < qty; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(fluffyBunnyBuy)).click();
        }
    }

    public void buyValentineBear(int qty) {
        for (int i = 0; i < qty; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(valentineBearBuy)).click();
        }
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
}
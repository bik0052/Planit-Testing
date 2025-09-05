package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Form fields
    private By forenameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitButton = By.linkText("Submit");

    // Error messages
    private By forenameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");

    // Success message
    private By successMsg = By.cssSelector(".alert-success");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillMandatoryFields(String name, String email, String message) {
        driver.findElement(forenameField).clear();
        driver.findElement(forenameField).sendKeys(name);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(messageField).clear();
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getForenameError() {
        return getTextIfVisible(forenameError);
    }

    public String getEmailError() {
        return getTextIfVisible(emailError);
    }

    public String getMessageError() {
        return getTextIfVisible(messageError);
    }

    public String getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }

    private String getTextIfVisible(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            return "";
        }
    }
}

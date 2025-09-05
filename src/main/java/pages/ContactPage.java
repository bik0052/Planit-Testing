package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Fields
    private By forenameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");

    // Buttons
    private By submitButton = By.linkText("Submit");

    // Error messages
    private By forenameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");

    // Success
    private By successMsg = By.cssSelector(".alert-success");

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        scrollIntoView(submit);
        submit.click();
    }

    public void fillMandatoryFields(String forename, String email, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forenameField)).sendKeys(forename);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public String getForenameError() {
        return getTextIfPresent(forenameError);
    }

    public String getEmailError() {
        return getTextIfPresent(emailError);
    }

    public String getMessageError() {
        return getTextIfPresent(messageError);
    }

    public String getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }

    private String getTextIfPresent(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

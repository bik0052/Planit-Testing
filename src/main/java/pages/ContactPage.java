package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By forename = By.id("forename");
    private final By email = By.id("email");
    private final By message = By.id("message");
    private final By submit = By.linkText("Submit"); // falls back to anchor text
    private final By forenameErr = By.id("forename-err");
    private final By emailErr = By.id("email-err");
    private final By messageErr = By.id("message-err");
    private final By successAlert = By.cssSelector(".alert-success");

    public void clickSubmit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submit));
        scrollIntoView(btn);
        btn.click();
    }

    public void fillMandatoryFields(String name, String mail, String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forename)).clear();
        driver.findElement(forename).sendKeys(name);

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);

        driver.findElement(message).clear();
        driver.findElement(message).sendKeys(msg);
    }

    public String getForenameError() {
        return getTextIfPresent(forenameErr);
    }
    public String getEmailError() { return getTextIfPresent(emailErr); }
    public String getMessageError() { return getTextIfPresent(messageErr); }

    public String getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert)).getText();
    }

    private String getTextIfPresent(By locator) {
        try {
            return driver.findElement(locator).getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
}

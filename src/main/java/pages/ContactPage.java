package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By submitBtn = By.xpath("//a[text()='Submit']");
    private By forename = By.id("forename");
    private By email = By.id("email");
    private By message = By.id("message");
    private By successMsg = By.className("alert-success");

    private By forenameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public String getForenameError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(forenameError)).getText();
    }

    public String getEmailError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailError)).getText();
    }

    public String getMessageError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageError)).getText();
    }

    public void fillMandatoryFields(String name, String mail, String msg) {
        driver.findElement(forename).sendKeys(name);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(message).sendKeys(msg);
    }

    public String getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }
}
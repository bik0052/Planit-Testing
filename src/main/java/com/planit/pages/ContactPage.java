package com.planit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

    private final By forename = By.id("forename");
    private final By email = By.id("email");
    private final By message = By.id("message");
    private final By submitBtn = By.linkText("Submit"); // button is rendered as a styled link on this site

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void setForename(String value) {
        clearAndType(forename, value);
    }

    public void setEmail(String value) {
        clearAndType(email, value);
    }

    public void setMessage(String value) {
        clearAndType(message, value);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    /** 
     * Returns true if an error message that contains the given text is visible.
     * Works for messages like "Forename is required", "Email is required", etc.
     */
    public boolean isErrorVisible(String text) {
        // Common error classes on this site / bootstrap styles
        By anyError = By.xpath("//*[contains(@class,'error') or contains(@class,'help-inline') or contains(@class,'text-danger')][contains(normalize-space(),'" + text + "')]");
        try {
            WebElement el = driver.findElement(anyError);
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** True if no error elements are visible on the form. */
    public boolean noErrorsVisible() {
        List<WebElement> errors = driver.findElements(By.cssSelector(".help-inline, .text-danger, .error, .alert-error"));
        for (WebElement e : errors) {
            try {
                if (e.isDisplayed()) return false;
            } catch (Exception ignored) {}
        }
        return true;
    }

    /** Detects success after submission ("Thanks <name>, we appreciate your feedback."). */
    public boolean isSubmissionSuccess() {
        // The site shows a green alert or a modal with success text; check generically
        By success1 = By.cssSelector(".alert-success");
        By success2 = By.xpath("//*[contains(translate(., 'THANKS', 'thanks'), 'thanks') and contains(translate(., 'FEEDBACK', 'feedback'), 'feedback')]");
        return isDisplayed(success1) || isDisplayed(success2);
    }
}

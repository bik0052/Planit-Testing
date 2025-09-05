package com.planit.tests;

import com.planit.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactTests extends BaseTest {

    @Test(priority = 1)
    public void testCase1_validateContactErrors() {
        HomePage home = new HomePage(driver);
        home.goToContactPage();

        ContactPage contact = new ContactPage(driver);
        contact.clickSubmit();

        Assert.assertEquals(contact.getForenameError(), "Forename is required", "Forename error mismatch");
        Assert.assertEquals(contact.getEmailError(), "Email is required", "Email error mismatch");
        Assert.assertEquals(contact.getMessageError(), "Message is required", "Message error mismatch");

        contact.fillMandatoryFields("John", "john@test.com", "Hello");

        // ✅ After filling fields, all error messages should disappear
        Assert.assertTrue(
            contact.getForenameError().isEmpty() &&
            contact.getEmailError().isEmpty() &&
            contact.getMessageError().isEmpty(),
            "Some validation errors still visible after filling mandatory fields"
        );
    }

    @Test(priority = 2, invocationCount = 5)
    public void testCase2_submitContactForm() {
        HomePage home = new HomePage(driver);
        home.goToContactPage();

        ContactPage contact = new ContactPage(driver);
        contact.fillMandatoryFields("John", "john@test.com", "Automation test");
        contact.clickSubmit();

        Assert.assertTrue(
            contact.getSuccessMsg().contains("we appreciate your feedback"),
            "Success message not displayed correctly"
        );
    }
}


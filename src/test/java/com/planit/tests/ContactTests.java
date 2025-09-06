package com.planit.tests;

import org.testng.annotations.Test;
import com.planit.base.BaseTest;
import com.planit.pages.ContactPage;
import com.planit.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ContactTests extends BaseTest {

    @Test(description = "Verify mandatory error messages appear and disappear correctly")
    public void verifyErrorMessages() {
        HomePage home = new HomePage(driver);
        ContactPage contact = home.clickContact();

        // Click submit without filling
        contact.clickSubmit();
        assertTrue(contact.isErrorVisible("Forename is required"));
        assertTrue(contact.isErrorVisible("Email is required"));
        assertTrue(contact.isErrorVisible("Message is required"));

        // Fill mandatory fields
        contact.setForename("John");
        contact.setEmail("john@test.com");
        contact.setMessage("Hello!");

        // Verify errors are gone
        assertTrue(contact.noErrorsVisible());
    }

    @Test(description = "Verify successful submission message, runs 5 times", invocationCount = 5)
    public void verifySuccessfulSubmission() {
        HomePage home = new HomePage(driver);
        ContactPage contact = home.clickContact();

        contact.setForename("John");
        contact.setEmail("john@test.com");
        contact.setMessage("Automated Test Message");
        contact.clickSubmit();

        assertTrue(contact.isSubmissionSuccess());
    }
}

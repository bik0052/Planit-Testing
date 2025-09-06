package com.planit.tests;

import com.planit.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactTests extends BaseTest {

    @Test(priority = 1)
    public void validateContactErrors() {
        HomePage home = new HomePage(driver);
        home.goToContactPage();

        ContactPage contact = new ContactPage(driver);
        contact.clickSubmit();

        Assert.assertTrue(contact.getForenameError().toLowerCase().contains("forename"),
                "Forename validation not shown");
        Assert.assertTrue(contact.getEmailError().toLowerCase().contains("email"),
                "Email validation not shown");
        Assert.assertTrue(contact.getMessageError().toLowerCase().contains("message"),
                "Message validation not shown");
    }

    @Test(priority = 2)
    public void submitContactFormSuccessfully() {
        HomePage home = new HomePage(driver);
        home.goToContactPage();

        ContactPage contact = new ContactPage(driver);
        contact.fillMandatoryFields("John", "john@test.com", "Automation test");
        contact.clickSubmit();

        Assert.assertTrue(contact.getSuccessMsg().toLowerCase().contains("we appreciate your feedback"),
                "Success message not displayed correctly");
    }
}

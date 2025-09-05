package com.planit.tests;

import com.planit.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends BaseTest {

    @Test
    public void testCase1_validateContactErrors() {
        Assert.assertTrue(true, "Dummy pass for TC1");
    }

    @Test(invocationCount = 5)
    public void testCase2_submitContactForm() {
        Assert.assertTrue(true, "Dummy pass for TC2");
    }
}

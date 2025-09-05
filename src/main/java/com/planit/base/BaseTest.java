package com.planit.base;

import com.planit.config.ConfigReader;
import com.planit.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver(config.getBrowser(), config.isHeadless());
        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

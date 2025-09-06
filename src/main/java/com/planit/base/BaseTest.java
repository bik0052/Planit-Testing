package com.planit.base;

import com.planit.config.ConfigReader;
import com.planit.utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        config = new ConfigReader();
        driver = DriverFactory.createDriver(config.getBrowser(), config.isHeadless());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(config.getPageLoadTimeout()));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getExplicitWait()));

        driver.get(config.getBaseUrl());
        driver.manage().window().maximize();

        // Minor sanity: wait until Angular ng-view is present
        ((JavascriptExecutor) driver).executeScript("return document.readyState");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

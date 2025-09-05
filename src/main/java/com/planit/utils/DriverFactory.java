package com.planit.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser, boolean headless) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fOpts = new FirefoxOptions();
                if (headless) fOpts.addArguments("--headless");
                return new FirefoxDriver(fOpts);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOpts = new EdgeOptions();
                if (headless) eOpts.addArguments("--headless=new");
                return new EdgeDriver(eOpts);
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions cOpts = new ChromeOptions();
                if (headless) cOpts.addArguments("--headless=new");
                return new ChromeDriver(cOpts);
        }
    }
}

package com.itlearn.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.itlearn.utility.Browserfactory;
import com.itlearn.utility.ConfigDataProvider;

public class BaseTests {
    public WebDriver driver;
    public ConfigDataProvider config = new ConfigDataProvider();

    @BeforeClass
    public void setup() {
        driver = Browserfactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
    }

    @AfterClass
    public void tearDown() {
        Browserfactory.quitBrowser(driver);
    }

    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath = new File("." + "//Screenshots//" + testName + ".png");
        FileUtils.copyFile(src, srcpath);

    }
}

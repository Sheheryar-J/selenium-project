package com.itlearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browserfactory {
      public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl){
        if (browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "E:\\selenium-job-project\\demo\\Drivers\\chromedriver.exe");
            ChromeOptions op = new ChromeOptions();
            
            driver = new ChromeDriver(op);
        } 
        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
      }
      public static void quitBrowser(WebDriver driver){
        driver.quit();
      }
}

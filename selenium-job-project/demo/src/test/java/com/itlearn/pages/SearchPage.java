package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    // constructor
    public SearchPage(WebDriver lDriver) {
        this.driver = lDriver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@role='navigation']//input[@id='search_course']")
    WebElement searchInput;

    @FindBy(xpath = "//nav[@role='navigation']//button")
    WebElement searchbtn;

    public void searchCourse(String courseName) {
        searchInput.sendKeys(courseName);
        searchbtn.click();
    }
}

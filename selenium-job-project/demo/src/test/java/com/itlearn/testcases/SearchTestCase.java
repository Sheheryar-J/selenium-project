package com.itlearn.testcases;

import org.testng.annotations.Test;

import com.itlearn.pages.BaseTests;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.SearchPage;
import com.itlearn.utility.ReadExcelFile;

public class SearchTestCase extends BaseTests {
    String fileName = System.getProperty("user.dir") + "\\TestData\\TestPortalData.xlsx";

    @Test(priority = 1)
    void searchCourseTesr() {
        LoginPage lp = new LoginPage(driver);
        String username = ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 0);
        String password = ReadExcelFile.getCellValue(fileName, "Sheet1", 1, 1);
        lp.loginPortal(username, password);

        SearchPage sp = new SearchPage(driver);
        String searchCourse = ReadExcelFile.getCellValue(fileName, "Sheet2", 0, 0);
        sp.searchCourse(searchCourse);
    }
}

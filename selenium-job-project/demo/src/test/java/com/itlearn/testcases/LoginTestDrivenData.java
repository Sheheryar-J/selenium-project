package com.itlearn.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTests;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTestDrivenData extends BaseTests {
	String fileName = System.getProperty("user.dir") + "\\TestData\\selenium-project.xlsx";

	@Test(priority = 1, dataProvider = "LoginDataProvider")
	void verifyLogin(String userEmail, String userPwd) throws IOException {
		LoginPage p = new LoginPage(driver);
		// String username = "Sheheryar";
		// String password = "awalpindi@19";
		p.loginPortal(userEmail, userPwd);
		if (userEmail.equals("Sheheryar") && userPwd.equals("awalpindi@19")) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			p.logout();
		} else {
			captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {

		int ttlRows = ReadExcelFile.getRowCount(fileName, "Sheet1");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "Sheet1");

		String data[][] = new String[ttlRows - 1][ttlColumns];

		for (int i = 1; i < ttlRows; i++) {
			for (int j = 0; j < ttlColumns; j++) {
				data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "Sheet1", i, j);
			}
		}
		return data;
	}
}

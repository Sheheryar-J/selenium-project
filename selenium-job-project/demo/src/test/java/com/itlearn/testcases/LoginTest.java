package com.itlearn.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itlearn.pages.BaseTests;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcelFile;

public class LoginTest extends BaseTests{
      
    @Test
    void verifyLogin(String userEmail, String userPwd){
         LoginPage p = new LoginPage(driver);
         String username = "Sheheryar";
         String password = "awalpindi@19";
         p.loginPortal(username, password);
    }
   
}

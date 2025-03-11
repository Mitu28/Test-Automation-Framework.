package com.ui.tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

    public static void main(String[] args){
    	
        WebDriver wd=new ChromeDriver();//launch browser window;browser session is created
       HomePage homePage=new HomePage(wd);
      LoginPage loginpage=homePage.goToLoginPage();
      loginpage.doLoginWith("nibilaf761@lxheir.com","Password");
      
    }
}

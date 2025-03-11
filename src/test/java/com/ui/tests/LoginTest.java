package com.ui.tests;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Listeners(com.ui.listners.TestListner.class)

public class LoginTest extends TestBase {

	
Logger logger=LoggerUtility.getLogger(getClass());

  
    @Test(description="Verifies whether valid user is able to login into the application ",groups= {"e2e" ,"sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")

    public void loginTest(User user) {
    	 System.out.println("User email: " + user.getEmailAddress());
    	    System.out.println("User password: " + user.getPassword());
    	    // Check if homePage is properly initialized
    	    assertNotNull(homePage, "homePage is null");
    	assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Mits K");

    	
    }
    
    

   // @Test(description="Verifies whether valid user is able to login into the application ",groups= {"e2e" ,"sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")

    // public void loginCSVTest(User user) {
   
    // System.out.println("User email: " + user.getEmailAddress());
    //  System.out.println("User password: " + user.getPassword());
    	    // Check if homePage is properly initialized
    //  assertNotNull(homePage, "homePage is null");
    //assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Mits K");


    	
    //}
    //@Test(description="Verifies whether valid user is able to login into the application ",groups= {"e2e" ,"sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider")

    //public void loginExcelTest(User user) {
    // System.out.println("User email: " + user.getEmailAddress());
    //  System.out.println("User password: " + user.getPassword());
    	    // Check if homePage is properly initialized
    //  assertNotNull(homePage, "homePage is null");
    //assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Mits K");

    	
    // }
}

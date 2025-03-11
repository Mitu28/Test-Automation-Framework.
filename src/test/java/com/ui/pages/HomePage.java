package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
//import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public class HomePage extends BrowserUtility{
	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),\"Sign in\")]");

	public HomePage(Browser  browser,boolean isHeadless) {
		super(browser,isHeadless);//To call the parent class constructor from the child class constructor
	
		//goToWebsite(readProprty(QA, "URL"));
		goToWebsite(JSONUtility.readJson(QA));
	}
	public 	HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJson(QA));
		
		
		
	}







	public LoginPage goToLoginPage() {//page functions....cannot use void
		clickOn( SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
	
	
	

}

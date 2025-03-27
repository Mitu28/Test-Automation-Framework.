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

public class InvalidCredsLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(getClass());
	private static final String INVALID_EMAIL_ADDRESS="09mitu.choudhary@gmail.com";
	private static final String INVALID_PASSWORD="test123";

	@Test(description = "Verifies whether valid user is able to login into the application ", groups = { "e2e",
			"sanity" })
	public void loginTest() {
		
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}

}
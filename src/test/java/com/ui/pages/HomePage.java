package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.constants.Env.*; // Ensure constants like QA, etc., are properly defined


public class HomePage extends BrowserUtility {

    // Locator for the "Sign in" link
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

    // Constructor when initializing with Browser and headless flag
    public HomePage(Browser browser, boolean isHeadless) {
        super(browser, isHeadless); // Calls the parent constructor
        try {
            // Navigate to the website URL from the JSON utility
            goToWebsite(JSONUtility.readJson(QA)); // Ensure 'QA' is a valid key in the JSON
        } catch (Exception e) {
            // Add logging or handle the exception appropriately
            e.printStackTrace();
        }
    }

    // Constructor when initializing with WebDriver
    public HomePage(WebDriver driver) {
        super(driver); // Calls the parent constructor
        try {
            // Navigate to the website URL from the JSON utility
            goToWebsite(JSONUtility.readJson(QA)); // Ensure 'QA' is a valid key in the JSON
        } catch (Exception e) {
            // Add logging or handle the exception appropriately
            e.printStackTrace();
        }
    }

    // Method to navigate to the LoginPage
    public LoginPage goToLoginPage() {
        try {
            // Click the sign-in link
            clickOn(SIGN_IN_LINK_LOCATOR);
            return new LoginPage(getDriver()); // Return the LoginPage instance
        } catch (Exception e) {
            // Handle any issues, possibly logging
            e.printStackTrace();
            return null; // Return null or handle it as needed
        }
    }
}

package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility  {
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']");


	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}
	

}

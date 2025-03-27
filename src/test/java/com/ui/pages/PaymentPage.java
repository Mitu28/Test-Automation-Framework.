package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	private static final  By PAYMENT_BY_WIRE_LOCATOR=By.xpath("//*[@title='Pay by bank wire']");
	private static final  By CONFIRM_PAYMENT_BUTTON_LOCATOR=By.xpath("//*[@class='button btn btn-default button-medium']");

	private static final  By SUCCESS_MESSAGE_LOCATOR=By.xpath("//p[contains(@class,'success')]");
	//*[@title='Pay by bank wire']

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String makePaymentByWire() {
		
		clickOn(PAYMENT_BY_WIRE_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return getVisibleText(SUCCESS_MESSAGE_LOCATOR);
	
		
	}
	
}

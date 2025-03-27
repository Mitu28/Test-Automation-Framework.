package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	private static final By COMPANY_NAME_TEXT_BOX_LOCATOR=By.xpath("//input[@id='company']");
	private static final By ADDRESS1_NAME_TEXT_BOX_LOCATOR=By.xpath("//input[@id='address1']");
	private static final By ADDRESS2_NAME_TEXT_BOX_LOCATOR=By.xpath("//input[@id='address2']");
	private static final By CITY_NAME_TEXT_BOX_LOCATOR=By.xpath("//input[@id='city']");
	private static final By ZIP_POSTAL_TEXT_BOX_LOCATOR=By.xpath("//input[@id='postcode']");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR=By.xpath("//input[@id='phone']");
	private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR=By.xpath("//input[@id='phone']");
	private static final By ADDITIONAL_INFO_TEXT_BOX_LOCATOR=By.id("other");
	private static final By ADDRESS_TITLE_TEXT_BOX_LOCATOR=By.xpath("//input[@id='alias']");


    private static final By STATE_NAME_DROPDOWN_LOCATOR=By.id("id_state");
	
	
	private static final By SAVE_BUTTON_LOCATOR=By.id("submitAddress");
	private static final By ADDRESS_HEADING=By.tagName("h3");

	

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_NAME_TEXT_BOX_LOCATOR,addressPOJO.getCompany());
		enterText(ADDRESS1_NAME_TEXT_BOX_LOCATOR,addressPOJO.getAddressLine1());
		enterText(ADDRESS2_NAME_TEXT_BOX_LOCATOR,addressPOJO.getAddressLine2());
		enterText(CITY_NAME_TEXT_BOX_LOCATOR,addressPOJO.getCity());
		enterText(ZIP_POSTAL_TEXT_BOX_LOCATOR,addressPOJO.getPostCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR,addressPOJO.getHomePhoneNumber());
		enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR,addressPOJO.getMobileNumber());
		enterText(ADDITIONAL_INFO_TEXT_BOX_LOCATOR,addressPOJO.getOtherInformation());
		
		clearText(ADDRESS_TITLE_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_TITLE_TEXT_BOX_LOCATOR,addressPOJO.getAddressAlias());
		selectFromDropDown(STATE_NAME_DROPDOWN_LOCATOR,addressPOJO.getState());
		clickOn(SAVE_BUTTON_LOCATOR);
		String newAddress=getVisibleText(ADDRESS_HEADING);
		return newAddress;
		
		
		
		
		
	}

}

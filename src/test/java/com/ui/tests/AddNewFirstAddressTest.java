package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listners.TestListner.class)
public class AddNewFirstAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	
	private AddressPOJO address;

	@BeforeMethod(description = "Valid First time user logs into the application")
	public void setUp() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("nibilaf761@lxheir.com", "Password");
		address= FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verifies whether valid user is able to login into the application ", groups = { "e2e",
	"sanity" })
     public void addNewAddress() {
		String newAddress=myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());

      
	}
}




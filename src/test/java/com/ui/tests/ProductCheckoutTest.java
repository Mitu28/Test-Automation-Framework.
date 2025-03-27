package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listners.TestListner.class)
public class ProductCheckoutTest extends TestBase{

	private static final String SEARCH_TERM="Printed Summer Dress";
    private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "User logs in and searches for the product")
	public void setUp() {
		
		searchResultPage=homePage.goToLoginPage().doLoginWith("nibilaf761@lxheir.com", "Password").searchForAProduct( SEARCH_TERM);
		
	}
	
	@Test(description = "Verify if the logged in user is able to buy dress ", groups = { "e2e","smoke",
	"sanity" })
     public void checkoutTest() {
		
		
		String result=
				searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).addProductToCart().proceedToCheckout()
				
		.goToConfirmAddressPage()
		.goToShipmentPage()
		.goToPaymentPage()
		.makePaymentByWire();
		
System.out.print(result);
Assert.assertTrue(result.contains("complete"));

      
	}

}

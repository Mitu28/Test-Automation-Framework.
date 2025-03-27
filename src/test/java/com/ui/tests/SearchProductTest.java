package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;
@Listeners(com.ui.listners.TestListner.class)
public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	Logger logger = LoggerUtility.getLogger(getClass());

	

	@BeforeMethod(description = "Valid user logs into the application")
	public void setUp() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("nibilaf761@lxheir.com", "Password");
		
	}
	@Test(description = "Verifiy if the logged in user is able to search for a product and correct products search results are displayed",groups = { "e2e",
	"smoke","sanity" })
	 public void verifyProductSearchTest() {
	boolean ActualResult=myAccountPage.searchForAProduct(SEARCH_TERM).isSearchNameIsPresentInProductList(SEARCH_TERM);
	Assert.assertEquals(ActualResult, true);
		
   	
    }

}

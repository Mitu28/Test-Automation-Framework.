package com.ui.tests;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;

public class LoginTest3 {
	
	HomePage homePage;//Instance variable
	
	@BeforeMethod(description="Load the homepage of the website")
	public void setup() {
		 homePage = new HomePage(Browser.CHROME);

	}

	
	
    @Test(description ="Verifies with the valid user is able to login into the application",groups= {"e2e","sanity"})
    public void loginTest() {
	
   assertEquals(homePage.goToLoginPage().doLoginWith("nibilaf761@lxheir.com","Password").getUserName(),"Mits k");
       
       
  
    }
}

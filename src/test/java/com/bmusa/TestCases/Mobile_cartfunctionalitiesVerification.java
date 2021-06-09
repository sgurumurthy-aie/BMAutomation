package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Mobile_Basetest;

public class Mobile_cartfunctionalitiesVerification extends Mobile_Basetest{
	
	
	
	@Test
	public void verifymobilecartSummary() {
		
		mlg.mob_accountClick();
		msb.enterSearchterm("235422");
		msb.clickSearchbutton();
		mct.clicksearchandaddtocart();
		mct.clickwarranty();
		
		Assert.assertTrue(mct.cartSummary(),"Cart Summary not displayed");		
	}
	
	
	@Test
	public void verifymobileQtyUpdate() {
		mlg.mob_accountClick();
		msb.enterSearchterm("247796");
		msb.clickSearchbutton();
		mct.clicksearchandaddtocart();
				
		Assert.assertTrue(mct.cartupdate(),"Cart Summary not displayed");	
	}
	
	@Parameters({ "userName", "passWord" })
	@Test
	public void verifyInstorePickup(String username, String password) {
		mlg.mob_accountClick();
		mlg.enterUsername(username);
		mlg.enterPassword(password);
		mlg.clickonSigninButton();
		msb.enterSearchterm("218664").clickSearchbutton();
		mct.clicksearchandaddtocart();
		Assert.assertTrue(mct.inStorepickup()," instore pick up and  item remove not updated unsuccessful");
	}
}

package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_cartfunctionalitiesVerification extends Basetest{
	
	
	
	@Test
	public void verifymobilecartSummary() {
		
		lg.mob_accountClick();
		sb.enterSearchterm("235422");
		sb.clickSearchbutton();
		ct.clicksearchandaddtocart();
		ct.clickwarranty();
		
		Assert.assertTrue(ct.cartSummary(),"Cart Summary not displayed");		
	}
	
	
	@Test
	public void verifymobileQtyUpdate() {
		lg.mob_accountClick();
		sb.enterSearchterm("247796");
		sb.clickSearchbutton();
		ct.clicksearchandaddtocart();
				
		Assert.assertTrue(ct.cartupdate(),"Cart Summary not displayed");	
	}
	
	@Parameters({ "userName1", "passWord1" })
	@Test
	public void verifyMobileInstorePickup(String username, String password) {
		lg.mob_accountClick();
		/*
		 * lg.enterUsername(username); lg.enterPassword(password);
		 * lg.clickonSigninButton();
		 */
		sb.enterSearchterm("218664").clickSearchbutton();
		ct.clicksearchandaddtocart();
		Assert.assertTrue(ct.inStorepickup(username, password)," instore pick up and  item remove not updated unsuccessful");
	}
}

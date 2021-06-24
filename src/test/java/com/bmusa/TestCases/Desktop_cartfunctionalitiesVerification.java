package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_cartfunctionalitiesVerification extends Basetest {

	@Test
	public void verifycartsummary() {

		lg.loginlinkClick();
		sb.enterSearchterm("235422").clickSearchbutton();
		ct.clicksearchandaddtocart().clickwarranty();
		sb.enterSearchterm("218664").clickSearchbutton();
		ct.clicksearchandaddtocart();

		Assert.assertTrue(ct.cartSummary(), "Cart summary not available");

	}

	@Test
	public void verifyCartUpdate() {

		sb.enterSearchterm("218664").clickSearchbutton();
		ct.clicksearchandaddtocart();
		Assert.assertTrue(ct.cartupdate(), "cart qty updated unsuccessful");
	}

	@Parameters({ "userName1", "passWord1" })
	@Test
	public void verifyInstorePickup(String username, String password) {
		lg.loginlinkClick();
		/*  lg.enterUsername(username); lg.enterPassword(password);
		 * lg.clickonSigninButton();
		 */
		st.modifyzip("33312");
		sb.enterSearchterm("218664").clickSearchbutton();
		ct.clicksearchandaddtocart();
		Assert.assertTrue(ct.inStorepickup(username,password), " instore pick up and  item remove not updated unsuccessful");

	}

}

package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_userAccountVerification extends Basetest{

	
	@Parameters ({"userName","passWord"})
	@Test
	public void verifyMobileAccountnavigation(String userName, String passWord) {
		lg.mob_accountClick();
		lg.enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(up.mobileAccountNavigation(), "Mobile Account Navigation unsuccessful");
	}
	
	
	@Test 
	public void verifymobileforgotpassword() {
		lg.mob_accountClick();
		Assert.assertTrue(up.forgotpassword(), "Mobile forgotpassword unsuccessful");
	}
	
	
	@Parameters ({"userName","passWord"})
	@Test
	public void verifymobileEditProfile(String userName, String passWord) {
		lg.mob_accountClick();
		lg.enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(up.mobileeditProfile(), "Mobile Edit Profile unsuccessful");
	}
	
}

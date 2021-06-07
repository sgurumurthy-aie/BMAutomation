package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Mobile_Basetest;

public class Mobile_userAccountVerification extends Mobile_Basetest{

	@Parameters ({"userName","passWord"})
	@Test
	public void verifyMobileAccountnavigation(String userName, String passWord) {
		mlg.mob_accountClick();
		mlg.enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(mup.mobileAccountNavigation(), "Mobile Account Navigation unsuccessful");
	}
	
	
	@Test 
	public void verifymobileforgotpassword() {
		mlg.mob_accountClick();
		Assert.assertTrue(mup.forgotpassword(), "Mobile forgotpassword unsuccessful");
	}
	
	
	@Parameters ({"userName","passWord"})
	@Test
	public void verifymobileEditProfile(String userName, String passWord) {
		mlg.mob_accountClick();
		mlg.enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(mup.mobileeditProfile(), "Mobile Edit Profile unsuccessful");
	}
	
}

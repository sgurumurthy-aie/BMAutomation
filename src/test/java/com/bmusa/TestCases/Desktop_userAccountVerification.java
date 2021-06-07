package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Desktop_Basetest;

public class Desktop_userAccountVerification extends Desktop_Basetest{
	
	
	@Parameters ({"userName", "passWord"})
	@Test
	public void landingOnAccountoverviewPage(String username, String password) {
	
		lg.loginlinkClick().enterUsername(username).enterPassword(password).clickonSigninButton();
		Assert.assertTrue(up.myAccountLeftnavigation(), "not landed on Account overview Page");
		
	}

	@Test
	public void verifyforgotpassword() {
		
		lg.loginlinkClick();
		Assert.assertTrue(up.forgotpassword(), "forgot password flow unsuccessful");
		
	}
	
	@Parameters ({"userName", "passWord"})
	@Test
	
	public void verifyEditProfile(String username, String password) {
		lg.loginlinkClick().enterUsername(username).enterPassword(password).clickonSigninButton();
		Assert.assertTrue(up.editProfile(), "Update profile unsuccessful");
		
	}
}

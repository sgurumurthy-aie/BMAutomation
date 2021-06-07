
package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Desktop_Basetest;



public class Desktop_AccountVerification extends Desktop_Basetest{
	

	@Test
	public void BannerVerification() {
		


		Assert.assertTrue(lg.FlyoutBannerverification(), "Banner not found");

	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void loginverification(String userName, String passWord)  {
		
		lg.loginlinkClick().enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(lg.verifylogin(), "Login unsuccessful");
	}
	
	
	
	
	
	
	
	}


package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_AccountVerification extends Basetest {

	@Test
	public void BannerVerification() {
		Assert.assertTrue(lg.mob_bannerverification(), "Banner not found");

	}
	

	@Parameters({ "userName", "passWord" })
	@Test
	public void loginverification(String userName, String passWord) {

		lg.mob_accountClick().enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(lg.mobile_verifylogin(), "Login unsuccessful");
	}

}

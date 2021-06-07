
package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Mobile_Basetest;

public class Mobile_AccountVerification extends Mobile_Basetest {

	@Test
	public void BannerVerification() {
		Assert.assertTrue(mlg.mob_bannerverification(), "Banner not found");

	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void loginverification(String userName, String passWord) {

		mlg.mob_accountClick().enterUsername(userName).enterPassword(passWord).clickonSigninButton();
		Assert.assertTrue(mlg.mobile_verifylogin(), "Login unsuccessful");
	}

}

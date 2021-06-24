package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_SearchandBrowserVerification extends Basetest {

	@Test
	public void verifysearchasGuest() {
		sb.enterSearchterm("235422").clickSearchbutton();
		Assert.assertTrue(sb.searchProductasGuest(), "search as guest unsuccessful");
	}

	@Test
	public void verifycategory() {

		Assert.assertTrue(sb.categoryNavigation(), "category navigation unsuccessful");
	}

	@Test
	public void verifyplp() {

		Assert.assertTrue(sb.PLP(), "PLP add to cart unsuccessful");
	}

	@Test
	public void verifyplpaddtocart() {

		Assert.assertTrue(sb.PLPaddtoCart(), "PLP add to cart unsuccessful");
	}

	@Test
	public void verifypddaddtocart() {

		Assert.assertTrue(sb.PDPaddtoCart(), "pdp add to cart unsucessful");
	}
}

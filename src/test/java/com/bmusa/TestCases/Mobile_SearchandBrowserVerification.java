package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Mobile_Basetest;

public class Mobile_SearchandBrowserVerification extends Mobile_Basetest{
	
	
	@Test
	public void VerifyMobilesearchasGuest() {
		
		msb.enterSearchterm("MV7N2AMA");
		msb.clickSearchbutton();
		Assert.assertTrue(msb.Mobile_searchProductasGuest(), "Mobile Guest user search failed");
		
		
	}

	@Test
	public void verifyMobileCategoryNaviagtion() {
		
		Assert.assertTrue(msb.Mobile_categoryNavigation(),"Category navigation unsuccessful");
		
		
	}
	
	@Test
	public void verifyMobileplp() {
		Assert.assertTrue(msb.mobile_plp(), "PLP navigation unsuccessful");
	}
	
	@Test
	public void verifymobilePLPaddtocart() {
		msb.enterSearchterm("JBS360DMWWKPK");
		msb.clickSearchbutton();
		Assert.assertTrue(msb.mobilePLPaddtoCart(), "PLP add to cart unsuccessful");
	}
	
	@Test
	public void mobilePDPAddtoCart() {
		msb.enterSearchterm("JBS360DMWWKPK");
		msb.clickSearchbutton();
		Assert.assertTrue(msb.mobilePDPaddcart(), "PDP Addto cart unsuccessfful");
		
	}
	
}

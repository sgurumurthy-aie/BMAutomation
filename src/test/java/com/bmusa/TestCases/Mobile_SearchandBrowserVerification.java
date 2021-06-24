package com.bmusa.TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_SearchandBrowserVerification extends Basetest{
	
	
	
	//@Test
	public void VerifyMobilesearchasGuest() throws IOException {
		Properties config = new Properties();
		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata\\config.properties");
		config.load(fis);
		String sku= config.getProperty("searchsku");
		sb.enterSearchterm(sku);
		sb.clickSearchbutton();
		Assert.assertTrue(sb.Mobile_searchProductasGuest(), "Mobile Guest user search failed");
		
		
	}

	//@Test
	public void verifyMobileCategoryNaviagtion() {
		
		Assert.assertTrue(sb.Mobile_categoryNavigation(),"Category navigation unsuccessful");
		
		
	}
	
	//@Test
	public void verifyMobileplp() {
		Assert.assertTrue(sb.mobile_plp(), "PLP navigation unsuccessful");
	}
	
	@Test
	public void verifymobilePLPaddtocart() {
		
		Assert.assertTrue(sb.mobilePLPaddtoCart(), "PLP add to cart unsuccessful");
	}
	
	@Test
	public void mobilePDPAddtoCart() {
		
		Assert.assertTrue(sb.mobilePDPaddcart(), "PDP Addto cart unsuccessfful");
		
	}
	
}

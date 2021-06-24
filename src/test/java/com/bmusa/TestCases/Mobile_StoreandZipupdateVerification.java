package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_StoreandZipupdateVerification extends Basetest{
	
	
	@Test
	public void mobileStorelocator() {
		
		sb.mobMenuClick();
		
		Assert.assertTrue(st.mobileStorelocator(), "Mobile store locator page not loaded");
	}

}

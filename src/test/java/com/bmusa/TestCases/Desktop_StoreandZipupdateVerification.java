package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Desktop_Basetest;

public class Desktop_StoreandZipupdateVerification extends Desktop_Basetest {
	
	//@Test
	public void verifystorelocatorpage() {
		
		Assert.assertTrue(st.storeLocatortest(), "Store locator landing page unsuccessful");
		
	}

	@Test
	public void verifyzipupdate() {
		st.modifyzip("10004");
		Assert.assertTrue(st.updateZipCode(), "Zipupdate unsuccessful");
	}
	
}

package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_StoreandZipupdateVerification extends Basetest {

	@Test
	public void verifystorelocatorpage() {

		Assert.assertTrue(st.storeLocatortest(), "Store locator landing page unsuccessful");

	}

	@Test
	public void verifyzipupdate() {
		st.modifyzip("10004");
		Assert.assertTrue(st.updateZipCode(), "Zipupdate unsuccessful");
	}

}

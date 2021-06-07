package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Mobile_Basetest;

public class Mobile_StoreandZipupdateVerification extends Mobile_Basetest{
	
	@Test
	public void mobileStorelocator() {
		
		msb.mobMenuClick();
		
		Assert.assertTrue(mst.mobileStorelocator(), null);
	}

}

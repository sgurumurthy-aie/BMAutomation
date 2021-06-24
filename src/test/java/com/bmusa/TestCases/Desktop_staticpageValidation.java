package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_staticpageValidation extends Basetest{
	
	
	@Test
	public void verifyweeklyad() {
		
		Assert.assertTrue(sp.weeklyadcarouselLink(), "Weekly ad link is unsuccessful");
		
	
	}

	@Test
	public void validateClerancePage() {
		Assert.assertTrue(sp.clearancepage(), "Weekly ad link is unsuccessful");
	}
	
}

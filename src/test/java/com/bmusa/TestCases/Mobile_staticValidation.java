package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_staticValidation extends Basetest{
	
	@Test
	public void verifyMobileweeklyad() {
		
		Assert.assertTrue(sp.mobileweeklyadcarouselLink(), "Mobile Weeklyad unsucessful");
	}
	
	

}

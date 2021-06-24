package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Mobile_PaymentVerification extends Basetest{
	
	
	@Test
	@Parameters({"userName","passWord"})
	public void mobilepaypalValidation(String username, String password) {
			
		Assert.assertTrue(py.mobilevalidatepaypalpage(username, password), "mobile paypal landing failed");
	}
	
	
	@Test
	@Parameters({"userName","passWord"})
	public void mobilefortivaValidation(String username, String password) {
				
		Assert.assertTrue(py.mobilevalidateFortivaPage(username,password), "mobile fortiva landing failed");
	}
}

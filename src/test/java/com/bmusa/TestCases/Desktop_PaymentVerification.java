package com.bmusa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_PaymentVerification extends Basetest{

	
	@Test
	@Parameters ({"userName1","passWord1"})
	public void verifypaypalpage(String username, String password) {
		
		/*
		 * lg.loginlinkClick(); lg.enterUsername(username); lg.enterPassword(password);
		 * lg.clickonSigninButton();
		 */
			
		Assert.assertTrue(py.validatePaypalpage(username, password), "paypal page validation unsuccessful");
	}
	
	//@Test
	@Parameters ({"userName","passWord"})
	public void verifypayfortivapage(String username, String password) {
		
			
		Assert.assertTrue(py.validateFortivaPage(username, password), "fortiva page validation unsuccessful");
	}
}

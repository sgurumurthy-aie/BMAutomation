package com.bmusa.orderplacement.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basemethods.Basetest;

public class Desktop_Orderplacements extends Basetest{
	
	
	@Parameters({"userName","passWord"})
	@Test
	public void orderplacementVisa(String username, String password) {
		
		lg.loginlinkClick();
		lg.enterUsername(username);
		lg.enterPassword(password);
		lg.clickonSigninButton();
		
		Assert.assertTrue(ck.orderpalcement_visa(), "Order placement with VISA failed");
		
	}
	
	@Parameters({"userName","passWord"})
	@Test
	public void orderplacementmasterCard(String username, String password) {
		
		lg.loginlinkClick();
		lg.enterUsername(username);
		lg.enterPassword(password);
		lg.clickonSigninButton();
		
		Assert.assertTrue(ck.orderpalcement_mastercard(), "Order placement with VISA failed");
		
	}
	
	@Parameters({"userName","passWord"})
	@Test
	public void orderplacementamexCard(String username, String password) {
		
		lg.loginlinkClick();
		lg.enterUsername(username);
		lg.enterPassword(password);
		lg.clickonSigninButton();
		
		Assert.assertTrue(ck.orderpalcement_amexcard(), "Order placement with VISA failed");
		
	}
	
	@Parameters({"userName","passWord"})
	@Test
	public void orderplacementdiscoverCard(String username, String password) {
		
		lg.loginlinkClick();
		lg.enterUsername(username);
		lg.enterPassword(password);
		lg.clickonSigninButton();
		
		Assert.assertTrue(ck.orderpalcement_discovercard(), "Order placement with VISA failed");
		
	}

}

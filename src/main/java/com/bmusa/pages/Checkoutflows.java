package com.bmusa.pages;

import org.openqa.selenium.support.PageFactory;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class Checkoutflows {

	Commonfunctionalities com = new Commonfunctionalities();

	public Checkoutflows() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean orderpalcement_visa() {
		com.sleepSeconds(5, "");
		com.enterSearchterm("217192");
		com.clickSearchbutton();
		com.sleepSeconds(5, "");
		com.addtoCartbutton();
		com.sleepSeconds(2, "");
		com.clicknothanks();
		com.sleepSeconds(5, "");
		com.clickcheckout();
		com.sleepSeconds(5, "");
		com.clickcheckoutshippingoption();
		com.sleepSeconds(5, "");
		com.clickpayment();
		com.sleepSeconds(5, "");
		com.clickccimage();
		com.sleepSeconds(5, "");
		com.clickvisacardImage();
		com.cvventer("121");
		com.sleepSeconds(5, "");
		com.clickProceedToOrder();
		com.sleepSeconds(5, "");
		com.clickplaceOrder();
		com.sleepSeconds(8, "");
		if (!(com.getOrdernumber().isBlank())) {
			ExtentFactory.getInstance().getExtent().info("Order placed with Visa card " + com.getOrdernumber());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Order not placed with Visa card " + com.getOrdernumber());
			return true;
		}

	}
	
	
	public boolean orderpalcement_mastercard() {
		com.sleepSeconds(4, "");
		com.enterSearchterm("217192");
		com.clickSearchbutton();
		com.sleepSeconds(4, "");
		com.addtoCartbutton();
		com.sleepSeconds(2, "");
		com.clicknothanks();
		com.sleepSeconds(4, "");
		com.clickcheckout();
		com.sleepSeconds(5, "");
		com.clickcheckoutshippingoption();
		com.sleepSeconds(5, "");
		com.clickpayment();
		com.sleepSeconds(5, "");
		com.clickccimage();
		com.sleepSeconds(5, "");
		com.clickmastercardImage();
		com.cvventer("121");
		com.sleepSeconds(5, "");
		com.clickProceedToOrder();
		com.sleepSeconds(5, "");
		com.clickplaceOrder();
		com.sleepSeconds(8, "");
		if (!(com.getOrdernumber().isBlank())) {
			ExtentFactory.getInstance().getExtent().info("Order placed with mastercard " + com.getOrdernumber());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Order not placed with mastercard " + com.getOrdernumber());
			return true;
		}

	}
	
	
	public boolean orderpalcement_amexcard() {
		com.sleepSeconds(4, "");
		com.enterSearchterm("217192");
		com.clickSearchbutton();
		com.sleepSeconds(4, "");
		com.addtoCartbutton();
		com.sleepSeconds(2, "");
		com.clicknothanks();
		com.sleepSeconds(4, "");
		com.clickcheckout();
		com.sleepSeconds(5, "");
		com.clickcheckoutshippingoption();
		com.sleepSeconds(5, "");
		com.clickpayment();
		com.sleepSeconds(5, "");
		com.clickccimage();
		com.sleepSeconds(5, "");
		com.clickamexcardImage();
		com.cvventer("1211");
		com.sleepSeconds(5, "");
		com.clickProceedToOrder();
		com.sleepSeconds(5, "");
		com.clickplaceOrder();
		com.sleepSeconds(8, "");
		if (!(com.getOrdernumber().isBlank())) {
			ExtentFactory.getInstance().getExtent().info("Order placed with amexcard" + com.getOrdernumber());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Order not placed with amexcard" + com.getOrdernumber());
			return true;
		}

	}
	
	public boolean orderpalcement_discovercard() {
		com.sleepSeconds(4, "");
		com.enterSearchterm("217192");
		com.clickSearchbutton();
		com.sleepSeconds(4, "");
		com.addtoCartbutton();
		com.sleepSeconds(2, "");
		com.clicknothanks();
		com.sleepSeconds(4, "");
		com.clickcheckout();
		com.sleepSeconds(5, "");
		com.clickcheckoutshippingoption();
		com.sleepSeconds(5, "");
		com.clickpayment();
		com.sleepSeconds(5, "");
		com.clickccimage();
		com.sleepSeconds(5, "");
		com.clickdiscovercardImage();
		com.cvventer("121");
		com.sleepSeconds(5, "");
		com.clickProceedToOrder();
		com.sleepSeconds(5, "");
		com.clickplaceOrder();
		com.sleepSeconds(5, "");
		if (!(com.getOrdernumber().isBlank())) {
			ExtentFactory.getInstance().getExtent().info("Order placed with discover card " + com.getOrdernumber());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Order not placed with discover card" + com.getOrdernumber());
			return true;
		}

	}

}

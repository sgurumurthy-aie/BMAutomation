package com.bmusa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class Payment {

	Commonfunctionalities com = new Commonfunctionalities();

	@FindBy(xpath = "//strong[contains(text(),'start secured checkout')]")
	private WebElement clickCheckoutButton;

	@FindBy(xpath = "//*[@id='continue-shipping']/span")
	private WebElement checkoutshippingoption;

	@FindBy(xpath = "//button[contains(text(),'CONTINUE TO PAYMENTS')]")
	private WebElement continuetoPayment;

	@FindBy(xpath = "//*[@id='payment-option']/div/ul/li[3]/input")
	private WebElement paypalimage;

	@FindBy(xpath = "//img[@alt='Check out with PayPal']")
	private WebElement paypalbutton;

	@FindBy(xpath = "//*[@id='payment-option']/div/ul/li[4]/input")
	private WebElement fortivaimage;

	@FindBy(xpath = "//button[contains(text(),'fortiva')]")
	private WebElement fortivabutton;
	
	@FindBy (xpath="//h2[contains(text(),'Account Lookup')]")
	private WebElement fortivatext;
	
	
	public Payment() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean validatePaypalpage(String username, String password) {

		com.sleepSeconds(3, "");
		com.enterSearchterm("228989");
		com.sleepSeconds(3, "");
		com.clickSearchbutton();
		com.sleepSeconds(5, "");
		com.addtoCartbutton();
		com.sleepSeconds(5, "");
		clickCheckoutButton.click();
		com.sleepSeconds(10, "");
		com.entercheckoutusername(username);
		com.entercheckoutpwdname(password);
		com.sleepSeconds(2, "");
		com.checkoutsigninBtnclick();
		com.sleepSeconds(10, "");		
		checkoutshippingoption.click();
		String cartId = com.cartID();
		com.sleepSeconds(5, "");
		continuetoPayment.click();
		com.sleepSeconds(5, "");
		paypalimage.click();
		com.sleepSeconds(5, "");
		paypalbutton.click();
		com.sleepSeconds(5, "paypal page loading");
		if (DriverFactory.getInstance().getDriver().getPageSource().contains("Pay with PayPal")) {
			ExtentFactory.getInstance().getExtent().info("paypal page loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			
		
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("paypal page not loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			return false;

		}

	}
	
	
	public boolean mobilevalidatepaypalpage(String username, String password) {
		
		com.sleepSeconds(3, "");
		com.enterSearchterm("228989");
		com.sleepSeconds(3, "");
		com.clickSearchbutton();
		com.sleepSeconds(3, "");
		com.addtoCartbutton();	
		com.sleepSeconds(3, "");
		clickCheckoutButton.click();
		com.sleepSeconds(3, "");
		com.entercheckoutusername(username);
		com.entercheckoutpwdname(password);
		com.sleepSeconds(2, "");
		com.checkoutsigninBtnclick();
		com.sleepSeconds(10, "");
		checkoutshippingoption.click();
		com.sleepSeconds(5, "");
		String cartId = com.cartID();
		continuetoPayment.click();
		com.sleepSeconds(5, "");
		paypalimage.click();
		com.sleepSeconds(5, "");
		paypalbutton.click();
		com.sleepSeconds(5, "paypal page loadingm");
		if (DriverFactory.getInstance().getDriver().getPageSource().contains("Pay with PayPal")) {
			ExtentFactory.getInstance().getExtent().info("paypal page loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			 
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("paypal page not loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			
			return false;

		}
		
		
	}
	
	

	public boolean validateFortivaPage(String username, String password) {
		
		com.sleepSeconds(3, "");
		com.enterSearchterm("228989");
		com.sleepSeconds(3, "");
		com.clickSearchbutton();
		com.sleepSeconds(5, "");
		com.addtoCartbutton();	
		com.sleepSeconds(5, "");
		clickCheckoutButton.click();
		com.sleepSeconds(5, "");
		com.entercheckoutusername(username);
		com.entercheckoutpwdname(password);
		com.sleepSeconds(2, "");
		com.checkoutsigninBtnclick();
		com.sleepSeconds(10, "");
		checkoutshippingoption.click();
		com.sleepSeconds(5, "");
		String cartId = com.cartID();
		continuetoPayment.click();
		com.sleepSeconds(5, "");;
		fortivaimage.click();
		com.sleepSeconds(5, "");
		fortivabutton.click();
		com.sleepSeconds(10, "paypal page loading");
		if (fortivatext.getText().equalsIgnoreCase("ACCOUNT LOOKUP")) {
			ExtentFactory.getInstance().getExtent().info("fortiva page loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("fortiva page not loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			return false;

		}

	}
	
	public boolean mobilevalidateFortivaPage(String username, String password) {
		//com.sleepSeconds(2, "");
		com.enterSearchterm("228989");
		com.clickSearchbutton();
		com.sleepSeconds(2, "");
		com.addtoCartbutton();
		com.sleepSeconds(2, "");
		clickCheckoutButton.click();
		com.sleepSeconds(3, "");
		com.entercheckoutusername(username);
		com.entercheckoutpwdname(password);
		com.sleepSeconds(2, "");
		com.checkoutsigninBtnclick();
		com.sleepSeconds(10, "");
		checkoutshippingoption.click();
		com.sleepSeconds(5, "");
		continuetoPayment.click();
		String cartId = com.cartID();
		com.sleepSeconds(5, ""); 
		 fortivaimage.click(); 
		 com.sleepSeconds(5, "");
		 fortivabutton.click();
		 
		com.sleepSeconds(10, "paypal page loading");
		if (fortivatext.getText().equalsIgnoreCase("ACCOUNT LOOKUP")) {
			ExtentFactory.getInstance().getExtent().info("fortiva page loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("fortiva page not loaded");
			ExtentFactory.getInstance().getExtent().info("cartID: --> " + cartId);
			
			return false;

		}

	}
	
	

}

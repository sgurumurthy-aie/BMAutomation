package com.bmusa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basemethods.Desktop_Basetest;
import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class Cartfunctionality extends Desktop_Basetest {

	Commonfunctionalities com = new Commonfunctionalities();

	@FindBy(xpath = "//*[@id='plist']/div/div/div[3]/button/span[2]")
	private WebElement searchaddtocartbtnclick;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-clp/div/div/div/div[2]/div/app-result-list/app-warranty-pop-up/div[1]/div/div/div[3]/button[1]")
	private WebElement warrantyadd;

	@FindBy(xpath = "//*[@id='summary-holder']/div/div[1]/div[1]/span[2]/strong")
	private WebElement subtotaltext;

	@FindBy(xpath = "//*[@id=\'bodyContainer']/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[2]/div/span[2]/span/app-number-plus-minus/span/span[2]/button")
	private WebElement qtyUpdate;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-cart/div[1]/app-global-msg/div")
	private WebElement qtysuccessmsg;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[2]/div/div[1]/select")
	private WebElement deliveryoption;

	@FindBy(xpath = "//select[contains(@id,'STORE')]")
	private WebElement storeOption;

	@FindBy(xpath = "//*[@id='summary-holder']/div/div[3]/button/strong")
	private WebElement clickCheckoutButton;
	
	@FindBy (xpath = "//*[@id='bodyContainer']/app-checkout/header/div/div/a/img")
	private WebElement logoClick;

	@FindBy (xpath = "//*[@id='bodyContainer']/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[5]/i")
	private WebElement deleteItem;
	
	@FindBy (xpath = "//*[@id='bodyContainer']/app-cart/div[1]/app-global-msg/div")
	private WebElement removemsg;
	
	
	//Mobile WebElement
	
	@FindBy (xpath = "//*[@id='bodyContainer']/app-cart/div[1]/div/div/form/div/div[1]/div[1]/div[1]/div[2]/a/strong")
	private WebElement mob_changeZip;
	
	
	
	public Cartfunctionality() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean cartSummary() {

		com.sleepSeconds(2, "gathering data");
		if (!subtotaltext.getText().isBlank()) {
			ExtentFactory.getInstance().getExtent().info("Total is non Empty " + subtotaltext.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Total is Empty " + subtotaltext.getText());
			return false;
		}

	}
	
	

	public boolean cartupdate() {

		com.sleepSeconds(3, "awaiting for qty click");
		qtyUpdate.click();

		com.sleepSeconds(3, "awaiting for qty click");
		if (qtysuccessmsg.getText().equalsIgnoreCase("Quantity Updated!")) {
			ExtentFactory.getInstance().getExtent().info("Quantity Updated");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Quantity Not Updated");
			return false;
		}
	}

	
	public boolean inStorepickup()  {

		com.sleepSeconds(3, "awaiting webelement to appear");
		Select devoption = new Select(deliveryoption);
		devoption.selectByVisibleText("Pickup From Store");
		com.sleepSeconds(3, "awaiting webelement to appear");
		Select store = new Select(storeOption);
		store.selectByVisibleText("Sawgrass Mills - (18 minutes away)");
		clickCheckoutButton.click();
		com.sleepSeconds(3, "Awaiting to click logo");
		logoClick.click();
		DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com/shopping-cart");
		com.sleepSeconds(3, "Awaiting to click logo");
		deleteItem.click();
		com.sleepSeconds(3, "Awaiting to click logo");
		
		if (removemsg.getText().contains("Item removed")) {
			ExtentFactory.getInstance().getExtent().info("Item removed sucessfully" +removemsg.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Item not removed");
			return false;
		}

	}

	

	public Cartfunctionality clicksearchandaddtocart() {
		com.sleepSeconds(3, "");
		searchaddtocartbtnclick.click();
		return this;
	}

	public Cartfunctionality clickwarranty() {
		com.sleepSeconds(2, "");
		warrantyadd.click();
		com.sleepSeconds(3, "");
		return this;
	}
	
	public void mobilezipupdate() {
		mob_changeZip.click();
		
		
	}
}

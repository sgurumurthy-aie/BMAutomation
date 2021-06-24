package com.bmusa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class userProfile {

	Commonfunctionalities com = new Commonfunctionalities();

	@FindBy(xpath = "//*[@id='userDropDown']")
	private WebElement dropdown;

	@FindBy(xpath = "//*[@id='options']/li[1]/div/ul/li[2]/ul/li[1]/a")
	private WebElement myaccountLink;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-my-account/section/div/app-overview/section/h1/strong")
	private WebElement accountOverview;

	@FindBy(xpath = "//a[contains(text(),'Forgot password')]")
	private WebElement forgotpwd;
	
	@FindBy (xpath = "//*[@id=\"cFpContainer\"]/div/div[2]/a")
	private WebElement mob_forwardlink;

	@FindBy(xpath = "//*[@id='login']")
	private WebElement emailText;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-forgot-password/div/div/form/div/div[2]/div[1]/div/button")
	private WebElement forgotpwdbutton;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-forgot-password/div/div/app-global-msg/div")
	private WebElement successmsg;

	@FindBy(xpath = "//*[@id='leftNavSection']/li[2]/a")
	private WebElement profilelink;

	@FindBy(xpath = "//*[@id='firstName']")
	private WebElement profilefirstname;

	@FindBy(xpath = "//*[@id='lastName']")
	private WebElement profilelastname;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-my-account/section/div/app-profile/section/form/div[2]/div/div/div/div[5]/div[1]/button")
	private WebElement updateAddress;

	// Mobile WebElements

	@FindBy(xpath = "//*[@id='options']/li[1]/div/ul/li[1]/ul/li[1]/a")
	private WebElement mob_myaccountText;

	@FindBy(xpath = "//*[@id='userDropDown2']/i")
	private WebElement mob_accountdropdown;

	@FindBy(xpath = "//*[@id=\"bodyContainer\"]/app-my-account/section/div/app-overview/section/div/div[1]/div/div/div[2]/div/div[1]/div[2]/span[2]/strong")
	private WebElement mob_emailID;

	@FindBy(xpath = "//*[@id=\"bodyContainer\"]/app-my-account/section/div/app-overview/section/div/div[1]/div/div/div[3]/button")
	private WebElement mob_editprofilebutton;

	public userProfile() {

		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean myAccountLeftnavigation() {

		com.sleepSeconds(3, "Awaiting text AccountOverview");
		dropdown.click();
		myaccountLink.click();

		com.sleepSeconds(2, "Awaiting text AccountOverview");
		if (accountOverview.getText().equals("Account Overview")) {
			ExtentFactory.getInstance().getExtent().info("Naviagted to Account Management");
			return true;

		} else {
			ExtentFactory.getInstance().getExtent().info("Not Naviagted to Account Management");
			return false;
		}
	}

	public boolean mobileAccountNavigation() {

		com.sleepSeconds(2, "awaiting login to complete");
		mob_accountdropdown.click();
		mob_myaccountText.click();
		com.sleepSeconds(2, "awaiting login to complete");
		if (mob_emailID.getText().equalsIgnoreCase("gskprod12@aie.com")) {
			ExtentFactory.getInstance().getExtent().info("Naviagted to Account Management");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Not Naviagted to Account Management");
			return false;
		}

	}

	public boolean forgotpassword() {

		com.sleepSeconds(3, "Awaiting forgot password link");
		mob_forwardlink.click();
		emailText.sendKeys("sgurumurthy@aienterprise.com");
		forgotpwdbutton.click();
		com.sleepSeconds(3, "Awaiting for successmessage");
		if (successmsg.getText().contains("Email sent successfully")) {
			ExtentFactory.getInstance().getExtent().info("Fogot password success");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Fogot password unsuccess");
			return false;

		}

	}

	public boolean editProfile() {

		com.sleepSeconds(4, "awaiting profilelink");
		dropdown.click();
		myaccountLink.click();
		com.sleepSeconds(3, "awaiting profilelink");
		profilelink.click();
		profilefirstname.clear();
		profilefirstname.sendKeys("Shashikumar");
		profilelastname.clear();
		profilelastname.sendKeys("kumarG-");
		com.sleepSeconds(3, "awaiting profilelink");
		updateAddress.click();
		com.waitTillWebElementIsVisible(accountOverview, 3);

		if (accountOverview.getText().equals("Account Overview")) {
			ExtentFactory.getInstance().getExtent().info("Update successful and navigated to Account Management");
			return true;

		} else {
			ExtentFactory.getInstance().getExtent().info("Update unsuccessful and navigated to Account Management");
			return false;
		}

	}

	public boolean mobileeditProfile() {
		com.sleepSeconds(5, "awaiting login to complete");
		mob_accountdropdown.click();
		mob_myaccountText.click();
		com.sleepSeconds(3, "awaiting login to complete");
		mob_editprofilebutton.click();
		profilefirstname.clear();
		profilefirstname.sendKeys("Shashikumar");
		com.sleepSeconds(1, "awaiting login to complete");
		profilelastname.clear();
		profilelastname.sendKeys("kumarG-");
		com.sleepSeconds(3, "awaiting profilelink");
		updateAddress.click();
		com.waitTillWebElementIsVisible(accountOverview, 3);
		if (mob_emailID.getText().equalsIgnoreCase("gskprod12@aie.com")) {
			ExtentFactory.getInstance().getExtent().info("Naviagted to Account Management");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Not Naviagted to Account Management");
			return false;
		}

	}

}

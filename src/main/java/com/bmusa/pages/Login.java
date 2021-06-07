package com.bmusa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class Login {

	public Commonfunctionalities com = new Commonfunctionalities();

	@FindBy(xpath = "//*[@id='megaNavLink']/span[1]")
	private WebElement menu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[1]/div/a[1]")
	private WebElement submenu;

	@FindBy(xpath = "//*[@id='departmentListSubTree0']/li[3]/div/p[2]/a[1]/img")
	private WebElement Flyoutimage;

	@FindBy(xpath = "//*[@id='userDropDown']")
	private WebElement dropdown;

	@FindBy(xpath = "//*[@id='userName']")
	private WebElement userName;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement passWord;

	@FindBy(xpath = "//*[@id='options']/li[1]/div/ul/li[2]/a[1]")
	private WebElement Loginlink;

	@FindBy(xpath = "//*[@id='login-form']/div[4]/button/strong")
	private WebElement signButton;

	/*
	 * Mobile related xpath
	 * 
	 */

	@FindBy(xpath = "//*[@id='checkboxLeft']")
	private WebElement mob_menu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[2]/a")
	private WebElement mob_submenu;

	@FindBy(xpath = "//*[@id='departmentList0']")
	private WebElement mob_catarrow;

	@FindBy(xpath = "//*[@id=\"departmentListSubTree0\"]/li[4]/div/p[2]/a[2]/img")
	private WebElement mob_banner;

	@FindBy(xpath = "//*[@id='userDropDown2']")
	private WebElement mob_accountlink;
	
	@FindBy (xpath = "//*[@id='userDropDown2']/i")
	private WebElement mob_accountdropdown;
	
	@FindBy(xpath = "//*[@id='options']/li[1]/div/ul/li[1]/ul/li[1]/a")
	private WebElement mob_myaccountText;

	public Login() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);

	}

	public boolean FlyoutBannerverification() {
		try {

			com.sleepSeconds(2, "waiting for Banner");
			com.mouseoveraction(menu);
			com.mouseoveraction(submenu);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Flyoutimage.isDisplayed()) {
			ExtentFactory.getInstance().getExtent().info("image displayed" + Flyoutimage.getAttribute("alt"));
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("image not displayed");
			return false;
		}

	}

	public boolean mob_bannerverification() {

		com.sleepSeconds(2, "waiting for pageload");
		mob_menu.click();
		mob_submenu.click();
		mob_catarrow.click();

		if (mob_banner.isDisplayed()) {
			ExtentFactory.getInstance().getExtent().info("Image present" + mob_banner.getAttribute("alt"));
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Image not displayed");
			return false;
		}

	}

	public boolean verifylogin() {

		com.waitTillWebElementIsVisible(dropdown);

		if (dropdown.getText().contains("Shashi")) {
			ExtentFactory.getInstance().getExtent().info("Log in successful. User Name is " + dropdown.getText());

			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Log in unsuccessful. User Name is " + dropdown.getText());
			return false;

		}
	}

	public boolean mobile_verifylogin() {

		com.sleepSeconds(2, "");
		mob_accountdropdown.click();

		if (mob_myaccountText.getText().contains("Account")) {
			ExtentFactory.getInstance().getExtent()
					.info("Log in successful. User Name is " + mob_myaccountText.getText());

			return true;
		} else {
			ExtentFactory.getInstance().getExtent()
					.info("Log in unsuccessful. User Name is " + mob_myaccountText.getText());
			return false;

		}
	}

	public Login enterUsername(String username) {
		com.clearText(userName);
		com.sleepSeconds(2, "waiting for username data to enter");
		userName.sendKeys(username);
		return this;

	}

	public Login enterPassword(String password) {
		com.clearText(passWord);
		com.sleepSeconds(1, "waiting for password data to enter");
		passWord.sendKeys(password);
		return this;

	}

	public Login loginlinkClick() {
		com.sleepSeconds(1, "wait for loginlink Element");
		Loginlink.click();
		return this;

	}

	public Login mob_accountClick() {
		com.sleepSeconds(1, "wait for loginlink Element");
		mob_accountlink.click();
		return this;

	}

	public void clickonSigninButton() {
		signButton.click();
		com.sleepSeconds(1, "wait for loginlink Element");
		//return this;

	}

}

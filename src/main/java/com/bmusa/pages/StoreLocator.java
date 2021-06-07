package com.bmusa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class StoreLocator {

	Commonfunctionalities com = new Commonfunctionalities();
	@FindBy(xpath = "//*[@id='reverseTabMegaDropDown']/li[4]/div/div/ul/li[3]/a ")
	private WebElement storelocator;

	@FindBy(xpath = "/html/body/app-root/div/app-header/header/div[2]/div[1]/div/ul/li[4]/button")
	private WebElement myZiplink;

	@FindBy(xpath = "/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[2]/form/label/input")
	private WebElement myZiptextbox;

	@FindBy(xpath = "/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[3]/button")
	private WebElement zipUpdateBtn;

	//Mobile WebElement
	
	@FindBy(xpath = "//*[@id='checkboxLeft']")
	private WebElement mob_menu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[2]/a")
	private WebElement mob_submenu;
					   
	@FindBy (xpath = "//*[@id='megaDropDown']/li[4]/div/div/ul/li[3]/a")
	private WebElement mob_storelocator;
	
	
	
	public StoreLocator() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean storeLocatortest() {

		com.sleepSeconds(2, "Awaiting storelocatorPage");
		storelocator.click();
		com.sleepSeconds(3, "Awaiting for storelocator page to load");
		String StoreText = DriverFactory.getInstance().getDriver().getTitle();
		System.out.println("StoreLocator title" + StoreText);
		if (StoreText.contains("Store Locator")) {
			ExtentFactory.getInstance().getExtent().info("Navigated to StoreLocator Page");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Not Navigated to StoreLocator Page");
			return false;
		}
	}

	
	public boolean mobileStorelocator() {
				
		//mob_menu.click();
		mob_storelocator.click();
		com.sleepSeconds(3, "Awaiting storelocatorPage");
		String StoreText = DriverFactory.getInstance().getDriver().getTitle();
		System.out.println("StoreLocator title" + StoreText);
		if (StoreText.contains("Store Locator")) {
			ExtentFactory.getInstance().getExtent().info("Navigated to StoreLocator Page");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().info("Not Navigated to StoreLocator Page");
			return false;
		}
	}
		
		
		
	
	
	
	public boolean updateZipCode() {
		
		
		com.sleepSeconds(3, "zip value update in progress");
		
		if (myZiplink.getText().contains("10004")) {
			ExtentFactory.getInstance().getExtent().info("ZipCode updated");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("Zip Code not updated");
			return false;

		}

	}
	
	
	public void modifyzip(String zip) {
		com.sleepSeconds(2, "");
		myZiplink.click();
		myZiptextbox.clear();
		myZiptextbox.sendKeys(zip);
		zipUpdateBtn.click();
		com.sleepSeconds(2, "");
		
	}

}

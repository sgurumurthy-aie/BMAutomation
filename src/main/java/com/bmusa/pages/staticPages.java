package com.bmusa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.collections.Lists;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class staticPages {

	Commonfunctionalities com = new Commonfunctionalities();
	@FindBy(xpath = "//*[@id='reverseTabMegaDropDown']/li[4]/div/div/ul/li[2]/strong/a")
	private WebElement weeklyadlink;

	@FindBy(xpath = "//a[contains( text(), 'Laundry')]/img")
	private WebElement firstlink;

	@FindBy(xpath = "//*[@class='list-inline product-category']/li/a")
	private List<WebElement> weeklyadcategorieslinks;

	@FindBy(xpath = "//*[@class='image-info-holder']/img")
	private WebElement nextlink;

	@FindBy(xpath = "//*[@class='image-info-holder']/img/following-sibling::div/span")
	private WebElement weeklyadlinknames;

	@FindBy(xpath = "//*[@class='next']")
	private WebElement nextsetCategories;
	
	@FindBy (xpath ="//a[contains(text(),'CLEARANCE DEALS')]")
	private WebElement clearanceLink;
	
	

	// Mobile WebElement

	@FindBy(xpath = "//*[@id='checkboxLeft']")
	private WebElement menu;

	@FindBy(xpath = "//ul[@class='list-unstyled list-inline']/li[2]/strong/a")
	private WebElement mobweeklyadlink;

	public staticPages() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean weeklyadcarouselLink() {

		weeklyadlink.click();
		com.sleepSeconds(4, "");
		//firstlink.click();
		//com.sleepSeconds(4, "");
		boolean test = false;

		int weeklyadcount = weeklyadcategorieslinks.size();
		int counter = 0;
		int catcounter = 0;
		int i;

		List<String> linksNames = Lists.newArrayList();

		for (int j = 0; j < weeklyadcategorieslinks.size(); j++) {
			linksNames.add(weeklyadcategorieslinks.get(j).getText());
			System.out.println(weeklyadcategorieslinks.get(j).getText());
			catcounter++;
			if (catcounter == 6 || catcounter == 12 || catcounter == 18) {
				nextsetCategories.click();
			}

		}

		for (i = 0; i < weeklyadcount - 2; i++) {

			try {
				System.out.println("value of I" + i);
				System.out.println("weeklyadlinknames data: " + weeklyadlinknames.getText());
				System.out.println("linksNames: " + linksNames.get(i));
				if (nextlink.isDisplayed() && linksNames.get(i).equals(weeklyadlinknames.getText())) {
					nextlink.click();
					if (DriverFactory.getInstance().getDriver().getPageSource().contains("page not found")) {
						ExtentFactory.getInstance().getExtent().info("Found 404 page, Kindly Check");
						break;
					}
					com.sleepSeconds(3, "");
					ExtentFactory.getInstance().getExtent().info("Page Title " + weeklyadlinknames.getText());
					test = true;
					counter++;
				} else {

				}
			} catch (Exception e) {
				if (counter == (weeklyadcount - 3)) {
					ExtentFactory.getInstance().getExtent()
							.info("Execpeted next link not to appear or found 404 page" + "counter value" + counter);
					test = true;

				} else {
					ExtentFactory.getInstance().getExtent().fail("next link not displayed");
					test = false;
				}
			}

		}
		return test;
	}
	
	
	public boolean clearancepage() {
		
		com.sleepSeconds(2, "");
		clearanceLink.click();
		com.sleepSeconds(2, "");
		if (!(DriverFactory.getInstance().getDriver().getPageSource().contains(" page not found"))) {
			ExtentFactory.getInstance().getExtent().info("clearance page displayed");
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("clerance page not displayed");
			return false;
		}
		
	}

	public boolean mobileweeklyadcarouselLink() {

		menu.click();
		mobweeklyadlink.click();
		com.sleepSeconds(4, "");
		//firstlink.click();
		com.sleepSeconds(4, "");
		boolean test = false;

		int weeklyadcount = weeklyadcategorieslinks.size();
		int counter = 0;
		int catcounter = 0;
		int i;

		List<String> linksNames = Lists.newArrayList();

		for (int j = 0; j < weeklyadcategorieslinks.size(); j++) {
			linksNames.add(weeklyadcategorieslinks.get(j).getText());
			System.out.println(weeklyadcategorieslinks.get(j).getText());
			catcounter++;
			if ( (catcounter == 3) || catcounter == 6 || catcounter == 9 || catcounter == 12 ||catcounter == 15 || catcounter == 18 ||catcounter == 21  ){
				nextsetCategories.click();
			}

		}

		for (i = 0; i < weeklyadcount - 2; i++) {

			try {
				System.out.println("value of I" + i);
				System.out.println("weeklyadlinknames data: " + weeklyadlinknames.getText());
				System.out.println("linksNames: " + linksNames.get(i));
				if (weeklyadlinknames.isDisplayed() || linksNames.get(i).equals(weeklyadlinknames.getText())) {
					weeklyadlinknames.click();
					if (DriverFactory.getInstance().getDriver().getPageSource().contains("page not found")) {
						ExtentFactory.getInstance().getExtent().info("Found 404 page, Kindly Check");
						break;
					}
					com.sleepSeconds(3, "");
					ExtentFactory.getInstance().getExtent().info("Page Title " + weeklyadlinknames.getText());
					test = true;
					counter++;
				} else {

				}
			} catch (Exception e) {
				if (counter == (weeklyadcount - 3)) {
					ExtentFactory.getInstance().getExtent()
							.info("Execpeted next link not to appear or found 404 page" + "counter value" + counter);
					test = true;

				} else {
					ExtentFactory.getInstance().getExtent().fail("next link not displayed");
					test = false;
				}
			}

		}
		return test;
	}

public boolean mobileclearancepage() {
		
		
		menu.click();
		com.sleepSeconds(2, "");
		clearanceLink.click();
		com.sleepSeconds(2, "");
		String clerancePageTitle = DriverFactory.getInstance().getDriver().getTitle();
		if (!(DriverFactory.getInstance().getDriver().getPageSource().contains(" page not found"))) {
			ExtentFactory.getInstance().getExtent().info("clearance page displayed");
			ExtentFactory.getInstance().getExtent().info("clearance page Title" + clerancePageTitle);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("clerance page not displayed");
			ExtentFactory.getInstance().getExtent().info("clearance page Title" + clerancePageTitle);
			return false;
		}
		
	}

}



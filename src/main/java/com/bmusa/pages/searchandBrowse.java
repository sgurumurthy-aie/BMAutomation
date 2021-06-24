package com.bmusa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basemethods.DriverFactory;
import basemethods.ExtentFactory;
import utility.Commonfunctionalities;

public class searchandBrowse {

	Commonfunctionalities com = new Commonfunctionalities();

	@FindBy(xpath = "//*[@id='top-search']")
	private WebElement searchtext;

	@FindBy(xpath = "//*[@id='searchBtn']")
	private WebElement searchbtn;

	@FindBy(xpath = "//*[@id='plist']/div/div/div[2]/small/span[2]")
	private WebElement getProduct;

	@FindBy(xpath = "//*[@id='megaNavLink']/span[1]")
	private WebElement menu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[1]/div/a[1]")
	private WebElement submenu;

	@FindBy(xpath = "//*[@id='departmentListSubTree0']/li[1]/ul/li[1]/a")
	private WebElement cat;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-clp/div/div/div/div[1]/app-templates/p[2]/button")
	private WebElement brandfiltertext;

	@FindBy(xpath = "//*[@id='sortOptions']")
	private WebElement sortdropdown;

	@FindBy(xpath = "//*[@id='plist']/div[3]/div/div[2]/small/span[2]")
	private WebElement plpproduct;

	@FindBy(xpath = "//*[@id='plist']/div[3]/div/div[3]/button")
	private WebElement plpaddtocart;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[1]/div[2]/a/p")
	private WebElement cartsku;

	@FindBy(xpath = "//*[@id='plist']/div[2]/div/div[2]/small/span[2]")
	private WebElement pdpproduct;

	@FindBy(xpath = "//*[@id='plist']/div[2]/div/div[1]/a[1]/div/strong")
	private WebElement pdpproductclick;
	                  
	@FindBy(xpath = "//*[@id='bodyContainer']/app-pdp/div/div/div[1]/div[3]/div[2]/button[1]")
	private WebElement pdpaddtocart;

	// Mobile WebElement details

	@FindBy(xpath = "//*[@id='checkboxLeft']")
	private WebElement mob_menu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[2]/a")
	private WebElement mob_submenu;

	@FindBy(xpath = "//*[@id='megaDropDown']/li[3]/div/a[1]")
	private WebElement mob_cat;

	@FindBy(xpath = "//*[@id='open_category_dropdwon']")
	private WebElement mob_catdropdown;

	@FindBy(xpath = "//*[@id=\"'options_' + 0\"]/a")
	private WebElement mob_catdropdownvalue;
	
	@FindBy (xpath = "//*[@id='plist']/div[1]/div/div[2]/small/span[2]")
	private WebElement mob_product;
	
	
	@FindBy (xpath = "//*[@id=\"plist\"]/div[1]/div/div[3]/button/span[2]")
	private WebElement mob_plpaddtocart;

	@FindBy (xpath = "//*[@id='plist']/div[1]/div/div[1]/a[1]/img")
	private WebElement mob_productimageClick;
	

	
	public searchandBrowse() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public boolean searchProductasGuest() {

		com.sleepSeconds(2, "waiting for the pageload");
		if (getProduct.getText().contains("MV7N2AMA")) {
			ExtentFactory.getInstance().getExtent().info("Matching SKU found" + getProduct.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent()
					.info("Matching SKU not found expected MV7N2AMA but found " + getProduct.getText());
			return false;

		}
	}

	public boolean Mobile_searchProductasGuest() {

		com.sleepSeconds(2, "waiting for the pageload");
		if (getProduct.getText().contains("MV7N2AMA")) {
			ExtentFactory.getInstance().getExtent().info("Matching SKU found" + getProduct.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent()
					.info("Matching SKU not found expected MV7N2AMA but found " + getProduct.getText());
			return false;

		}
	}

	public boolean categoryNavigation() {

		com.mouseoveraction(menu);
		com.mouseoveraction(submenu);
		cat.click();
		com.sleepSeconds(3, "waiting for the pageload");
		String plptitle = DriverFactory.getInstance().getDriver().getTitle();

		if (DriverFactory.getInstance().getDriver().getPageSource().contains(plptitle)) {
			ExtentFactory.getInstance().getExtent().info("navigated to PLP" + plptitle);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("Not navigated to PLP" + plptitle);
			return false;

		}

	}

	public boolean Mobile_categoryNavigation() {

		mob_menu.click();
		mob_submenu.click();
		mob_cat.click();
		com.sleepSeconds(1, "waiting for the pageload");
		String plptitle = DriverFactory.getInstance().getDriver().getTitle();

		if (plptitle.contains("Appliances & Housewares")) {
			ExtentFactory.getInstance().getExtent().info("navigated to PLP" + plptitle);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("Not navigated to PLP" + plptitle);
			return false;

		}

	}

	public boolean PLP() {

		com.mouseoveraction(menu);
		com.mouseoveraction(submenu);
		cat.click();
		com.sleepSeconds(3, "waiting for the pageload");
		Select select = new Select(sortdropdown);
		// String[] exp = {"Best Match / Relevancy","Price Low to High","Price High to
		// Low","New","Best Sellers","Customer Ratings",};
		List<WebElement> options = select.getOptions();
		// List<String> exp1 =new ArrayList<String>();
		for (WebElement we : options) {
			ExtentFactory.getInstance().getExtent().info(we.getText());

		}

		if (brandfiltertext.getText().contains("Brands")) {
			ExtentFactory.getInstance().getExtent().info("Brands Filter option is present" + brandfiltertext.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent()
					.fail("Brands Filter option not present" + brandfiltertext.getText());
			return false;
		}

	}

	public boolean mobile_plp() {

		mob_menu.click();
		mob_submenu.click();
		mob_cat.click();
		com.sleepSeconds(1, "");
		mob_catdropdown.click();

		if (mob_catdropdownvalue.getText().contains("Kitchen Packages")) {
			ExtentFactory.getInstance().getExtent().info("Navigated to PLP" + mob_catdropdownvalue.getText());
			System.out.println(mob_catdropdownvalue.getText());
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("Not Navigated to PLP" + mob_catdropdownvalue.getText());
			return false;
		}

	}

	public boolean PLPaddtoCart() {

		com.mouseoveraction(menu);
		com.mouseoveraction(submenu);
		cat.click();
		com.sleepSeconds(3, "waiting for the pageload");
		String plpsku = plpproduct.getText();
		plpaddtocart.click();

		com.sleepSeconds(3, "waiting for the pageload");
		if (cartsku.getText().contains(plpsku)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + cartsku.getText() + "--" + plpsku);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart" + cartsku.getText() + "--" + plpsku);
			return false;

		}

	}
	
	public boolean mobilePLPaddtoCart() {

		mob_menu.click();
		mob_submenu.click();
		mob_cat.click();
		com.sleepSeconds(1, "");
		mob_catdropdown.click();
		mob_catdropdownvalue.click();
		com.sleepSeconds(1, "");
		String plpsku = mob_product.getText();
		mob_plpaddtocart.click();
		com.sleepSeconds(3, "waiting for the pageload");
		if (cartsku.getText().contains(plpsku)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + cartsku.getText() + "--" + plpsku);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart" + cartsku.getText() + "--" + plpsku);
			return false;

		}

	}
	
	

	public boolean PDPaddtoCart() {

		com.mouseoveraction(menu);
		com.mouseoveraction(submenu);
		cat.click();
		com.sleepSeconds(1, "waiting for the pageload");
		String SKU = pdpproduct.getText();
		pdpproductclick.click();
		com.sleepSeconds(4, "waiting for the pageload");
		pdpaddtocart.click();
		com.sleepSeconds(4, "waiting for the pageload");

		if (DriverFactory.getInstance().getDriver().getPageSource().contains(SKU)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + SKU);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart" + SKU);
			return false;

		}

	}
	
	
	
	public boolean mobilePDPaddcart() {
		
		mob_menu.click();
		mob_submenu.click();
		mob_cat.click();
		com.sleepSeconds(1, "");
		mob_catdropdown.click();
		mob_catdropdownvalue.click();
		com.sleepSeconds(1, "");
		String plpsku = mob_product.getText();
		mob_productimageClick.click();
		com.sleepSeconds(2, "");
		pdpaddtocart.click();
		
		com.sleepSeconds(2, "waiting for the pageload");
		if (cartsku.getText().contains(plpsku)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + cartsku.getText() + "--" + plpsku);
			return true;
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart" + cartsku.getText() + "--" + plpsku);
			return false;

		}
		
		
	}

	public searchandBrowse enterSearchterm(String searchterm) {
		com.sleepSeconds(4, "");
		searchtext.sendKeys(searchterm);
		return this;
	}

	public searchandBrowse clickSearchbutton() {
		searchbtn.click();
		return this;

	}
	
	public searchandBrowse mobMenuClick() {
		mob_menu.click();
		return this;
	}

	public searchandBrowse mobSubMenuClick() {
		mob_submenu.click();
		return this;
	}
	
	public searchandBrowse addtocartclick() {
		pdpaddtocart.click();
		return this;
		
	}

}

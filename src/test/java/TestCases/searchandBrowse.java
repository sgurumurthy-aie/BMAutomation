package TestCases;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ParallelTest.Basetest;
import ParallelTest.DriverFactory;
import ParallelTest.ExtentFactory;

public class searchandBrowse extends Basetest{
	
	@Test
	public void searchProductasGuest() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-search\"]"))).sendKeys("235422");
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
		Thread.sleep(2000);
		String sku =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plist\"]/div/div/div[2]/small/span[2]"))).getText();
		System.out.println("Actual SKU"+sku);
		if (sku.contains("MV7N2AMA")) {
			ExtentFactory.getInstance().getExtent().info("Matching SKU found" + sku);
		} else {
			ExtentFactory.getInstance().getExtent().info("Matching SKU not found expected MV7N2AMA but found " + sku);
			
		}
	}

	@Test
	public void megamenufunctionality() throws Throwable {
		WebElement menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaNavLink\"]/span[1]"));
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(menu).perform();
		WebElement cat = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaDropDown\"]/li[1]/div/a[1]"));
		action.moveToElement(cat).perform();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"departmentListSubTree0\"]/li[1]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		String plptitle = DriverFactory.getInstance().getDriver().getTitle();
		
		if (DriverFactory.getInstance().getDriver().getPageSource().contains(plptitle)) {
			ExtentFactory.getInstance().getExtent().info("navigated to PLP" +plptitle);
		} else {
			ExtentFactory.getInstance().getExtent().fail("Not navigated to PLP" + plptitle);
			
		}
		
		
	}
	//@Test
	public void PLP() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),20);
		WebElement menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaNavLink\"]/span[1]"));
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(menu).perform();
		WebElement cat = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaDropDown\"]/li[1]/div/a[1]"));
		action.moveToElement(cat).perform();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"departmentListSubTree0\"]/li[1]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		
		String brand = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyContainer\"]/app-clp/div/div/div/div[1]/app-templates/p[2]/button"))).getText();
		if (brand.contains("Brands")) {
			ExtentFactory.getInstance().getExtent().info("Brands Filter option is present");
		} else {
			ExtentFactory.getInstance().getExtent().fail("Brands Filter option not present");
		}
		
		WebElement dropdwon = DriverFactory.getInstance().getDriver().findElement(By.id("sortOptions"));
		Select select = new Select(dropdwon);
		//String[] exp = {"Best Match / Relevancy","Price Low to High","Price High to Low","New","Best Sellers","Customer Ratings",};
;		List<WebElement> options = select.getOptions();
		//List<String> exp1 =new ArrayList<String>();
		for ( WebElement we:options) {
			ExtentFactory.getInstance().getExtent().info(we.getText());
			
		}
			
	}
	
	@Test
	public void PLPaddtoCart() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		WebElement menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaNavLink\"]/span[1]"));
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(menu).perform();
		WebElement cat = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaDropDown\"]/li[1]/div/a[1]"));
		action.moveToElement(cat).perform();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"departmentListSubTree0\"]/li[1]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		String SKU = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"plist\"]/div[3]/div/div[2]/small/span[2]")).getText();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"plist\"]/div[3]/div/div[3]/button")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart - BrandsMart USA"));
		Thread.sleep(3000);
		String cartSKU = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyContainer\"]/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[1]/div[2]/a/p"))).getText();
		System.out.println("Cart SKU " + cartSKU);
		System.out.println("PLP SKU " + SKU);
		if(DriverFactory.getInstance().getDriver().getPageSource().contains(cartSKU)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + cartSKU);
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart");
			
		}
		
		
	}
	
	@Test
	public void PDPaddtoCart() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		WebElement menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaNavLink\"]/span[1]"));
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(menu).perform();
		WebElement cat = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaDropDown\"]/li[1]/div/a[1]"));
		action.moveToElement(cat).perform();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"departmentListSubTree0\"]/li[1]/ul/li[1]/a")).click();
		String SKU = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"plist\"]/div[2]/div/div[2]/small/span[2]"))).getText();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"plist\"]/div[2]/div/div[1]/a[1]/div/strong")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bodyContainer\"]/app-pdp/div/div/div[1]/div[3]/div[2]/button[1]"))).click();
		//FFTR1821TSK10
		wait.until(ExpectedConditions.titleContains("Shopping Cart - BrandsMart USA"));
		Thread.sleep(2000);
		
		if (DriverFactory.getInstance().getDriver().getPageSource().contains(SKU)) {
			ExtentFactory.getInstance().getExtent().info("SKU Present in cart" + SKU);
		} else {
			ExtentFactory.getInstance().getExtent().fail("SKU not Present in cart" + SKU);
			
		}
		
		
		
		
	}
	
}

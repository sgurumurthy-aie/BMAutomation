package TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ParallelTest.Basetest;
import ParallelTest.DriverFactory;
import ParallelTest.ExtentFactory;

public class Cartfunctionality extends Basetest {

	@Test
	public void cartSummary() throws Throwable {

			
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]")).click();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 70);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-search\"]"))).sendKeys("235422");
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"plist\"]/div/div/div[3]/button/span[2]")).click();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"bodyContainer\"]/app-clp/div/div/div/div[2]/div/app-result-list/app-warranty-pop-up/div[1]/div/div/div[3]/button[1]"))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-search\"]"))).sendKeys("218664");
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"plist\"]/div/div/div[3]/button/span[2]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
							"//*[@id=\"bodyContainer\"]/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[2]/div/span[2]/span/app-number-plus-minus/span/span[2]/button")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.titleContains("Shopping Cart - BrandsMart USA"));
		DriverFactory.getInstance().getDriver().getPageSource().contains("ORDER SUMMARY");
		DriverFactory.getInstance().getDriver().getPageSource().contains("Subtotal");
		DriverFactory.getInstance().getDriver().getPageSource().contains("Estimated Shipping");
		String total = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"summary-holder\"]/div/div[1]/div[1]/span[2]/strong")).getText();
		if (!total.isBlank()) {
			ExtentFactory.getInstance().getExtent().info("Total is non Empty " + total);
		} else {
			ExtentFactory.getInstance().getExtent().info("Total is Empty " + total);
		}

	}

	 @Test
	public void cartupdate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-search\"]"))).sendKeys("218664");
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"plist\"]/div/div/div[3]/button/span[2]"))).click();

		wait.until(ExpectedConditions.titleContains("Shopping Cart - BrandsMart USA"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"bodyContainer\"]/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[2]/div/span[2]/span/app-number-plus-minus/span/span[2]/button")))
				.click();
		Thread.sleep(3000);
		String successmsg = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"bodyContainer\"]/app-cart/div[1]/app-global-msg/div")))
				.getText();

		if (successmsg.equalsIgnoreCase("Quantity Updated!")) {
			ExtentFactory.getInstance().getExtent().info("Quantity Updated");
		} else {
			ExtentFactory.getInstance().getExtent().info("Quantity Not Updated");
		}
	}

	@Parameters({ "userName", "passWord" })
	 @Test
	public void inStorepickup(String userName, String passWord) throws Throwable {

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]"))
				.click();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(userName);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button/strong"))
				.click();

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
		DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("/html/body/app-root/div/app-header/header/div[2]/div[1]/div/ul/li[4]/button"))
				.click();
		DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[2]/form/label/input"))
				.clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[2]/form/label/input")))
				.sendKeys("33312");
		DriverFactory.getInstance().getDriver()
				.findElement(By
						.xpath("/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[3]/button"))
				.click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-search\"]"))).sendKeys("218664");
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"plist\"]/div/div/div[3]/button/span[2]"))).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.titleContains("Shopping Cart - BrandsMart USA"));
		WebElement deliveryOption = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[@id=\"bodyContainer\"]/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[2]/div/div[1]/select"));
		Select devoption = new Select(deliveryOption);

		devoption.selectByVisibleText("Pickup From Store");

		Thread.sleep(3000);
		WebElement storeOption = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//select[contains(@id,'STORE')]"));

		Select store = new Select(storeOption);
		store.selectByVisibleText("Sawgrass Mills - (18 minutes away)");

		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"summary-holder\"]/div/div[3]/button/strong"))).click();

		if (DriverFactory.getInstance().getDriver().getPageSource().contains("Sawgrass Mills")) {
			ExtentFactory.getInstance().getExtent().info("Selected Store name matches");
		} else {
			ExtentFactory.getInstance().getExtent().info("Selected Store name not matched");

		}
		Thread.sleep(5000);
		DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"bodyContainer\"]/app-checkout/header/div/div/a/img")).click();
		DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com/shopping-cart");
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().findElement(By
				.xpath("//*[@id=\"bodyContainer\"]/app-cart/div[1]/div/div/form/div/div[1]/div[2]/div[1]/div/div[5]/i"))
				.click();
		Thread.sleep(3000);

	}

}

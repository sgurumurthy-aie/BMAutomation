package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ParallelTest.Basetest;
import ParallelTest.DriverFactory;
import ParallelTest.ExtentFactory;

public class StoreLocator extends Basetest {
	
	@Test
	public void storeLocatortest() throws Throwable {
		
		
		 DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"reverseTabMegaDropDown\"]/li[4]/div/div/ul/li[3]/a")).click();
		Thread.sleep(1000);
		String StoreText = DriverFactory.getInstance().getDriver().getTitle();
		System.out.println("StoreLocator title" + StoreText);
		if(StoreText.contains("Store Locator")) {
			ExtentFactory.getInstance().getExtent().info("Navigated to StoreLocator Page");
		} else {
			ExtentFactory.getInstance().getExtent().info("Not Navigated to StoreLocator Page");
		}
	}

	@Test
	public void updateZipCode() throws Throwable {
		DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/div/app-header/header/div[2]/div[1]/div/ul/li[4]/button")).click();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[2]/form/label/input")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[2]/form/label/input"))).sendKeys("10004");
		DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/div/app-header/app-update-zip-modal/div[1]/div/div/div[3]/button")).click();	
		Thread.sleep(1000);
		String zipcode = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/div/app-header/header/div[2]/div[1]/div/ul/li[4]/button")).getText();
		
		System.out.println("ZipCode obtainted"+zipcode);
		if (zipcode.contains("10004")) {
			ExtentFactory.getInstance().getExtent().info("ZipCode updated");
		} else {
			ExtentFactory.getInstance().getExtent().fail("Zip Code not updated");
		
		}
		
	}


}

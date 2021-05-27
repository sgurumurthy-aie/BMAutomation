package TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ParallelTest.Basetest;
import ParallelTest.DriverFactory;
import ParallelTest.ExtentFactory;

public class Login extends Basetest {

	@Test
	public void FlyoutBannerverification() {
		WebElement menu = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"megaNavLink\"]/span[1]"));
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(menu).perform();
		WebElement submenu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"megaDropDown\"]/li[1]/div/a[1]"));
		action.moveToElement(submenu).perform();
		WebElement Flyoutimage = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"departmentListSubTree0\"]/li[3]/div/p[2]/a[1]/img"));
		if (Flyoutimage.isDisplayed()) {
			ExtentFactory.getInstance().getExtent().info("image displayed" + Flyoutimage.getAttribute("alt"));
		} else {
			ExtentFactory.getInstance().getExtent().info("image not displayed");
		}

	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void Loginfunctionality(String userName, String passWord) {
		try {

			DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]")).click();
			DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).clear();
			DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(userName);
			DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).clear();
			DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
			DriverFactory.getInstance().getDriver()
					.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button/strong")).click();
			ExtentFactory.getInstance().getExtent().info("Log in successful");

		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().info("Log in unsuccessful");
		}
	}

}

package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ParallelTest.Basetest;
import ParallelTest.DriverFactory;
import ParallelTest.ExtentFactory;

public class userProfile extends Basetest {

	@Parameters({ "userName", "passWord" })
	@Test
	public void myAccountLeftnavigation(String userName, String passWord) throws Throwable {

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]"))
				.click();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 90);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(userName);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button/strong"))
				.click();

		ExtentFactory.getInstance().getExtent().info("Logged into application");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userDropDown\"]"))).click();

		DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		String accountText = DriverFactory.getInstance().getDriver()
				.findElement(By
						.xpath("//*[@id=\"bodyContainer\"]/app-my-account/section/div/app-overview/section/h1/strong"))
				.getText();
		if (accountText.equals("Account Overview")) {
			ExtentFactory.getInstance().getExtent().info("Naviagted to Account Management");

		} else {
			ExtentFactory.getInstance().getExtent().info("Not Naviagted to Account Management");
		}
	}

	@Test
	public void forgotpassword() {
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]"))
				.click();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"cFpContainer\"]/div/div[2]/a")).click();
		String forgotpwd = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"bodyContainer\"]/app-forgot-password/div/div/form/div/h1/strong"))
				.getText();
		if (forgotpwd.equals("Account Overview")) {
			ExtentFactory.getInstance().getExtent().info("Navigated to Forgot password page");

		} else {
			ExtentFactory.getInstance().getExtent().info("Not Navigated to Forgot password page");
		}

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"login\"]"))
				.sendKeys("sgurumurthy@aienterprise.com");

		DriverFactory.getInstance().getDriver()
				.findElement(By.xpath(
						"//*[@id=\"bodyContainer\"]/app-forgot-password/div/div/form/div/div[2]/div[1]/div/button"))
				.click();

	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void editProfile(String userName, String passWord) throws Throwable {
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]"))
				.click();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 70);

		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(userName);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).clear();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passWord);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/button/strong"))
				.click();

		ExtentFactory.getInstance().getExtent().info("Logged into application");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userDropDown\"]"))).click();

		DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/ul/li[1]/a")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"leftNavSection\"]/li[2]/a")))
				.click();
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"firstName\"]")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")))
				.sendKeys("shashikumar-");
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName\"]"))).sendKeys("kumarG-");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"bodyContainer\"]/app-my-account/section/div/app-profile/section/form/div[2]/div/div/div/div[5]/div[1]/button")))
				.click();
		String accountText = wait
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//*[@id=\"bodyContainer\"]/app-my-account/section/div/app-overview/section/h1/strong")))
				.getText();
		if (accountText.equals("Account Overview")) {
			ExtentFactory.getInstance().getExtent().info("Naviagted to Account Management");

		} else {
			ExtentFactory.getInstance().getExtent().info("Not Naviagted to Account Management");
		}

	}

}

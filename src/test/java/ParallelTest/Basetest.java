package ParallelTest;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

BrowserFactory bfs = new BrowserFactory();
	
	@Parameters ({"Browsers"})
	@BeforeMethod
	public void browserlaunch(String Browsers ) throws MalformedURLException, InterruptedException {
	DriverFactory.getInstance().setDriver(bfs.createBrowserInstance(Browsers));
	DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com");	
	DriverFactory.getInstance().getDriver().manage().window().maximize();
	Thread.sleep(1000);
		}
	
	
	@AfterMethod
	public void closebrowser() {
	DriverFactory.getInstance().closeBrowser();	
	}
	
}
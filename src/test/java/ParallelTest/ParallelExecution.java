package ParallelTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParallelExecution {
	
	public static WebDriver webDriver;
	
	BrowserFactory bfs = new BrowserFactory();
	SoftAssert softassert = new SoftAssert();
	

	
	
	
	@Parameters ({"Browsers"})
	@BeforeMethod
	public void browserlaunch(String Browsers ) throws MalformedURLException {

	DriverFactory.getInstance().setDriver(bfs.createBrowserInstance(Browsers));
	DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com");	
	DriverFactory.getInstance().getDriver().manage().window().maximize();
	

	}
	@AfterMethod
	public void closebrowser() {
	DriverFactory.getInstance().closeBrowser();	
	}
	
	@Test
	public void onClickLoginlink() {
		try {
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]")).click();
		ExtentFactory.getInstance().getExtent().info("sucessful link click");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().info("unsucessful link click");
		}
	}
	
	

}

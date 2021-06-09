package basemethods;


import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bmusa.pages.Cartfunctionality;
import com.bmusa.pages.Login;
import com.bmusa.pages.StoreLocator;
import com.bmusa.pages.searchandBrowse;
import com.bmusa.pages.userProfile;
public class Desktop_Basetest {

	BrowserFactory bfs = new BrowserFactory();
	public Login lg;
	public userProfile up;
	public StoreLocator st;
	public searchandBrowse sb;
	public Cartfunctionality ct;

	@Parameters({ "Browsers" })
	@BeforeMethod
	public void browserlaunch(String Browsers) throws MalformedURLException, InterruptedException {
		DriverFactory.getInstance().setDriver(bfs.createBrowserInstance(Browsers));
		DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com");
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		lg = new Login();
		up = new userProfile();
		st = new StoreLocator();
		sb= new searchandBrowse();
		ct= new Cartfunctionality();
		
		
		Thread.sleep(1000);
	}

	@AfterMethod
	public void closebrowser() {
		DriverFactory.getInstance().closeBrowser();
	}

}
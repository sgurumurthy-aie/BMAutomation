package basemethods;


import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bmusa.pages.Cartfunctionality;
import com.bmusa.pages.Login;
import com.bmusa.pages.StoreLocator;
import com.bmusa.pages.searchandBrowse;
import com.bmusa.pages.userProfile;



public class Mobile_Basetest {

	BrowserFactory bfs1 = new BrowserFactory();
	public Login mlg;
	public userProfile mup;
	public StoreLocator mst;
	public searchandBrowse msb;
	public Cartfunctionality mct;

	@Parameters({ "Browsers" })
	@BeforeMethod
	public void browserlaunch(String Browsers) throws MalformedURLException, InterruptedException {
		DriverFactory.getInstance().setDriver(bfs1.createBrowserInstance(Browsers));
		DriverFactory.getInstance().getDriver().navigate().to("https://www.brandsmartusa.com");
		Dimension d = new Dimension(768, 1024);
		DriverFactory.getInstance().getDriver().manage().window().setSize(d);
		Thread.sleep(2000);
		
		mlg= new Login();
		msb= new searchandBrowse();
		mst= new StoreLocator();
		mup= new userProfile();
		mct = new Cartfunctionality();
		
	}

	@AfterMethod
	public void closebrowser() {
		DriverFactory.getInstance().closeBrowser();
	}

}
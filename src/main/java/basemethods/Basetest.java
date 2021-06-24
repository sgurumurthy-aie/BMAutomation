package basemethods;


import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bmusa.constant.Constants;
import com.bmusa.pages.Cartfunctionality;
import com.bmusa.pages.Checkoutflows;
import com.bmusa.pages.Login;
import com.bmusa.pages.Payment;
import com.bmusa.pages.StoreLocator;
import com.bmusa.pages.searchandBrowse;
import com.bmusa.pages.staticPages;
import com.bmusa.pages.userProfile;

import utility.BMFilereader;


public class Basetest {

	BrowserFactory bfs = new BrowserFactory();
	public Login lg;
	public userProfile up;
	public StoreLocator st;
	public searchandBrowse sb;
	public Cartfunctionality ct;
	public staticPages sp;
	public Payment py;
	public Checkoutflows ck;


	@Parameters({ "Browsers" ,"Device"})
	@BeforeMethod
	public void browserlaunch(String browser, String device) throws MalformedURLException, InterruptedException {
		System.out.println("launching browser");
		
		DriverFactory.getInstance().setDriver(bfs.createBrowserInstance(browser, device));
		String URL = BMFilereader.getValue("productionurl");
		DriverFactory.getInstance().getDriver().navigate().to(URL);
		
		lg = new Login();
		up = new userProfile();
		st = new StoreLocator();
		sb= new searchandBrowse();
		ct= new Cartfunctionality();
		sp = new staticPages();
		py= new Payment();
		ck = new Checkoutflows();
		
		
		
		Thread.sleep(1000);
	}

	@AfterMethod
	public void closebrowser() {
		DriverFactory.getInstance().closeBrowser();
	}

}
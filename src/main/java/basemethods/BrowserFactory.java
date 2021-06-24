/**
 */
package basemethods;

import java.net.MalformedURLException;
import java.util.Objects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestContext;

import com.bmusa.constant.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BMFilereader;

public class BrowserFactory {
	// private static String browsername= new String();
	// private static String devicename = new String();

	// create webDriver object for given browser
	public static WebDriver createBrowserInstance(String browser, String devicename) throws MalformedURLException {

		WebDriver driver = null;
		/*
		 * String browser =BMFilereader.getValue(Constants.getBROWSER()); String device
		 * =BMFilereader.getValue(Constants.getDEVICE());
		 */

		// RemoteWebDriver driver = null;
		/*
		 * System.out.println("Bname"+ browsername); System.out.println("deviceName" +
		 * devicename);
		 * 
		 * if (Objects.isNull(browsername) ) {
		 * 
		 * browsername="Chrome"; }
		 * 
		 * if (Objects.isNull(devicename) ) { devicename =Constants.getDEVICE(); }
		 */
		
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			
			  if (devicename.equalsIgnoreCase("Mobile")) {
			  System.out.println("i am inside Device check IF condition"); 
			  Dimension d = new Dimension(375, 812); driver.manage().window().setSize(d); } else {
			  driver.manage().window().maximize(); }
			  
			 
		} else if (browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions foptions = new FirefoxOptions(); //
			foptions.addArguments("-private");

			// driver = new RemoteWebDriver(new URL("http:192.168.225.219:4444/wd/hub"),
			// DesiredCapabilities.firefox());

			driver = new FirefoxDriver(foptions);
			if (devicename.equalsIgnoreCase("Mobile")) {
				Dimension d = new Dimension(414, 736);
				driver.manage().window().setSize(d);
			} else {
				driver.manage().window().maximize();
			}

		}
		if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");

			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}

	/*
	 * public static void getbrowsernameXML(ITestContext context) { browsername =
	 * context.getCurrentXmlTest().getLocalParameters().get("Browsers");
	 * 
	 * }
	 * 
	 * public static void getdevicenameXML(ITestContext context) { devicename =
	 * context.getCurrentXmlTest().getLocalParameters().get("Device");
	 * 
	 * }
	 */
}

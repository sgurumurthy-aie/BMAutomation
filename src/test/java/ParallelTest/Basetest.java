package ParallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public static WebDriver webDriver;
	
	
	
	public WebDriver getdriver(String driver) {

		System.out.println("i am in baseClass");
		if (driver.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
		} else if (driver.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			webDriver= new FirefoxDriver();
		}
		return webDriver;

	}
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public ExtentReports extent;

	
	@BeforeTest
	public void reportsetup() {
	
		htmlReporter = new ExtentHtmlReporter("./extentreports/extents.html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("BM Execution Report");
		htmlReporter.config().setReportName("Production Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Shashikumar", "BMUSA");
		extent.setSystemInfo("Organization", "AIE");
		extent.setSystemInfo("Production application", "Test Result");
		
			
	}
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
		
	}
	
	@AfterMethod
	
	public void teardown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
		
	}else if (result.getStatus() == ITestResult.SUCCESS) {
		
		String methodName = result.getMethod().getMethodName();
		
		String LogText = "<b>" + "Testcase: - "+methodName.toUpperCase() + "   PASSED " +"</b>";
		Markup mark = MarkupHelper.createLabel(LogText, ExtentColor.GREEN);
		
		test.pass(mark);
	}
		
	}


}


package ParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ParallelExecution extends Basetest{
	
	public static WebDriver webDriver;
	
//	@Parameters({"Browsers"})
//	@Test
//	public void displayBrowser(String browsers) {
//		
//		System.out.println("Browser"+"---"+ browsers);
//	
//	}
	
	@Test
	public void browserlaunch() {

	webDriver = getdriver("chrome");
	webDriver.get("https://www.brandsmartusa.com");	
	webDriver.findElement(By.xpath("//*[@id=\"options\"]/li[1]/div/ul/li[2]/a[1]")).click();;
	
	
	
	}
	
	

}

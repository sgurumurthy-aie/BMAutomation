package basemethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ParallelExecution extends Desktop_Basetest{
	
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

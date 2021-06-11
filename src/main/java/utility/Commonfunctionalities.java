package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basemethods.DriverFactory;



public class Commonfunctionalities {
	
	public void clearText(WebElement element) {
		element.clear();
		
	}
	
	public void mouseoveraction(WebElement webelement) {
		
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(webelement).perform();
	}
	
	
	 public boolean waitTillWebElementIsVisible(WebElement webElement, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), seconds);
            return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
        } catch (Exception e) {

            return false;
        }
    }

    public boolean waitTillWebElementIsVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 20);
            return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
        } catch (Exception e) {

            return false;
        }
    }
    
    public void sleepSeconds(int seconds, String message) {

        try {
               Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
 }

    
    
}

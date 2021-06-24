package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bmusa.pages.searchandBrowse;

import basemethods.DriverFactory;

public class Commonfunctionalities {

	@FindBy(xpath = "//*[@id='top-search']")
	private WebElement searchtext;

	@FindBy(xpath = "//*[@id='searchBtn']")
	private WebElement searchbtn;

	@FindBy(xpath = "//span[contains(text(),'ADD TO CART')]")
	private WebElement addtocart;

	@FindBy(xpath = "//strong[contains(text(),'start secured checkout')]")
	private WebElement clickCheckoutButton;

	@FindBy(xpath = "//*[@id='continue-shipping']/span")
	private WebElement checkoutshippingoption;

	@FindBy(xpath = "//button[contains(text(),'CONTINUE TO PAYMENTS')]")
	private WebElement continuetoPayment;

	@FindBy(xpath = "//*[@id='payment-option']/div/ul/li[3]/input")
	private WebElement paypalimage;

	@FindBy(xpath = "//img[@alt='Check out with PayPal']")
	private WebElement paypalbutton;

	@FindBy(xpath = "//*[@id='payment-option']/div/ul/li[4]/input")
	private WebElement fortivaimage;

	@FindBy(xpath = "//button[contains(text(),'fortiva')]")
	private WebElement fortivabutton;

	@FindBy(xpath = "//h2[contains(text(),'Account Lookup')]")
	private WebElement fortivatext;

	@FindBy(xpath = "//button[contains(text(),'No Thanks')]")
	private WebElement warrantyNothanks;

	@FindBy(xpath = "//*[@id='payment-option']/div/ul/li[2]/input")
	private WebElement creditcardimge;

	@FindBy(xpath = "//*[@id='cvv']")
	private WebElement cvv;

	@FindBy(xpath = "//button[contains(text(),'place order')]")
	private WebElement proceedToOrder;

	@FindBy(xpath = "//*[@id='bodyContainer']/app-checkout/div/div/div[1]/div[1]/div[2]/button")
	private WebElement placeOrder;

	@FindBy(xpath = "//*[@id=\"bodyContainer\"]/app-order-confirmation/div/div/div[1]/h1/span")
	private WebElement getorder;

	@FindBy(xpath = "//input[@aria-label='undefined - 0009']")
	private WebElement amexcardImage;

	@FindBy(xpath = "//input[@aria-label='undefined - 5100']")
	private WebElement mastercardImage;

	@FindBy(xpath = "//input[@aria-label='undefined - 0004']")
	private WebElement disccardImage;

	@FindBy(xpath = "//input[@aria-label='undefined - 1111']")
	private WebElement visacardImage;
	
	@FindBy (xpath="//div[@class='col-lg-9 col-md-12 col-xs-12 username-holder']//input")
	private WebElement checkoutusername;
	
	@FindBy (xpath="//div[@class='col-lg-9 col-md-12']//input[@name='password']")
	private WebElement checkoutpwd;
	
	@FindBy (xpath="//strong[contains(text(),'Sign in now')]")
	private WebElement checkoutsignbutton;
	

	public Commonfunctionalities() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public void clickcheckout() {
		clickCheckoutButton.click();
	}

	public void clickcheckoutshippingoption() {
		checkoutshippingoption.click();
	}

	public void clickpayment() {
		continuetoPayment.click();
	}

	public void clicknothanks() {
		warrantyNothanks.click();
	}

	public void clickccimage() {
		creditcardimge.click();
	}

	public void clearText(WebElement element) {
		element.clear();

	}

	public void cvventer(String num) {
		cvv.sendKeys(num);
	}

	public void clickProceedToOrder() {
		proceedToOrder.click();
	}

	public void clickplaceOrder() {
		placeOrder.click();

	}

	public String getOrdernumber() {
		return (getorder.getText());
	}

	public void clickamexcardImage() {
		amexcardImage.click();
	}

	public void clickdiscovercardImage() {
		disccardImage.click();
	}

	public void clickmastercardImage() {
		mastercardImage.click();
	}

	public void clickvisacardImage() {
		visacardImage.click();
	}
	
	public void entercheckoutusername(String userName) {
		checkoutusername.clear();
		checkoutusername.sendKeys(userName);
	}
	
	public void entercheckoutpwdname(String pwd) {
		
		checkoutpwd.clear();
		checkoutpwd.sendKeys(pwd);
	}

	public void checkoutsigninBtnclick() {
		checkoutsignbutton.click();
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
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterSearchterm(String searchterm) {
		searchtext.sendKeys(searchterm);

	}

	public void clickSearchbutton() {
		searchbtn.click();
	}

	public void addtoCartbutton() {
		addtocart.click();
	}
	
	public String cartID() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverFactory.getInstance().getDriver());
		LocalStorage localStorage = webStorage.getLocalStorage();
		String cartId = localStorage.getItem("arcCartId");
		System.out.println("Cart"+ cartId);
		return cartId;
	}
}

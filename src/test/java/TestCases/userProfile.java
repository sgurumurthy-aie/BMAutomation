package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class userProfile {


	
	SoftAssert sftassert = new SoftAssert();
	
	@BeforeTest
	public void OpeningBrowser() {

		System.out.println("ClosingBrowser");

	}

	@Test
	public void doLogin() {

		System.out.println("doLogin");
		sftassert.assertAll();
	}

	@Test
	public void doLogout() {

		System.out.println("doLogout");

	}

	@AfterTest
	public void ClosingBrowser() {

		System.out.println("ClosingBrowser");

	}
}

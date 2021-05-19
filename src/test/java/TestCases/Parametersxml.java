package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametersxml {
	
	@Parameters({"browsers","env"})
	@Test
	public void Testngparameters(String browsers, String Env) {
		
		System.out.println(browsers+"---"+Env);
		
	}

}

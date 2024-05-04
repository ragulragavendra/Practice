package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Anno_Parameters {
	
	/*
	 * Check parameters.xml
	 * Parameters annotation is used to pass less number of data to our test case from the testng xml file
	 * Suite Level parameters is like global it has scope for all the test suite
	 * Test tag level parameters has scope for the particular test
	 * In this example we set email and password as suite level param and browser is test level parameter
	 * Here we done cross browser testing by using parameter 
	 * Here we used suite level parallel run
	 */

	@Parameters({"Email","Password","Browser"})
	@Test
	public void LaunchApp(String email, String pwd, String browser) {
		switch (browser) {
		case "chrome":
			System.out.println("Running in Chrome");
			break;
		case "edge":
			System.out.println("Running in Edge");
			break;
		}
		System.out.println("Email: "+email);
		System.out.println("Password: "+pwd);
	}
}

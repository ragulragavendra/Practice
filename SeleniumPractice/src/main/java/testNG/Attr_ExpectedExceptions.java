package testNG;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

public class Attr_ExpectedExceptions {
/*
 * ExpectedExceptions will be used if we know that particular test case will throw some exception and if we need to pass that test case 
 *
 */

	@Test(expectedExceptions = {NoSuchElementException.class, TimeoutException.class})
	public void Login() {
		System.out.println("login");
	}
	
}

package testNG;

import org.testng.annotations.Test;

public class Attr_TimeOut {
/*
 * Timeout will check if the given test executes within the given time(milliseconds) otherwise it will throw error 
 *
 */

	@Test(timeOut = 10000)
	public void Login() {
		System.out.println("login");
	}
	
}

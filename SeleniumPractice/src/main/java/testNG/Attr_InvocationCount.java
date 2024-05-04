package testNG;

import org.testng.annotations.Test;

public class Attr_InvocationCount {
/*
 * If we want to run the testcase multiple times then we can use invocationCount 
 * If we add invocationTimeout then all the execution not completed within the given milliseconds, it will throw timeoutException
 * Negative priority will run first
 *
 */

	@Test(invocationCount = 3, invocationTimeOut = 5000)
	public void Login() {
		System.out.println("login");
	}
	
}

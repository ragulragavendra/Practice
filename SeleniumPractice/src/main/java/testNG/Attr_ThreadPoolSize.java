package testNG;

import org.testng.annotations.Test;

public class Attr_ThreadPoolSize {
/*
 * ThreadPoolSize will execute the test parallelly and it will work if we had invocationCount 
 *
 */

	@Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 2)
	public void Login() {
		System.out.println("login");
	}
	
}

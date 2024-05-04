package testNG;

import org.testng.annotations.Test;

public class Attr_Priority {
/*
 * If we did not add the priority attribute by default testng will consider as priority '0' 
 * and then TestNG will run based on the ASCII value order
 * Negative priority will run first
 *
 */

	@Test(priority=1)
	public void Login() {
		System.out.println("login");
	}
	
	@Test(priority=2)
	public void SearcProduct() {
		System.out.println("SearcProduct");
	}
	
	@Test(priority=3)
	public void Payment() {
		System.out.println("Payment");
	}
	
	@Test(priority=4)
	public void Logout() {
		System.out.println("Logout");
	}
	
	@Test(priority=-2)
	public void LaunchApp() {
		System.out.println("LaunchApp");
	}
}

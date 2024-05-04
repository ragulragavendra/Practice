package testNG;

import org.testng.annotations.Test;

public class Attr_Groups {
	/*
	 * Run based on groups. Check groups.xml
	 * if we add include tag in the xml then that group will run
	 * if we add exclude tag then apart from that group other group will run
	 * if we add both include and exclude for the same group then the script won't run. bcz priority goes to exclude
	 */

	@Test(groups= {"smoke","Regression"})
	public void Login() {
		System.out.println("login");
	}
	
	@Test(groups= {"Regression"})
	public void SearcProduct() {
		System.out.println("SearcProduct");
	}
	
	@Test(groups= {"smoke"})
	public void Payment() {
		System.out.println("Payment");
	}
	
	@Test(groups= {"Regression"})
	public void Logout() {
		System.out.println("Logout");
	}
	
	@Test(groups= {"sanity"})
	public void LaunchApp() {
		System.out.println("LaunchApp");
	}
}

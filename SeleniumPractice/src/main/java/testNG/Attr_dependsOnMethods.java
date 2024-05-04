package testNG;

import org.testng.annotations.Test;

public class Attr_dependsOnMethods {
/*
 * If we dependsOnMethods then that depended method will run first and if its PASSED then only other method will run otherwise it skip
 * If we add alwaysRun=true then even though the dependent method get failed this method will run
 * If we had priority and dependsOnMethods attribute for the same method. TestNg will provide priority to dependsOnMethods
 */

	@Test()
	public void Login() {
		System.out.println("login");
	}
	
//	Eventhough we had priority =-2 it won't execute first
	@Test(dependsOnMethods="Login", priority=-2)
	public void SearchProduct() {
		System.out.println("SearchProduct");
	}
	
	@Test(dependsOnMethods="SearchProduct")
	public void AddToCart () {
		throw new RuntimeException();
	}
	
	@Test(dependsOnMethods="AddToCart")
	public void Payment() {
		System.out.println("Payment");
	}
	
	@Test(dependsOnMethods="Payment", alwaysRun = true, description = "This method will logout")
	public void Logout() {
		System.out.println("Logout");
	}
	
//	If we are dependent on different class' method then we can provide like below
//	@Test(dependsOnMethods="PackageName.ClassName.MethodName")
//	public void abc() {
//		System.out.println("abc");
//	}
	
}

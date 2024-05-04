package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import fileHandling.PropertiesFileReader;
import pages.locators;

public class InputForm {

	@Test
	public static void main() {
		PropertiesFileReader.LoadPropertyFile();
		String Url = PropertiesFileReader.prop.getProperty("URL");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		driver.findElement(locators.chooseSection("Edit")).click();
		
//		SendKeys
		driver.findElement(By.id("fullName")).sendKeys("MyName");
		
//		Sendkeys with Key
		driver.findElement(By.id("join")).sendKeys(" Person",Keys.TAB);
		
//		Get Text
		String text = driver.findElement(By.id("getMe")).getText();
		System.out.println(text);
		
//		Clear Text
		driver.findElement(By.id("clearMe")).clear();
		
//		Check the field is enabled or not
		Boolean enbStatus = driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println(enbStatus);
		
//		Check the field is readOnly
		String readOnly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(readOnly);
		
		driver.quit();
		

	}

}

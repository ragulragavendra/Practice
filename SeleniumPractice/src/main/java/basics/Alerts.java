package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fileHandling.PropertiesFileReader;
import pages.locators;

public class Alerts {
	static WebDriver driver;
	public static void launchApp() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");
		
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	 public static void main(String[] args) throws IOException {
		launchApp();
		driver.findElement(locators.chooseSection("Dialog")).click();
		
//		Simple Alert - Both accept and dismiss will do same function for simple alert 
		driver.findElement(By.id("accept")).click();
		driver.switchTo().alert().accept();
		
//		Confirm Alert - Get Text, Accept, Dismiss
		driver.findElement(By.id("confirm")).click();
		Alert ConfirmAlert = driver.switchTo().alert();
		//Get Text
		System.out.println(ConfirmAlert.getText());
		//Accept
		ConfirmAlert.accept();
		//Dismiss
		driver.findElement(By.id("confirm")).click();
		ConfirmAlert.dismiss();
		
//		Prompt Alert
		driver.findElement(By.id("prompt")).click();
		Alert PromptAlert = driver.switchTo().alert();
		PromptAlert.sendKeys("Ragul");
		PromptAlert.accept();
		
		System.out.println(driver.findElement(By.id("myName")).getText());
		driver.quit();
	 }
}

package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fileHandling.PropertiesFileReader;

public class RadioButton {
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
		driver.findElement(By.xpath("//a[text()='Toggle']")).click();
		
//		Click the radio button and verify
		driver.findElement(By.xpath("//label[text()='Select any one']/..//input[@id='yes']")).click();
		if(driver.findElement(By.xpath("//label[text()='Select any one']/..//input[@id='yes']")).isSelected()) {
			System.out.println("Radio btn is Selected");
		}else {
			System.out.println("Radio btn is Not Selected");
		}
		
//		verify the checkbox is selected
		if(driver.findElement(By.xpath("//label[contains(text(),'Remember me')]/input")).isSelected()) {
			System.out.println("Checkbox is Selected");
		}else {
			System.out.println("Checkbox is Not Selected");
		}
		
//		verify the checkbox is not Selected
		if(driver.findElement(By.xpath("//label[contains(text(),'I agree to the')]/input")).isSelected()) {
			System.out.println("Checkbox is Selected");
		}else {
			System.out.println("Checkbox is Not Selected");
		}
		driver.quit();
	}

}
	

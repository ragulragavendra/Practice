package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fileHandling.PropertiesFileReader;

public class Waits {
	static WebDriver driver;
	//Implicit wait - will work only for find element and find Elements
	public static void launchApp() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	//Explicit Wait
	public static void main(String[] args) throws IOException, InterruptedException {
		launchApp();
		//Explicit wait for until element is clickable
		WebElement elem = driver.findElement(By.xpath("//a[text()='Tabs']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
		
		//Wait for the alert
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		//Wait for the visibiity of the element
		wait.until(ExpectedConditions.visibilityOf(elem));
		
		//Wait for the invisibiity of the element
		wait.until(ExpectedConditions.invisibilityOf(elem));
	}
}

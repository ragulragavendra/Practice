package basics;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fileHandling.PropertiesFileReader;

public class WindowHandle {
	static WebDriver driver;
	public static void launchApp() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		launchApp();
		WebElement elem = driver.findElement(By.xpath("//a[text()='Tabs']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
		
//		To get current window 
		String currentWindowId = driver.getWindowHandle();
		System.out.println("Current window Id: "+currentWindowId);
		
//		Switch to other Tab/window
		driver.findElement(By.id("home")).click();
		Set<String> allwindow =driver.getWindowHandles();
		List<String> allwindows = new ArrayList<>(allwindow);
		driver.switchTo().window(allwindows.get(1));
		System.out.println(driver.getCurrentUrl());
		
//		Close the window
		driver.close();
		driver.switchTo().window(allwindows.get(0));
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		driver.quit();
	}
}

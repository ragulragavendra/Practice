package basics;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import fileHandling.PropertiesFileReader;

public class Waits {
	static WebDriver driver;
	//Implicit wait - will work only for find element and find Elements
	/*
	 * The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time
	 * before it throws a “No Such Element Exception”.
	 */
	public static void launchApp() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	//Explicit Wait
	/*
	 * The Explicit Wait in Selenium is used to tell the Web Driver to wait for certain conditions (Expected Conditions) 
	 * or maximum time exceeded before throwing “ElementNotVisibleException” exception. It is an intelligent kind of wait, 
	 * but it can be applied only for specified elements. It gives better options than implicit wait as it waits for 
	 * dynamically loaded Ajax elements.
	 */
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
	
	//Fluent Wait
	/*
	 * Fluent Wait in Selenium is used to tell the web driver to wait for a condition, 
	 * as well as the frequency with which we want to check the condition before throwing an exception. 
	 * It checks for the web element at regular intervals until the object is found or timeout happens.
	 */
	public void FluentWait() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>()
				{

					@Override
					public WebElement apply(WebDriver t) {
						return driver.findElement(By.xpath("//a[text()='Tabs']"));
					}
					
				});
	}
}

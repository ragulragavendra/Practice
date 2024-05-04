package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveToElement {
	static WebDriver driver;
	//Implicit wait - will work only for find element and find Elements
	public static void launchApp() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	//Explicit Wait
	public static void main(String[] args) {
		launchApp();
		//Mouse Hover or Move to Element
		WebElement elem = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elem).perform();
		
		driver.findElement(By.xpath("//a[text()='All']")).click();
		
		//wait for the title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Audio"));
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
}

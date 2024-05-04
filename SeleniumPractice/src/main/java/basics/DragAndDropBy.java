package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropBy {
	static WebDriver driver;
	public static void launchApp() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/dragabble");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		launchApp();
		driver.findElement(By.linkText("Container Restricted")).click();
		WebElement elem = driver.findElement(By.xpath("//div[@id='containmentWrapper']//div[contains(@class,'draggable')]"));
		Actions builder = new Actions(driver);
		System.out.println(elem.getLocation());
		builder.dragAndDropBy(elem, 100, 100).perform();
		
		driver.quit();
	}
}

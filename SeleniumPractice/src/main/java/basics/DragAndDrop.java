package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import fileHandling.PropertiesFileReader;

public class DragAndDrop{
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
//		WebElement elem = driver.findElement(By.xpath("//a[text()='AUI - 2']"));
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
		driver.navigate().to("https://letcode.in/dropable");
		
		WebElement SourceElem = driver.findElement(By.id("draggable"));
		WebElement DestElem = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(SourceElem,DestElem).perform();
		
		
	}

}

package basics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fileHandling.PropertiesFileReader;

public class IFrames {
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
		driver.findElement(By.xpath("//a[text()='Inner HTML']")).click();
		
//		We can switch to IFrame using index or webElement or Id or Name
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Ragul");
		
//		Frame inside Frame
		driver.switchTo().frame(0);
		driver.findElement(By.name("email")).sendKeys("Abc@gamil.com");
		
//		Switch to Parent Frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("B");
		
//		Switch to Actual Frame
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Watch tutorial")).click();
		
		driver.quit();
	}
}

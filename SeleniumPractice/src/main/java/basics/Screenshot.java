package basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import fileHandling.PropertiesFileReader;

public class Screenshot {
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
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
        File Destination = new File("./Screenshot/img.png");
        
        FileHandler.copy(screenshot, Destination);
        
        driver.quit();
	}
	 
}

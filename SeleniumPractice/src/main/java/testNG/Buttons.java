package testNG;

import pages.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import fileHandling.PropertiesFileReader;
public class Buttons {

	@Test
	public void main() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");
		
		WebDriver driver =new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(locators.chooseSection("Click")).click();
		
//		Driver navigation
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
//		Get x and Y co-ordinate
		Point coord= driver.findElement(By.id("position")).getLocation();
		System.out.println("Co-ordination");
		System.out.println(coord.getX());
		System.out.println(coord.getY());

//		Get css value
		String bgColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("bgColor "+bgColor);
		
//		Get Height and Weight
		Dimension dimension = driver.findElement(By.id("property")).getRect().getDimension();
		System.out.println("Dimension :"+dimension);
		
//		Button disabled or not
		Boolean isEnabled = driver.findElement(By.xpath("//button[@id='isDisabled' and text()='Disabled']")).isEnabled();
		System.out.println("Btn enable status "+isEnabled);
		
//		click and hold
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//button[@id='isDisabled']//h2[text()='Button Hold!']"));
		action.moveToElement(btn);
		action.clickAndHold().perform();
		String afterHold = btn.getText();
		System.out.println(afterHold);
		driver.quit();
	}

}

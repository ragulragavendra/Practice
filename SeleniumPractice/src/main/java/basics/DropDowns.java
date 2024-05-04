package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.locators;

import fileHandling.PropertiesFileReader;

public class DropDowns {
	static WebDriver driver;
	public static void launchApp() {
		PropertiesFileReader.LoadPropertyFile();
		String URL = PropertiesFileReader.prop.getProperty("URL");
		
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		try {
			launchApp();
			driver.findElement(locators.chooseSection("Drop-Down")).click();
			
			
	//		Select by Visible Text
			WebElement FruitSelectElem = driver.findElement(By.id("fruits"));
			Select FruitSelect = new Select(FruitSelectElem);
			FruitSelect.selectByVisibleText("Apple");
	
	//		Verify Selected Text
			String SelectedFruit = FruitSelect.getFirstSelectedOption().getText();
			System.out.println(SelectedFruit);
			
			
	//		Multi select
			WebElement SHSelectElem = driver.findElement(By.id("superheros"));
			Select HeroSelect= new Select(SHSelectElem);
			HeroSelect.selectByIndex(0);
			HeroSelect.selectByValue("rb");
			HeroSelect.selectByVisibleText("Elektra");
			Thread.sleep(3000);
			
	//		Deselect - will work only for Multi select
			if(HeroSelect.isMultiple()) {
				HeroSelect.deselectByVisibleText("Robin");
			}
			
	//		Verify Selected Value for Mutliselect
			List<WebElement> HeroSelectedElems = HeroSelect.getAllSelectedOptions();
			HeroSelectedElems.forEach(SelectedElem -> System.out.println(SelectedElem.getText()));
			
	//		Get all Options and Select Last Option
			WebElement LangSelectElem = driver.findElement(By.id("lang"));
			Select LangSelect = new Select(LangSelectElem);
			List<WebElement> LangOptions = LangSelect.getOptions();
			LangOptions.forEach(i -> System.out.println(i.getText()));
			LangSelect.selectByIndex(LangOptions.size()-1);
			
			Thread.sleep(5000);
		}catch(Exception excep) {
			excep.printStackTrace();
		}finally {
			driver.quit();
		}
	}

}

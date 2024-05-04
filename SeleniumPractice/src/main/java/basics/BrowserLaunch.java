package basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	static WebDriver driver;
	
	public static void Selenium3Launch() {
		System.setProperty(
	            "webdriver.chrome.driver","C:\\Users\\ragul\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        // Instantiate a ChromeDriver class.
	        WebDriver driver = new ChromeDriver();
	 
	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	        // Launch Website
	        driver.get("https://www.geeksforgeeks.org/");
	        driver.quit();
	}
	
	
	public static void Selenium4LaunchChrome(String URL) {
	        driver = new ChromeDriver();
	
	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	        // Launch Website
	        driver.get(URL);
	}
	
	public static void main(String[] args) {
		try {
			String URL = "https://letcode.in/test";
			String ExpTitle="LetCode - Testing Hub";
			Selenium4LaunchChrome(URL);
			if(ExpTitle.equals(driver.getTitle()) && URL.equals(driver.getCurrentUrl())){
				System.out.println("Successfully launched the application");
				Thread.sleep(5000);
			}else {
				System.out.println("Unable to launch the application");
			}
		}catch(Exception excep) {
			System.out.println("Failed to launch the driver or applicaiton");
		}finally {
			driver.close();
		}
	}

}

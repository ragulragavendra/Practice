package basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
	public static void scrollIntoView(WebDriver driver, WebElement element) {
        // Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to scroll the element into top
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

package pages;

import org.openqa.selenium.By;

public class locators {

	public static By chooseSection(String ButtonName) {
		return By.xpath("//a[contains(@class,'card-footer-item') and text()='"+ButtonName+"']");
	}
}

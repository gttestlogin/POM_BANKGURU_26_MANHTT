package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;

	//Ham khoi tao: Map driver
	public HomePageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at HomePage layer = " + driver.toString());
	}
		
	public boolean isWelcomMessageDisplayed(String expectedText) {
		String actualText = getTextElement(driver, HomePageUI.WELCOM_MESSAGE_TEXT);
		return actualText.equals(expectedText);
	}

	public boolean isUserIDDisplayed(String userID) {
		String actualText = getTextElement(driver, HomePageUI.USERID_TEXT);
		return actualText.equals("Manger Id : " + userID);
	}
}

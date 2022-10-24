package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;

	// Ham khoi tao: Map driver
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

	public void clickToNewCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		
	}

	/*
	public NewCustomerPageObject openNewCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public DepositPageObject openDepositPage() {
		waitForElementVisible(driver, HomePageUI.DEPOSIT_LINK);
		clickToElement(driver, HomePageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPage(driver);		
	}
	*/
}

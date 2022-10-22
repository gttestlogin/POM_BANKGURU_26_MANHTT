package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.DepositPageUI;
import pageUIs.NewCustomerPageUI;
import pageUIs.RegisterPageUI;

public class DepositPageObject extends AbstractPage {

	WebDriver driver;
	
	//Ham khoi tao: Map driver
	public DepositPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at DepositPageObject layer = " + driver.toString());
	}

	public NewAccountPageObject openNewAccountPage() {
		waitForElementVisible(driver, DepositPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, DepositPageUI.NEW_ACCOUNT_LINK);
		return PageGeneratorManager.getNewAccountPage(driver);
	}
}

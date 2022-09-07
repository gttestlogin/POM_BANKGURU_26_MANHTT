package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	WebDriver driver; 
	long shortTimeout = 5;
	long longTimeout = 30;
	
	//Ham khoi tao: Map driver
	public LoginPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at LoginPage layer = " + driver.toString());
	}
	
	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void clickToHereLink() {
		//way1: Page Object
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		//end of way1
		
		/*
		//way2: Selenium API -> kho maintain
		WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		By byLocator = By.xpath("//input[@name='uid]");
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
		
		WebElement element = driver.findElement(By.xpath("//input[@name='uid]"));
		element.click();
		//end of way2
		*/
		
	}

	public void inputToUserIDTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}


}

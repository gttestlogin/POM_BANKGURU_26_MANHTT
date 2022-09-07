package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;
	
	//Ham khoi tao: Map driver
	public RegisterPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at RegisterPage layer = " + driver.toString());
	}
		
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUsernameInformation() {
		waitForElementVisible(driver, RegisterPageUI.USERID_TEXT);
		return getTextElement(driver, RegisterPageUI.USERID_TEXT);
		
	}

	public String getPasswordInformation() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public void openLoginPageUrl(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
	}

}

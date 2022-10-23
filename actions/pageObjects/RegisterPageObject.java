package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;
	
	//Ham khoi tao: Map driver
	public RegisterPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at Register Page layer = " + driver.toString());
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

	public void sendTabToEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyboardToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, Keys.TAB);
	}

	
	/*
	public void openLoginPageUrl(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
	}
	*/
	
	
	public LoginPageObject openLoginPageUrl(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	
}

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.AbstractPage;
import commons.PageGeneratorManager;
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

	/*
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
		/
		
	}
	*/
	
	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		//sau khi clickToHereLink thì sẽ chuyển qua RegisterPageObject
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public void inputToUserIDTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	/*
	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}
	 */
	
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
	}

	//Account_09_RegisterAndLogin_ElementUndisplayed
	public boolean isLoginPageDisplayed() {
		//khi Login Page displayed thi tuc la UserID Textbox displayed
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		return isControlDisplayed(driver, LoginPageUI.USERID_TEXTBOX);
	}

	public boolean isRegisterPageUndisplayed() {
		//khi Login Page displayed thi tuc la UserID Textbox displayed
		waitForElementInvisible(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
	}

	public boolean isHomePageUndisplayed() {
		//khi Login Page displayed thi tuc la UserID Textbox displayed
		waitForElementInvisible(driver, LoginPageUI.WELCOME_MESSAGE_AT_HOME_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.WELCOME_MESSAGE_AT_HOME_PAGE);
	}

	public boolean isDeleteCustomerFormLinkDisplayed() {
		waitForElementVisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
		return isControlDisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
	}

	public boolean isDeleteCustomerFormLinkUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
	}
	
	public void clickToSeleniumDropdownToggle() {
		waitForElementVisible(driver, LoginPageUI.SELENIUM_DROPDOWN_TOGGLE_AT_LOGIN_PAGE);
		clickToElement(driver, LoginPageUI.SELENIUM_DROPDOWN_TOGGLE_AT_LOGIN_PAGE);
	}
}

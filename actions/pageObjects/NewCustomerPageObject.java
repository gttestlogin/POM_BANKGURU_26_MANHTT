package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;

	//.. Ham khoi tao: Map driver
	public NewCustomerPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at New Customer Page layer = " + driver.toString());
	}

	public boolean isNewCustomerPageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
	}

	public void inputToCustomerName(String customerName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}

	public void inputToDateOfBirthTextbox(String dateOfBirth) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
		
	}

	public void clickToGenderMale() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToAddressTextArea(String address) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
		
	}
 
	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
		
	}
	
	public void inputToStateTextbox(String state) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
		
	}
	
	public void inputToPINTextbox(String pinNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pinNumber);
		
	}
	
	public void inputToPhoneTextbox(String phoneNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX, phoneNumber);
		
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
		
	}
	
	public void inputToPasswordTextbox(String state) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, state);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCustomerRegisteredSuccessMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
		
	}

//	public String getCustomerIDValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_IN_TABLE);
//	}
	
	public String getCustomerNameValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_IN_TABLE);
	}

	public String getBirthdayValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
	}

	public String getGenderValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
	}

	public String getAddressValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
	}

	public String getCityValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
	}
	
	public String getStateValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
	}

	public String getPINValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
	}
	
	public String getPhoneValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
	}

	public String getEmailValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
	}

	/*
	public DepositPageObject openDepositPage() {
		waitForElementVisible(driver, NewCustomerPageUI.DEPOSIT_LINK);
		clickToElement(driver, NewCustomerPageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPage(driver);
	}

	public HomePageObject openHomePage() {
		waitForElementVisible(driver, NewCustomerPageUI.MANAGER_LINK);
		clickToElement(driver, NewCustomerPageUI.MANAGER_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	*/
	
}

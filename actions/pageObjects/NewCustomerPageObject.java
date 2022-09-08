package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;

	//.. Ham khoi tao: Map driver
	public NewCustomerPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at NewCustomerPage layer = " + driver.toString());
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

	public String getCustomerNameValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBirthdayValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGenderValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStateValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhoneValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmailValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}
		
}

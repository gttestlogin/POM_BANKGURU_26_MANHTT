//[Online 10] - Topic 26 (POM 08 - WebDriver Life Cycle/ Action Chain)
//Cach cu: 14 pages x 13 (di toi 13 pages khac)
//Do do can viet common functions tai AbstractPage vaf AbstractPageUI de open Page Object


package com.bankguru.account;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_07_RegisterAndLogin_ActionChain_WebDriverCycle extends AbstractTest {	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		
		//Giau ham khoi tao voi PageGenerator
		//Open App Url -> Login Page (Action Chain) 
		loginPage = PageGeneratorManager.getLoginPage(driver);
				
		System.out.println("Driver at TestCase layer = " + driver.toString());
		emailValue = "auto" + randomDataTest() + "@gmail.com";
		
	}
	
	@Test
	public void TC_01_RegisterToSystem() {		
		loginPageUrl = loginPage.getLoginPageUrl();
		
		//che dau ham khoi tao
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		//sau khi clickToHereLink thì sẽ chuyển qua RegisterPageObject
		//Login Page -> click to Here link -> Register Page 
		registerPage = loginPage.clickToHereLink();
		
		
		//Skip Ads
		driver.get("https://demo.guru99.com/");
		
		System.out.println("REGISTER - STEP: 2. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(emailValue);
				
		System.out.println("REGISTER - STEP: 3. Click to SUBMIT button");
		registerPage.clickToSubmitButton();
		
		System.out.println("REGISTER - STEP: 4. Get Username/Password infor");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
		System.out.println("username" +username);
	}

	@Test
	public void TC_02_LoginToSystem() {
		
		//che dau ham khoi tao
		System.out.println("LOGIN - STEP: 1. Open Login Page");
		//Register Page -> open Login Page Url -> login Page
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);
		
		System.out.println("LOGIN - STEP: 2. Input to User ID/ Passwor textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		//che dau ham khoi tao
		System.out.println("LOGIN - STEP: 3. Click to LOGIN button");
		//Login Page -> click to Login button -> Home Page
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("LOGIN - STEP: 4. Verify Welcome Message is displayed");
		Assert.assertTrue(homePage.isWelcomMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		System.out.println("LOGIN - STEP: 5. Verify User ID is displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));

	}
	
	@Test
	public void TC_03_OpenMultiplePage() throws InterruptedException {
		System.out.println("Action Chain - Step 1: Home Page navigates to New Customer Page");
		//homePage da ke thua AbstractPage nen co the su dung openNewCustomerPage
		newCustomerPage = homePage.openNewCustomerPage(driver);
//		newCustomerPage.refreshToPage(driver);
		Thread.sleep(1000);
		System.out.println("Action Chain - Step 2: New Customer Page navigates to Deposit Page");
		depositPage = newCustomerPage.openDepositPage(driver);
		Thread.sleep(1000);
		System.out.println("Action Chain - Step 3: Deposit Page navigates to New Account Page");
		Thread.sleep(1000);
		newAccountPage = depositPage.openNewAccountPage(driver);
		Thread.sleep(1000);
//		Thread.sleep(5000);
		
//		newAccountPage.refreshToPage(driver);
		
		System.out.println("1");
		loginPage = newAccountPage.openLogoutLink(driver);
//		newAccountPage.openLogoutLink(driver);
//		loginPage = newAccountPage.navigateToLoginPage(driver);
		System.out.println("2");
		
		//driver.get("https://demo.guru99.com/v4/manager/Logout.php");
		//loginPage = driver.getCurrentUrl(); 

		loginPage.inputToUserIDTextbox(username);
		System.out.println("3");
		Thread.sleep(1000);
		loginPage.inputToPasswordTextbox(password);
		System.out.println("4");
		homePage = loginPage.clickToLoginButton();
		Thread.sleep(1000);
		newAccountPage = homePage.openNewAccountPage(driver);
		Thread.sleep(1000);
		System.out.println("Action Chain - Step 4: New Account Page navigates to Home Page");
		homePage = newAccountPage.openHomePage(driver);
		Thread.sleep(1000);
		System.out.println("Action Chain - Step 5: Home Page navigates to Deposit Page");
		depositPage = homePage.openDepositPage(driver);
		Thread.sleep(1000);
		loginPage = newAccountPage.openLogoutLink(driver);
		Thread.sleep(1000);
		loginPage.inputToUserIDTextbox(username);
		Thread.sleep(1000);
		loginPage.inputToPasswordTextbox(password);
		Thread.sleep(1000);
		homePage = loginPage.clickToLoginButton();
		newCustomerPage = homePage.openNewCustomerPage(driver);
		
		System.out.println("Action Chain - Step 6: Deposit Page navigates to New Customer Page");
		newCustomerPage = depositPage.openNewCustomerPage(driver);

		System.out.println("Action Chain - Step 7: New Customer Page navigates to Home Page");
		homePage = newCustomerPage.openHomePage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	WebDriver driver;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;

	long shortTimeout = 5;
	long longTimeout = 30;
	
	String projectPath, username, password, loginPageUrl, emailValue;
//	String customerNameValue, dateOfBirthValue, addressValue, cityValue, genderMaleValue;
//	String stateValue, pinValue, phoneValue, emailValue, passwordValue;
	
}

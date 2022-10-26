//[Online 10] - Topic 24 (POM 06 - PageFactorySelenium and PageGeneratorManager)
//https://www.youtube.com/watch?v=ay1X0vP2_EY
	
package com.bankguru.account;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_09_RegisterAndLogin_Assert_Verify_Log_ReportHTML extends AbstractTest {	
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
		System.out.println("REGISTER - STEP: 1.1 Verify Home Page is displayed");
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		
		//co trong DOM nhung khong hien tren UI
		System.out.println("REGISTER - STEP: 1.2.1 Verify Delete Customer Form is not displayed");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkUndisplayed());

		System.out.println("REGISTER - STEP: 1.2.2 Click to Selenium Dropdown Toggle");
		loginPage.clickToSeleniumDropdownToggle();

		System.out.println("REGISTER - STEP: 1.2.3 Verify Delete Customer Form is displayed (after click to Selenium)");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
		
		System.out.println("REGISTER - STEP: 1.3 Verify Home Page is not displayed");
		Assert.assertTrue(loginPage.isHomePageUndisplayed());

		System.out.println("REGISTER - STEP: 1.4 Verify Register Page is not displayed");
		Assert.assertTrue(loginPage.isRegisterPageUndisplayed());	
	}

	@Test (enabled = false)
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
	
	@Test (enabled = false)
	public void TC_03_OpenMultiplePage() {
		System.out.println("Action Chain - Step 1: Home Page navigates to New Customer Page");
		//homePage da ke thua AbstractPage nen co the su dung openNewCustomerPage
		//newCustomerPage = homePage.openNewCustomerPage(driver);
		//Cách 1 - openMultiplePage (Cash to page) - Số lượng pages ít, return trong openMultiplePage
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiplePage(driver, "New Customer");
				
		System.out.println("Action Chain - Step 2: New Customer Page navigates to Deposit Page");
		//depositPage = newCustomerPage.openDepositPage(driver);
		//Cách 1 - openMultiplePage (Cash to page) - Số lượng pages ít, return trong openMultiplePage
		depositPage = (DepositPageObject) newCustomerPage.openMultiplePage(driver, "Deposit");
		
		System.out.println("Action Chain - Step 3: Deposit Page navigates to New Account Page");
		//newAccountPage = depositPage.openNewAccountPage(driver);
		//Cách 2 - goi ham map driver ỏ tầng TC - Số lượng pages nhiều, xử lí chuyển thẳng ở tầng TC
		depositPage.openMultiplePages(driver, "New Account");
		//goi ham map driver
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
		
		System.out.println("Action Chain - Step 4: New Account Page navigates to Home Page");
		//homePage = newAccountPage.openHomePage(driver);
		newAccountPage.openMultiplePage(driver, "New Account");
		homePage = PageGeneratorManager.getHomePage(driver);

		
		System.out.println("Action Chain - Step 5: Home Page navigates to Deposit Page");
		//depositPage = homePage.openDepositPage(driver);
		homePage.openMultiplePage(driver, "Deposit");
		depositPage = PageGeneratorManager.getDepositPage(driver);
		
		System.out.println("Action Chain - Step 6: Deposit Page navigates to New Customer Page");
		//newCustomerPage = depositPage.openNewCustomerPage(driver);
		depositPage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		System.out.println("Action Chain - Step 7: New Customer Page navigates to Home Page");
		//homePage = newCustomerPage.openHomePage(driver);
		newCustomerPage.openMultiplePage(driver, "Manager");
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
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
	
	String projectPath, username, password, loginPageUrl, emailValue;
//	String customerNameValue, dateOfBirthValue, addressValue, cityValue, genderMaleValue;
//	String stateValue, pinValue, phoneValue, emailValue, passwordValue;
	
}
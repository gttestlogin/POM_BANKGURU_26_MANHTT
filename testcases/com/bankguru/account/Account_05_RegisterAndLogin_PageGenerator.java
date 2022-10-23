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

public class Account_05_RegisterAndLogin_PageGenerator extends AbstractTest {
	//chua xu li giau du lieu
//	String pathProject = System.getProperty("user.dir");
	
	@Parameters("browser")
	
	@BeforeClass
	public void beforeClass(String browserName) {
//		System.out.println("pathProject: " +pathProject);
		
		//System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
		//driver = new ChromeDriver();
		driver = openMultiBrowser(browserName);
		
		System.out.println("Driver at Testcase layer = " + driver.toString());
		
		emailValue = "auto" + randomDataTest() + "@gmail.com";
		
//		loginPage = new LoginPageObject(driver);
//		registerPage = new RegisterPageObject(driver);
//		homePage = new HomePageObject(driver);
//		newCustomerPage = new NewCustomerPageObject(driver);

//		genderMaleValue ="male";
//		customerNameValue = "manhkaka";
//		dateOfBirthValue = "1990-12-15";
//		addressValue = "Z06 Road 13";
//		cityValue = "Hanoi";
//		stateValue = "Hanoi";
//		pinValue = "123456";
//		phoneValue = "0898993290";
//		emailValue = "auto" + randomDataTest() + "@gmail.com";
//		passwordValue = "12341234";
		
		
		
		//sau khi mo ra Url => khoi tao Login Page
		//loginPage = new LoginPageObject(driver);
		
		//Giau ham khoi tao voi PageGenerator
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		System.out.println("PRE-CONDITION-STEP: 2. Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
		/*
		auto1@gmail.com
		mngr434926
		epArumY
		*/
	}
	
	@Test
	public void TC_01_RegisterToSystem() {		
		/* original - không giấu hàm khởi tạo
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		loginPage.clickToHereLink();
		
		//Sau khi click Here Link => Khoi tao Register Page
		registerPage = new RegisterPageObject(driver);
		*/
		
		//che dau ham khoi tao
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		//sau khi clickToHereLink thì sẽ chuyển qua RegisterPageObject
		registerPage = loginPage.clickToHereLink();
		
		
		//Skip Ads
		driver.get("https://demo.guru99.com/");
		
		System.out.println("REGISTER - STEP: 2. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(emailValue);
		
		//registerPage.sendTabToEmailTextbox();
		
		System.out.println("REGISTER - STEP: 3. Click to SUBMIT button");
		registerPage.clickToSubmitButton();
		
		System.out.println("REGISTER - STEP: 4. Get Username/Password infor");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
		System.out.println("username" +username);
	}

	@Test
	public void TC_02_LoginToSystem() {
		/*original - không giấu hàm khởi tạo
		System.out.println("LOGIN - STEP: 1. Open Login Page");
		registerPage.openLoginPageUrl(loginPageUrl);
		
		//sau khi get lai Url cua Login Page => khoi tao LoginPage lan nua
		//Theo mo hinh page Object: Khi chuyen page đến page mới thì phải khởi tạo page đó lên
		loginPage = new LoginPageObject(driver);
		*/
		
		//che dau ham khoi tao
		System.out.println("LOGIN - STEP: 1. Open Login Page");
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);
		
		System.out.println("LOGIN - STEP: 2. Input to User ID/ Passwor textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		/* original - ko che dau ham khoi tao
		System.out.println("LOGIN - STEP: 3. Click to LOGIN button");
		loginPage.clickToLoginButton();

		//khoi tao HomePage
		homePage = new HomePageObject(driver);
		*/
		
		//che dau ham khoi tao
		System.out.println("LOGIN - STEP: 3. Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("LOGIN - STEP: 4. Verify Welcome Message is displayed");
		Assert.assertTrue(homePage.isWelcomMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		System.out.println("LOGIN - STEP: 5. Verify User ID is displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));

	}
	
	@Test
	public void TC_03_OpenMultiplePage() {
		newCustomerPage = homePage.openNewCustomerPage(driver);
		
		depositPage = newCustomerPage.openDepositPage(driver);
		
		newAccount = depositPage.openNewAccountPage(driver);
		
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
	NewAccountPageObject newAccount;
	
	long shortTimeout = 5;
	long longTimeout = 30;
	
	String projectPath, username, password, loginPageUrl, emailValue;
//	String customerNameValue, dateOfBirthValue, addressValue, cityValue, genderMaleValue;
//	String stateValue, pinValue, phoneValue, emailValue, passwordValue;
	
}

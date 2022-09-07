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
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_03_RegisterAndLogin_PageObjectPattern extends AbstractPage {

	WebDriver driver;
	String projectPath, email, username, password, loginPageUrl;
	long shortTimeout = 5;
	long longTimeout = 30;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	
	@BeforeClass
	public void beforeClass() {
		
		String pathProject = System.getProperty("user.dir");
		
		// Setting system properties of FirefoxDriver
		System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
		/*Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();
		*/
		
		System.out.println("Driver at Testcase layer = " + driver.toString());
		
		email = "auto" + randomDataTest() + "@gmail.com";
		
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);
		
		//selenium api: xu li triet de theo PO trong bai Multi-browsers
		System.out.println("PRE-CONDITION-STEP: 1. Open BankGuru Application");
		driver.get("https://demo.guru99.com/v4/");
		
		System.out.println("PRE-CONDITION-STEP: 2. Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
		/*
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);//deprecated in selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
		driver.manage().window().maximize();
		*/
		
		/*
		auto1@gmail.com
		mngr434926
		epArumY
		*/
	}
	
	@Test
	public void TC_01_RegisterToSystem() {		
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		loginPage.clickToHereLink();
		
		//Skip Ads
		openUrl(driver, "https://demo.guru99.com/");
		
		System.out.println("REGISTER - STEP: 2. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);
		
		System.out.println("REGISTER - STEP: 3. Click to SUBMIT button");
		registerPage.clickToSubmitButton();
		
		System.out.println("REGISTER - STEP: 4. Get Username/Password infor");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("LOGIN - STEP: 1. Open Login Page");
		registerPage.openLoginPageUrl(loginPageUrl);
		
		System.out.println("LOGIN - STEP: 2. Input to User ID/ Passwor textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LOGIN - STEP: 3. Click to LOGIN button");
		loginPage.clickToLoginButton();

		System.out.println("LOGIN - STEP: 4. Verify Welcome Message is displayed");
		Assert.assertTrue(homePage.isWelcomMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		System.out.println("LOGIN - STEP: 5. Verify User ID is displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
}

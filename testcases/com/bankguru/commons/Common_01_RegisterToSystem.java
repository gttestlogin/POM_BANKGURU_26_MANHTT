//[Online 10] - Topic 24 (POM 06 - PageFactorySelenium and PageGeneratorManager)
//https://www.youtube.com/watch?v=ay1X0vP2_EY
	
package com.bankguru.commons;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

public class Common_01_RegisterToSystem extends AbstractTest {	
	@Parameters("browser")
	@BeforeTest	
	//chay truoc toan bo du an
	//register xong lay username/pass dung chung cho toan bo system
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		//Giau ham khoi tao voi PageGenerator
		//Open App Url -> Login Page (Action Chain) 
		loginPage = PageGeneratorManager.getLoginPage(driver);
		emailValue = "auto" + randomDataTest() + "@gmail.com";
		//log.info("Driver at TestCase layer = " + driver.toString());
		
		//dua Register vao dau tien
		log.info("PRE-COND - REGISTER - STEP: 1. Verify Home Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		//che dau ham khoi tao
		log.info("PRE-COND - REGISTER - STEP: 2. Click to 'Here' link");
		//sau khi clickToHereLink thì sẽ chuyển qua RegisterPageObject
		//Login Page -> click to Here link -> Register Page 
		registerPage = loginPage.clickToHereLink();
		
		//Skip Ads
		//driver.get(Constants.TEST_URL);
		
		log.info("PRE-COND - REGISTER - STEP: 3. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(emailValue);
		
		//registerPage.sendTabToEmailTextbox();
		
		log.info("PRE-COND - REGISTER - STEP: 4. Click to SUBMIT button");
		registerPage.clickToSubmitButton();
		
		log.info("PRE-COND - REGISTER - STEP: 5. Get Username/Password infor");
		USERNAME = registerPage.getUsernameInformation();
		PASSWORD = registerPage.getPasswordInformation();
	
		System.out.println("USERNAME in Common_01_RegisterToSystem: " + USERNAME);
		System.out.println("PASSWORD in Common_01_RegisterToSystem: " + PASSWORD);

		closeBrowserAndDriver(driver);
				
	}

	public static String USERNAME, PASSWORD;
	
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;
	String projectPath, loginPageUrl, emailValue;
//	String customerNameValue, dateOfBirthValue, addressValue, cityValue, genderMaleValue;
//	String stateValue, pinValue, phoneValue, emailValue, passwordValue;
	
}
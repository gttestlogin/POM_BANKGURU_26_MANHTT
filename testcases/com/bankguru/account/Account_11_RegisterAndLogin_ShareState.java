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

import com.bankguru.commons.Common_01_RegisterToSystem;

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

public class Account_11_RegisterAndLogin_ShareState extends AbstractTest {	
	
	//Cach 1 - 1.1 Theo cach thong thuong can khai bao, import va khoi tao
	//Common_01_RegisterToSystem commonRegister;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		//Cach 1 - 1.2 Va khoi tao tai day
		//commonRegister = new Common_01_RegisterToSystem();
		
		driver = openMultiBrowser(browserName);
		
		//Giau ham khoi tao voi PageGenerator
		//Open App Url -> Login Page (Action Chain) 
		loginPage = PageGeneratorManager.getLoginPage(driver);
				
		//System.out.println("Driver at TestCase layer = " + driver.toString());
		emailValue = "auto" + randomDataTest() + "@gmail.com";
		
		//che dau ham khoi tao
		log.info("LOGIN - STEP: 1. Open Login Page");
		//Register Page -> open Login Page Url -> login Page
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);
		
		log.info("LOGIN - STEP: 2. Input to User ID/ Passwor textbox");
		//Cach 1 - 1.3 va goi theo cu phap
		//loginPage.inputToUserIDTextbox(commonRegister.USERNAME);
		//loginPage.inputToPasswordTextbox(commonRegister.PASSWORD);
		//Cach 2 - Do da set USERNAME/PASSWORD la staic nen co the goi truc tiep qua tên class
		loginPage.inputToUserIDTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToUserIDTextbox(Common_01_RegisterToSystem.USERNAME);
		
		//che dau ham khoi tao
		log.info("LOGIN - STEP: 3. Click to LOGIN button");
		//Login Page -> click to Login button -> Home Page
		homePage = loginPage.clickToLoginButton();
		
		log.info("LOGIN - STEP: 4. Verify Welcome Message is displayed");
		verifyTrue(homePage.isWelcomMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		log.info("LOGIN - STEP: 5. Verify User ID is displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USERNAME));
		
		System.out.println("USERNAME in Account_11_RegisterAndLogin_ShareState: " + Common_01_RegisterToSystem.USERNAME);
		System.out.println("PASSWORD in Account_11_RegisterAndLogin_ShareState: " + Common_01_RegisterToSystem.PASSWORD);
	}
	
	public void TC_01_CreateNewCustomer() {
		
	}
	
	public void TC_02_EditCustomer() {
		
	}

	public void TC_03_CreateNewAccount() {
	
	}
	
	public void TC_04_DepositToOtherUser() {
		
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
	
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
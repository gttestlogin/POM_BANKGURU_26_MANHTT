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

public class Account_02_RegisterAndLogin_AbstractPage_02 extends AbstractPage {

	WebDriver driver;
	String projectPath, email, username, password, loginPageUrl;
	long shortTimeout = 5;
	long longTimeout = 30;
	
	//Khai bao instance cua AbstractPage class
	AbstractPage abstractPage;
	
	@BeforeClass
	public void beforeClass() {
		
		String pathProject = System.getProperty("user.dir");
		
		// Setting system properties of FirefoxDriver
		System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
		//Setting system properties of ChromeDriver
		// System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
		// driver = new ChromeDriver();	
		
		//Khong can khoi tao
		//abstractPage = new AbstractPage();
		email = "auto" + randomDataTest() + "@gmail.com";
		
		openUrl(driver, "https://demo.guru99.com/v4/");
		
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);//deprecated in selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
		driver.manage().window().maximize();
		
		loginPageUrl = getCurrentPageUrl(driver);
		
		/*
		auto1@gmail.com
		mngr434926
		epArumY
		*/
	}
	
	@Test
	public void TC_01_RegisterToSystem() {		
		System.out.println("STEP: 1. Click to 'Here' link");
		clickToElement(driver, "//a[contains(text(),'here')]");
		
		//Skip Ads
		openUrl(driver, "https://demo.guru99.com/");
		
		System.out.println("STEP: 2. Input to Email ID textbox");
		sendkeyToElement(driver, "//input[@name='emailid']", email);
		
		System.out.println("STEP: 3. Click to SUBMIT button");
		clickToElement(driver, "//input[@name='btnLogin']");
		
		System.out.println("STEP: 4. Get Username/Password infor");
		username = getTextElement(driver, "//td[contains(text(),'User ID :')]/following-sibling::td");
		username = getTextElement(driver, "//td[contains(text(),'Password :')]/following-sibling::td");
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

package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Account_01_RegisterAndLogin_StepByStep {

	WebDriver driver;
	String projectPath, email, username, password, loginPageUrl;
	long shortTimeout = 5;
	long longTimeout = 30;
	
	@BeforeClass
	public void beforeClass() {
		
		String pathProject = System.getProperty("user.dir");
		
		// Setting system properties of FirefoxDriver
		System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
		//Setting system properties of ChromeDriver
		// System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
		// driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/v4/");
		
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);//deprecated in selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
		driver.manage().window().maximize();
		
		loginPageUrl = driver.getCurrentUrl();
		email = "auto" + randomDataTest() + "@gmail.com";
		
		/*
		auto1@gmail.com
		mngr434926
		epArumY
		*/
	}
	
	@Test
	public void TC_01_RegisterToSystem() {		
		System.out.println("STEP: 1. Click to 'Here' link");
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		
		//Skip Ads
		driver.get("https://demo.guru99.com/");
		
		System.out.println("STEP: 2. Input to Email ID textbox");
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		
		System.out.println("STEP: 3. Click to SUBMIT button");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		System.out.println("STEP: 4. Get Username/Password infor");
		username = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td")).getText();
		
	}
	
	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("STEP: 1. Open Login Page");
		driver.get(loginPageUrl);
		
		System.out.println("STEP: 2. Input to User ID/ Passwor textbox");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		System.out.println("STEP: 3. Click to LOGIN button");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		System.out.println("STEP: 4. Verify Welcome Message is displayed");
		// String welcomeMessage = driver.findElement(By.xpath("//marquee[contains(text(),\"Welcome To Manager's Page of Guru99 Bank\")]")).getText();
		String welcomeMessage = driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");
		
		System.out.println("STEP: 5. Verify User ID is displayed");
		// Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Manger Id : " +username+"')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='heading3']/child::td")).isDisplayed());
		
		
		//Web Browser
		//driver...
		
		//Web Element
		//WebElement element = driver.findElement(By.xpath(""));
		//element....
		
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

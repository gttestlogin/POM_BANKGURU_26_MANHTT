package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.RegisterPageUI;

public class NewAccountPageObject extends AbstractPage {

	WebDriver driver;
	
	//Ham khoi tao: Map driver
	public NewAccountPageObject (WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver at NewAccountPageObject layer = " + driver.toString());
	}
	
}

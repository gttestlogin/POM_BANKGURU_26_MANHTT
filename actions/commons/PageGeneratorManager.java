//[Online 10] - Topic 27 (POM 09 - Dynamic Locator and Rest Parameters)
//https://www.youtube.com/watch?v=epxoAXZ4QeA

package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {
	
	public static String homePageUrl, emailErrorMessage;
	//neu khong de "static" thi khi sang các class như LoginPageObject sẽ không thể PageGeneratorManager.loginUrl 
	public String loginUrl;	
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class LoginPageFactory extends AbstractPage{
	
	@FindBy(how = How.XPATH, using ="//input[@name='uid']")
	private WebElement userIDTextbox;
	
	@FindBy(how = How.XPATH, using ="//input[@name='password']")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using ="//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'here')]")
	private WebElement hereLink;
	
	//ham khoi tao
	public LoginPageFactory(WebDriver driver) {
		 this.driver = driver;
		 //khoi tao element
		 PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	private WebDriver driver;
	
	//cac ham duoi day tuong tu trong LoginPageObject.java
	public void clickToHereLink() {
		//way2: Selenium API theo dang PageFactory
		waitForElementVisible(driver,hereLink);
		//hereLink.click();
		clickToElement(driver, hereLink);
		//end of way2
	}

	public void inputToUserIDTextbox(String username) {
		userIDTextbox.sendKeys(username);
	}

	public void inputToPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void clickToLoginButton() {
		loginButton.click();
	}
	
}

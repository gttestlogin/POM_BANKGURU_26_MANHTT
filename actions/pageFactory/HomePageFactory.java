package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	
	@FindBy(how = How.XPATH, using ="//marquee[@class='heading3']")
	private WebElement welcomeMessageText;
	
	@FindBy(how = How.XPATH, using ="//tr[@class='heading3']/child::td")
	private WebElement userIDText;
	
	private WebDriver driver;
	
	//ham khoi tao
	public HomePageFactory(WebDriver driver) {
		 this.driver = driver;
		//khoi tao element
		 PageFactory.initElements(driver, this);
	}
	
	//cac ham duoi day tuong tu trong HomePageObject.java
	public boolean isWelcomMessageDisplayed(String expectedText) {
		String actualText = welcomeMessageText.getText().trim();
		return actualText.equals(expectedText);
	}

	public boolean isUserIDDisplayed(String userID) {
		String actualText = userIDText.getText().trim();
		return actualText.equals("Manger Id : " + userID);
	}
}

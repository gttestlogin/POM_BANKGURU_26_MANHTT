package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageUIs.AbstractPageUI;
import pageUIs.DepositPageUI;

public class AbstractPage {
	
	/*
	public void clickToLoginButton() {
		System.out.println("");
	}

	public String getUserIDText() {
		return "";
	}

	public static void main(String[] args) {
		ExtentReport extent = new ExtentReport();
		System.out.println("extent.address: " + extent.address);
		extent.showHTMLReport("Selenium Online Class");

	}

	WebDriver driver;
	WebElement userIDTextbox;
	WebDriverWait waitExplicit;
	
	public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	*/
	
	/* Web Browser */
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	/* Web Driver */
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedValueltem) throws Exception {
		// Click v??o dropdown cho x??? h???t t???t c??? c??c gi?? tr??? ra
		element = driver.findElement(By.xpath(parentXpath));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click():", element);
		Thread.sleep(1000);

		// Ch??? cho t???t c??? c??c gi?? tr??? trong dropdown ???????c load ra th??nh c??ng
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		elements = driver.findElements(By.xpath(allItemXpath));
		// System.out.println("Tat ca phan tu trong dropdown = " + allItems.size());

		// Duy???t qa h???t t???t c??? c??c ph???n t??? cho ?????n khi th???a m??n ??i???u ki???n
		for (WebElement childElement : elements) {
			// System.out.println("Text moi lan get = " + childElement.getText());
			if (childElement.getText().contains(expectedValueltem)) {
				// Click v??o item c???n ch???n
				if (childElement.isDisplayed()) {
					// System.out.println("Click by Selenium = "+childElement.getText());
					childElement.click();
				} else {
					javascriptExecutor.executeScript("arguments[0].scrollintoView(true);", childElement);
					Thread.sleep(1000);
					// System.out.println("Click by JS =" + childElement.getText());
					javascriptExecutor.executeScript("arguments[0].click():", childElement);
				}
				Thread.sleep(1000);
				break;
			}
		}
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		String actualText = element.getText();
		System.out.println("");
		System.out.println("");
		return element.getText();
	}
	
	public int countElementsNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	//Switch to child Windows (only 2 windows)
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
	
	// Switch to child Windows (greater than 2 windows and title of the pages are
	// unique)
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}
	
	
	// Close all windows without parent window
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}
	
	//JS Executor Function
	//https://gist.github.com/daominhdam/e639d2d2569e27b43c7a9eac326e2737
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript(javaScript);
	}
	
	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		javascriptExecutor = (JavascriptExecutor) driver;
		String textActual = (String) javascriptExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		System.out.println("Text actual = " +textActual);
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String value, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String attributeRemove, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) javascriptExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				element);
		return status;
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
//		element = driver.findElement(By.xpath(locator));
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	//dung cho PageFactory
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	
	//dung cho PageFactory
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		// waitExplicit = new WebDriverWait(driver, longTimeout);	//deprecated in selenium 4
		waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(longTimeout));
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	
	//common functions open page objects
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);		
	}
	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageGeneratorManager.getNewAccountPage(driver);		
	}
	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.MANAGER_LINK);
		clickToElement(driver, AbstractPageUI.MANAGER_LINK);
		return PageGeneratorManager.getHomePage(driver);		
	}
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPage(driver);		
	}
	public LoginPageObject openLogoutLink(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.LOGOUT_LINK);
		clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
		acceptAlert(driver);
		sleepInSecond(driver, 3);
		return PageGeneratorManager.getLoginPage(driver);		
	}
	
	public LoginPageObject navigateToLoginPage(WebDriver driver) {
		driver.navigate().to("https://demo.guru99.com/");
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	public void sleepInSecond(WebDriver driver, long timeSecond) {
		try {
			Thread.sleep(longTimeout);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private WebElement element;
	private List<WebElement> elements;
	private Select select;				//khai bao thu vien select
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	private Actions action;
	By byLocator;
	long shortTimeout = 5;
	long longTimeout = 30;
	
}

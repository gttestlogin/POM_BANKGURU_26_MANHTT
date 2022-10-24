package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String HOME_PAGE_LINK = "//a[text()='Manager']";
		String NEW_CUSTOMER_PAGE_LINK = "//a[text()='New Customer']";
		String EDIT_CUSTOMER_LINK = "//a[text()='Edit Customer']";

		//Dynamic
		String DYNAMIC_MENU_LINK = "//a[text()='%s']";
		String DYNAMIC_MENU_CONTEXT_LINK = "//a[text()='%s']//span[text()='%s']";
		String DYNAMIC_ROW_DELETE = "//a[text()='%s']//span[text()='%s']//span[text()='%s']//span[text()='%s']";

		
		/*way 1: neu su dung public void clickToElement(String locator) - khong co static
		//can khoi tao
		DynamicLocator dyn = new DynamicLocator();
		dyn.clickToElement(HOME_PAGE_LINK);
		dyn.clickToElement(NEW_CUSTOMER_PAGE_LINK);
		dyn.clickToElement(EDIT_CUSTOMER_LINK);
		*/

		//way 2: neu su dung public static void clickToElement(String locator) { - co static
		clickToElement(HOME_PAGE_LINK);
		clickToElement(NEW_CUSTOMER_PAGE_LINK);
		clickToElement(EDIT_CUSTOMER_LINK);
		
		//Way 3: Dynamic
		clickToElement(DYNAMIC_MENU_LINK, "Manager");
		clickToElement(DYNAMIC_MENU_LINK, "New Customer");
		clickToElement(DYNAMIC_MENU_LINK, "Edit Customer");
		clickToElement(DYNAMIC_MENU_LINK, "New Account");

		clickToElement(DYNAMIC_MENU_CONTEXT_LINK, "one", "two");
		clickToElement(DYNAMIC_MENU_CONTEXT_LINK, "100", "200");

		clickToElement(DYNAMIC_ROW_DELETE, "one", "two", "three", "four");
		clickToElement(DYNAMIC_ROW_DELETE, "100", "200", "300", "400");
	}
	
	/*
	public static void clickToElement(String locator) {
		System.out.println("Click to element: " +locator);
	}

	//với 2 params
	public static void clickToElement(String locator, String pageName) {
		//locator: //a[text()='%s']
		//pageName: Manager
		//String.format sẽ nhét pageName vào %s của locator
		
		locator = String.format(locator, pageName);
		System.out.println("Click to element: " +locator);
	}
	
	//với 3 params
	public static void clickToElement(String locator, String pageName, String value) {
		locator = String.format(locator, pageName, value);
		System.out.println("Click to element: " +locator);
	}
	
	//với 5 params
	public static void clickToElement(String locator, String param_01, String param_02, String param_03, String param_04) {
		locator = String.format(locator, param_01, param_02, param_03, param_04);
		System.out.println("Click to element: " +locator);
	}
	*/
	
	//với Rest Parameters (bao gồm cho cả 3 hàm trên rồi 1/2/3/5 params)
	public static void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to element: " +locator);
	}
	
	
}

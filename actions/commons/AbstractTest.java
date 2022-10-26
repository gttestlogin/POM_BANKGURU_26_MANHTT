package commons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AbstractTest {

	private WebDriver driver;
	
	protected final Log log;
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver openMultiBrowser(String browserName) {
		//chua xu li giau du lieu
		String pathProject = System.getProperty("user.dir");
				
		if(browserName.equalsIgnoreCase("firefox")) {
				// Setting system properties of FirefoxDriver
				System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver.exe");
				//MacOS, cho chromedriver va firefoxdriver macOS vao /usr/local/bin
				//System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver");
				driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
				//Setting system properties of ChromeDriver
				System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver.exe");
				//MacOS
				//System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
				driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("chromeheadless")) {
			//Setting system properties of ChromeDriver
			System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size" + Constants.HEADLESS_RESOLUTION);
			
			//MacOS
			//System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver");
			driver = new ChromeDriver(options);

		}
		else {
			System.out.println("Please input driver");
		}

		System.out.println("Driver at AbstractTest layer = " + driver.toString());

		//selenium api: xu li triet de theo PO trong bai Multi-browsers
		System.out.println("PRE-CONDITION-STEP: 1. Open BankGuru Application");
		//chua xu li giau du lieu
		driver.get(Constants.TEST_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.LONG_TIMEOUT));

		return driver;
		
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}

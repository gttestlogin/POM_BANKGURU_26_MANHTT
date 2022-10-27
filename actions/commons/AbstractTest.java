//Dung chung cho tang Test Case
package commons;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

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
				//WebDriverManager.firefoxdriver().setup();
				
				//MacOS, cho chromedriver va firefoxdriver macOS vao /usr/local/bin
				//System.setProperty("webdriver.gecko.driver", pathProject + "/browserDrivers/geckodriver");
				driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
				//Setting system properties of ChromeDriver
				System.setProperty("webdriver.chrome.driver", pathProject + "/browserDrivers/chromedriver.exe");
				//WebDriverManager.chromedriver().setup();
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
	
	//chi cho tang TC su dung
	protected int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

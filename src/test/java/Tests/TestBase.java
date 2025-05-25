package Tests;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase  extends AbstractTestNGCucumberTests{

	protected static WebDriver driver;

	public static String downloadPath = System.getProperty("user.dir") + File.separator+ "Downloads" ;

	public static ChromeOptions  chromeOptions() {
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs", chromePrefs);
		option.setAcceptInsecureCerts(true);
		return option ;
	}

	@BeforeSuite
	@Parameters ({"browser"})

	public void startDriver( @Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(chromeOptions());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver =  new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		//		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.navigate().to("https://www.automationexercise.com/");
	}

	@AfterMethod
	public void screenshotOnFailure (ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Failure!");
			System.out.println("Taking Screeshot...");
			Helper.captureScreenshot(driver, result.getName());
		}
	}


	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
}

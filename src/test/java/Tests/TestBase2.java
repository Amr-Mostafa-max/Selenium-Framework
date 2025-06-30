package Tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;

public class TestBase2 {

	public static String baseURL = "https://www.automationexercise.com/";
	protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>(); ;

	@org.testng.annotations.BeforeClass
	@Parameters({"browser"})
	public void setUp ( @Optional("chrome") String browser) throws URISyntaxException, MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URI("http://192.168.1.8:4444").toURL(), caps));
		getDriver().navigate().to(baseURL);
	}

	public WebDriver getDriver () {
		return driver.get();

	}

	@org.testng.annotations.AfterClass
	public void stopDriver () {
		getDriver().quit();
		driver.remove();
	}

	public void screenshotOnFailure (ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Failure!");
			System.out.println("Taking Screeshot...");
			Helper.captureScreenshot(getDriver(), result.getName());
		}
	}

}



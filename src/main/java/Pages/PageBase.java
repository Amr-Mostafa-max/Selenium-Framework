package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver ;

	// create constructor
	public PageBase (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton( WebElement button) {
		button.click();
	}

	protected static void SentText( WebElement txt , String value) {
		txt.sendKeys(value);
	}
	

	protected static void SentInt( WebElement txt , Integer value) {
		txt.sendKeys(value.toString());
	}

	protected static void selectFromDW ( WebElement countryDw , String country) {
		Select select = new Select(countryDw);
		select.selectByValue(country);
	}

	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript ("scrollBy(0,1000)");
	}

	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("scrollBy (0,-500)");
	}
}

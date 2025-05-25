package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	public HomePage (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath  = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement registerLink ;

	@FindBy(xpath =  "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
	WebElement contactUsLink ;

	@FindBy (linkText = "Products")
	public  WebElement productLink;

	public void openRgisterationLink() {
		clickButton(registerLink);
	}

	public void openContactUsLink() {
		clickButton(contactUsLink);
	}

	public void openProductLink() {
		clickButton(productLink);
	}
	public void userCanScrollDown() {
		scrollPageDown();
	}

	public void userCanScrollPageup() {
		scrollPageUp();
	}

}
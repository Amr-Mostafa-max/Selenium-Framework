package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
	WebElement name ;

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	WebElement emailField;

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signupBtn;

	@FindBy (id = "id_gender1")
	WebElement genderRdoBtn ;

	@FindBy (id = "password")
	WebElement passTxtBox;

	@FindBy (id = "first_name")
	WebElement fnTxtBox;

	@FindBy (id = "last_name")
	WebElement lnTxtBox ;

	@FindBy (id = "address1")
	WebElement adressTxtBox;

	protected	@FindBy (id = "country")
	WebElement countryDw;

	@FindBy (id = "state")
	WebElement stateTxtBox ;

	@FindBy(id = "city")
	WebElement cityTxtBox;

	@FindBy(id = "zipcode")
	WebElement zipCodeTxtBox;

	@FindBy(id = "mobile_number")
	WebElement mobileBox;

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
	WebElement createAccBtn;

	public  @FindBy (xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	WebElement successTxt ;

	@FindBy (linkText = "Continue")
	WebElement continueBtn ;

	@FindBy(partialLinkText = "Logout")
	WebElement logoutLink ;

	public void newUserSignup(String Name , String email) {

		SentText(name, Name);
		SentText(emailField, email );
		clickButton(signupBtn);
	}

	public void userRegisteration(String fName , String lName ,String pass, String address , 
			String country ,String state ,String city, String zCode , String mobNo )
	{
		clickButton(genderRdoBtn);
		SentText(passTxtBox, pass);
		SentText(fnTxtBox, fName);
		SentText(lnTxtBox, lName);
		SentText(adressTxtBox, address);
		selectFromDW(countryDw,country );
		SentText(stateTxtBox, state);
		SentText(cityTxtBox, city);
		SentText(zipCodeTxtBox, zCode);
		SentText(mobileBox, mobNo);
		clickButton(createAccBtn);
		clickButton(continueBtn);

	}
	public void userLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		clickButton(logoutLink);
	}
	
}



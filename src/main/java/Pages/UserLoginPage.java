package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
	public UserLoginPage ( WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement emailTxtBox ;

	@FindBy(xpath =("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"))
	WebElement passTxtBox ;

	@FindBy (css = "button.btn.btn-default")
	WebElement signinBtn ;

	public @FindBy (linkText =  "Logout")
	WebElement logoutLink;

	public void userLogin(String email , String password) {
		SentText(emailTxtBox, email);
		SentText(passTxtBox, password);
		clickButton(signinBtn);
		clickButton(logoutLink);

	}



}

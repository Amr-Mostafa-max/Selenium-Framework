package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUSPage extends PageBase {
	public ContactUSPage (WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "input.form-control")
	WebElement nameTxtBox;

	@FindBy (xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
	WebElement emailTxtBox ;

	@FindBy (xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
	WebElement subjTxtBox ;

	@FindBy (id = "message")
	WebElement msgTxtBOX ;

	@FindBy (xpath = "//*[@id=\"contact-us-form\"]/div[5]/input")
	WebElement fileUploader ; 

	@FindBy (css = "input.btn.btn-primary.pull-left.submit_form")
	WebElement submitBtn ;

	@FindBy(css =  "div.status.alert.alert-success")
	public  WebElement successMsg;


	public void contactUS(  String name , String email ,String subject ,String message , String imgPath) {
		SentText(nameTxtBox, name);
		SentText(emailTxtBox, email);
		SentText(subjTxtBox, subject);
		SentText(msgTxtBOX, message);
		SentText(fileUploader, imgPath);
		//fileUploader.sendKeys(imgPath);
		clickButton(submitBtn);
	}

}

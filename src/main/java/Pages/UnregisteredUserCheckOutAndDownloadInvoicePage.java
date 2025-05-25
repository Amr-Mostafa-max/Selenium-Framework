package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnregisteredUserCheckOutAndDownloadInvoicePage extends PageBase {

	public UnregisteredUserCheckOutAndDownloadInvoicePage (WebDriver driver) {
		super(driver);
	}

	@FindBy (linkText = "Register / Login")
	WebElement resisterLoginLink; 

	@FindBy (css = "a.btn.btn-default.check_out")
	WebElement checkoutBtn ;

	@FindBy(linkText = "Cart")
	WebElement cartLink ;

	@FindBy(id = "address_delivery")
	WebElement addressList ;

	@FindBy (css = "textarea.form-control")
	WebElement txtArea ;

	@FindBy (linkText = "Place Order")
	WebElement placeOrderLink ;

	@FindBy(css = "input.form-control")
	WebElement cardNameField ;

	@FindBy (css = "input.form-control.card-number")
	WebElement cardNumField ;

	@FindBy (css = "input.form-control.card-cvc")
	WebElement cvvNumField ;

	@FindBy (css = "input.form-control.card-expiry-month")
	WebElement expMonthField;

	@FindBy (css = "input.form-control.card-expiry-year")
	WebElement expYearField;

	@FindBy(id = "submit")
	WebElement subAndConBtn ;

	@FindBy(css = "div.alert-success.alert")
	WebElement sucessMsg ;

	@FindBy(css = "a.btn.btn-default.check_out")
	WebElement downloadInvoiceBtn;

	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement emailTxtBox ;

	@FindBy(xpath =("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"))
	WebElement passTxtBox ;

	@FindBy (css = "button.btn.btn-default")
	WebElement signinBtn ;

	public void loginOrRegisterForGuestToCheckOut() {
		clickButton(checkoutBtn);
		clickButton(resisterLoginLink);
	}

	public void guestUserLogin(String email , String password) {
		SentText(emailTxtBox, email);
		SentText(passTxtBox, password);
		clickButton(signinBtn);
	}

	public void RegisteredOrLogedInUserCheckOutAndDownloadInvoice(String commentArea , String cardName ,
			String cardNum ,String cvvNum,String expMonth,String expYear) throws InterruptedException {
		clickButton(cartLink);
		clickButton(checkoutBtn);
		List<WebElement> elementList = addressList.findElements(By.tagName("li"));
		for (WebElement items : elementList) {
			String text = items.getText();
			System.out.println(text);
		}
		SentText(txtArea, commentArea);
		clickButton(placeOrderLink);
		SentText(cardNameField, cardName);
		SentText(cardNumField, cardNum);
		SentText(cvvNumField, cvvNum);
		SentText(expMonthField, expMonth);
		SentText(expYearField, expYear);
		clickButton(subAndConBtn);
		clickButton(downloadInvoiceBtn);
		Thread.sleep(5000);
	}
}

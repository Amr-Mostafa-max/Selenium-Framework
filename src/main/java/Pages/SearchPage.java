package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public  SearchPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "i.material-icons.card_travel")
	WebElement productLink ;
	
	@FindBy (id = "search_product")
	WebElement srcTxtBox ;
	
	@FindBy (id = "submit_search")
	WebElement submitSrcBtn;
	
	public void searchForProduct(String productName) {
		clickButton(productLink);
		SentText(srcTxtBox, productName);
		clickButton(submitSrcBtn);
	}
}

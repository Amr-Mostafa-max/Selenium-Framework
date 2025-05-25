package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCartPage extends PageBase {
	public AddProductToCartPage (WebDriver driver) {
		super(driver);

	}
	@FindBy (xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a")
	WebElement viewProductBtn ;

	@FindBy (xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	WebElement priceTxt ;

	@FindBy (id = "quantity")
	WebElement quantityBtn ;

	@FindBy (css = "button.btn.btn-default.cart")
	WebElement addCartBtn ;

	@FindBy (css = "div.modal-content")
	WebElement modelContact ;

	@FindBy (linkText = "View Cart")
	WebElement viewCartLink;

	@FindBy (xpath = "//*[@id=\"product-2\"]/td[2]/h4/a")
	public WebElement productDecsriptionLink;

	@FindBy (css = "i.material-icons.card_travel")
	WebElement productLink ;

	public void addProductToCart() {
		clickButton(productLink);
		clickButton(viewProductBtn);
		int desiredQuantity =6 ;
		for (int i = 1; i < desiredQuantity; i++) {
			quantityBtn.sendKeys(Keys.ARROW_UP);
		}
		clickButton(addCartBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(modelContact));
		clickButton(viewCartLink);
		wait.until(ExpectedConditions.visibilityOf(productDecsriptionLink));
	}


}

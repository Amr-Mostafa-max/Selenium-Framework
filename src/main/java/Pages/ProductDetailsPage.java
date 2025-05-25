package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage  extends PageBase{
	public ProductDetailsPage (WebDriver driver)
	{
		super(driver);
	}
	
	 public @FindBy (xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/h2")
		WebElement priceTxt ;
		
}

package Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SearchProductTest  extends TestBase{
	String  productName = "Winter Top";
	SearchPage src ;
	HomePage home ;
	ProductDetailsPage detailsobj ;

	@Test
	public void userCanSearchForProduct() throws InterruptedException {
		home = new HomePage(driver);
		home.openRgisterationLink();
		src = new SearchPage(driver);
		src.searchForProduct(productName);
		home.scrollPageDown();
		detailsobj = new ProductDetailsPage(driver);
		assertTrue(detailsobj.priceTxt.getText().equalsIgnoreCase("Rs. 600"));
	}
}

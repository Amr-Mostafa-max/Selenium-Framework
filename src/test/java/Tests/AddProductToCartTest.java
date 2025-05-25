package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProductToCartPage;
import Pages.HomePage;

public class AddProductToCartTest extends TestBase  {
	HomePage homeObj ;
	AddProductToCartPage proCart ;

	@Test
	public void UserCanAddProductToCart() {

		proCart = new AddProductToCartPage(driver);
		proCart.addProductToCart();
		Assert.assertTrue(proCart.productDecsriptionLink.getText().contains("Men Tshirt"));
	}
}

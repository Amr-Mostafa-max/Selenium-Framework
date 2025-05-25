package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProductToCartPage;
import Pages.UnregisteredUserCheckOutAndDownloadInvoicePage;
import Pages.UserLoginPage;

public class UnregisteredUserCheckOutAndDownloadInvoiceTest extends TestBase {

	AddProductToCartPage proCart ;
	UnregisteredUserCheckOutAndDownloadInvoicePage guest ;
	UserLoginPage login ;

	@Test 
	public void UserCanAddProductToCart() {
		proCart = new AddProductToCartPage(driver);
		proCart.addProductToCart();
		Assert.assertTrue(proCart.productDecsriptionLink.getText().contains("Men Tshirt"));
	}

	@Test  
	public void guestUserCanLoginORRegister() {
		guest = new UnregisteredUserCheckOutAndDownloadInvoicePage(driver);
		guest.loginOrRegisterForGuestToCheckOut();
		guest.guestUserLogin("amrgadoooo54@gmail.com", "amr@1234");
	}

	@Test 
	public void registeredUserCanCheckOut () throws InterruptedException {

		guest = new UnregisteredUserCheckOutAndDownloadInvoicePage(driver);
		guest.RegisteredOrLogedInUserCheckOutAndDownloadInvoice("Please I want free delivery", "Amr Gad", "20909812", "089", "02", "2029");
	}








}

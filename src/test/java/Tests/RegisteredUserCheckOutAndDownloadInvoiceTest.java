package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProductToCartPage;
import Pages.HomePage;
import Pages.RegisteredUserCheckOutAndDownloadInvoicePage;
import Pages.UserRegisterationPage;

public class RegisteredUserCheckOutAndDownloadInvoiceTest extends TestBase {

	HomePage homeObject ;
	UserRegisterationPage register ;
	AddProductToCartPage proCart ;
	RegisteredUserCheckOutAndDownloadInvoicePage  reregisUserCheckOut ;

	@Test (priority = 1 )
	public void userCanRegistersuccessfully()  {
		homeObject = new HomePage(driver);
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(driver);
		register.newUserSignup("amrali", "amrgadzzoxo50904@gmail.com");
		register.userRegisteration( "amr" , "ali" ,"amr@1234" ,"cairo" ,"Canada", "district5", "zayed", "12655" , "1090123029");
	}

	@Test (dependsOnMethods = {"userCanRegistersuccessfully"})
	public void UserCanAddProductToCart() {
		proCart = new AddProductToCartPage(driver);
		proCart.addProductToCart();
		Assert.assertTrue(proCart.productDecsriptionLink.getText().contains("Men Tshirt"));
	}

	@Test (dependsOnMethods = {"UserCanAddProductToCart"})
	public void registeredUserCanCheckOut () throws InterruptedException {

		reregisUserCheckOut = new RegisteredUserCheckOutAndDownloadInvoicePage(driver);
		reregisUserCheckOut.RegisteredUserCheckOutAndDownloadInvoice("Please I want free delivery", "Amr Gad", "20909812", "089", "02", "2029");
	}
}
package steps;

import org.testng.Assert;

import Pages.AddProductToCartPage;
import Pages.HomePage;
import Pages.RegisteredUserCheckOutAndDownloadInvoicePage;
import Pages.UserRegisterationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E2ETests extends TestBase {

	HomePage homeObj ;
	UserRegisterationPage register ;
	AddProductToCartPage product ;
	RegisteredUserCheckOutAndDownloadInvoicePage reUser ;

	@Given("the user opens the home page")
	public void the_user_opens_the_home_page() {
		homeObj = new HomePage(driver);
		homeObj.openRgisterationLink();
	}

	@When("the user clicks on register link {string}, {string}")
	public void the_user_clicks_on_register_link(String name, String email) {
		register = new UserRegisterationPage(driver);
		register.newUserSignup(name, email);
	}
	@When("enter all valid required data  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void enter_all_valid_required_data(String fName, String lName, String pass, String address, String country, String state, String city, String zCode, String mobNo) {
		register.userRegisteration(fName, lName, pass, address, country, state, city, zCode, mobNo);
	}

	@When("add product to the cart")
	public void add_product_to_the_cart() {
		product = new AddProductToCartPage(driver);
		product.addProductToCart();
		Assert.assertTrue(product.productDecsriptionLink.getText().contains("Men Tshirt"));
	}


	@Then("the user can check out and download thier invoice successfully  {string} ,  {string} ,	\"{int}\" , \"{int}\", \"{int}\", \"{int}\"")
	public void the_user_can_check_out_and_download_thier_invoice_successfully(String commentArea , String cardName ,
			Integer cardNum ,Integer cvvNum,Integer expMonth,Integer expYear) throws InterruptedException {
		reUser = new RegisteredUserCheckOutAndDownloadInvoicePage(driver);
		reUser.RegisteredUserCheckOutAndDownloadInvoice( commentArea ,  cardName ,
				String.valueOf(cardNum),
				String.valueOf(cvvNum),
				String.valueOf(expMonth),
				String.valueOf(expYear));
	}


}

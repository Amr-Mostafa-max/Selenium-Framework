package steps;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegisteration extends TestBase {

	HomePage home ;
	UserRegisterationPage registerObj ;
	UserLoginPage login ;
	String email,  password  ;
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		home = new HomePage(driver);
		home.openRgisterationLink();
	}


	@When("the user clicks on the register link {string}, {string}")
	public void the_user_clicks_on_the_register_link(String name, String email) {
		this.email = email ;
		registerObj = new UserRegisterationPage(driver);
		registerObj.newUserSignup(name, email);
	}
	@When("enters all required valid data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void enters_all_required_valid_data(String fName , String lName ,String pass, String address , 
			String country ,String state ,String city, String zCode , String mobNo) {
		this.password = pass ;
		registerObj.userRegisteration( fName, lName, pass, address, country, state, city, zCode, mobNo );
	}

	@Then("the user register the account and can log in")
	public void the_user_register_the_account_and_can_log_in() {
		registerObj.userLogout();
		login = new UserLoginPage(driver);
		login.userLogin(email, password);
	}
}

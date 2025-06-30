package Tests;

import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationParallelTesting extends TestBase2 {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;
	Faker fakeData = new Faker();
	String name = fakeData.name().name();
	String email = fakeData.internet().emailAddress();
	String fName = fakeData.name().firstName(); 
	String lName = fakeData.name().lastName(); 
	String pass = fakeData.internet().password(8,12);
	String address = fakeData.address().streetAddress() ;
	String [] allowedCountries = {"India", "United States","Canada"};
	String country = allowedCountries[new Random().nextInt(allowedCountries.length)];
	//String country = fakeData.address().country();
	String state = fakeData.address().state();
	String city = fakeData.address().city();
	String zCode = fakeData.address().zipCode();
	String mobNo = fakeData.phoneNumber().cellPhone();
	@Test (priority = 1)
	public void userCanRegistersuccessfully()  {
		homeObject = new HomePage(getDriver());
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(getDriver());
		register.newUserSignup(name , email);
		register.userRegisteration( fName , lName ,pass ,address ,country, state, city, zCode , mobNo);
		//assertTrue(register.successTxt.getText().contains("Account Created!") );
		//assertEquals(register.successTxt.getText(), "ACCOUNT CREATED!");

	}

	@Test (dependsOnMethods = {"userCanRegistersuccessfully"})
	public void userCanLogout() {
		getDriver().navigate().refresh();
		register = new UserRegisterationPage(getDriver());
		register.userLogout();
	}

	@Test (dependsOnMethods = {"userCanLogout"})
	public void userCanLoginSuccessfully() {
		homeObject =  new HomePage(getDriver());
		login = new UserLoginPage(getDriver());
		homeObject.openRgisterationLink();
		login.userLogin(email, pass);
	}
}

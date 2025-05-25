package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;
import data.LoadProperties;

public class UserRegisterationTestWithDDTAndPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;
	String userName = LoadProperties.userData.getProperty("name");
	String email = LoadProperties.userData.getProperty("email");
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("lastname");
	String pass = LoadProperties.userData.getProperty("password");
	String userAdress = LoadProperties.userData.getProperty("address");
	String userCountry = LoadProperties.userData.getProperty("country");
	String userState = LoadProperties.userData.getProperty("state");
	String userCity = LoadProperties.userData.getProperty("city");
	String zipCode = LoadProperties.userData.getProperty("zCode");
	String phone = LoadProperties.userData.getProperty("mobNo");



	@Test (priority = 1)
	public void userCanRegistersuccessfully()  {
		homeObject = new HomePage(driver);
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(driver);
		register.newUserSignup(userName ,email);
		register.userRegisteration( fn , ln ,pass ,userAdress ,userCountry, userState, userCity , zipCode , phone);
		//assertTrue(register.successTxt.getText().contains("Account Created!") );
		//		assertEquals(register.successTxt.getText(), "ACCOUNT CREATED!");

	}

	@Test (dependsOnMethods = {"userCanRegistersuccessfully"})
	public void userCanLogout() {
		driver.navigate().refresh();
		register = new UserRegisterationPage(driver);
		register.userLogout();
	}

	@Test (dependsOnMethods = {"userCanLogout"})
	public void userCanLoginSuccessfully() {
		homeObject =  new HomePage(driver);
		login = new UserLoginPage(driver);
		homeObject.openRgisterationLink();
		login.userLogin("amrgad5000@gmail.com", "amr@1234");
	}

}

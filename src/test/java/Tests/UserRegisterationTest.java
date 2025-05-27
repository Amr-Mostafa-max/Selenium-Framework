package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;

	@Test (priority = 1)
	public void userCanRegistersuccessfully()  {
		homeObject = new HomePage(driver);
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(driver);
		register.newUserSignup("amrali", "srt8495@gmail.com");
		register.userRegisteration( "amr" , "ali" ,"amr@1234" ,"cairo" ,"Canada", "district5", "zayed", "12655" , "1090123029");
		//assertTrue(register.successTxt.getText().contains("Account Created!") );
       //assertEquals(register.successTxt.getText(), "ACCOUNT CREATED!");
		
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
		login.userLogin("srt8495@gmail.com", "amr@1234");
	}

}

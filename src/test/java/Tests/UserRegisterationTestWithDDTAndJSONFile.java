package Tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;
import data.JsonDataReader;
import data.Users;

public class UserRegisterationTestWithDDTAndJSONFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;
	JsonDataReader jsonReader ;
	Users lastUser;

	@BeforeClass
	public void setData () throws IOException, ParseException {
		jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
	}

	@Test (priority = 1)
	public void userCanRegistersuccessfully()  {
		for (Users use : jsonReader.users) {

			System.out.println("Registering user: " + use.email);

			homeObject = new HomePage(driver);
			homeObject.openRgisterationLink();
			register = new UserRegisterationPage(driver);
			register.newUserSignup(use.name ,use.email);
			register.userRegisteration(use.fName ,use.lName,use.pass ,use.address,
					use.country , use.state ,use.city ,use.zCode ,use.mobNo );
			lastUser = use ;
			register.userLogout();
			login = new UserLoginPage(driver);
			login.userLogin(lastUser.email, lastUser.pass);

			//assertTrue(register.successTxt.getText().contains("Account Created!") );
			//assertEquals(register.successTxt.getText(), "ACCOUNT CREATED!");
		}
	}

	//	@Test (dependsOnMethods = {"userCanRegistersuccessfully"})
	//	public void userCanLogout() {
	//		register = new UserRegisterationPage(driver);
	//		register.userLogout();
	//	}
	//
	//	@Test (dependsOnMethods = {"userCanLogout"})
	//	public void userCanLoginSuccessfully() {
	//		homeObject =  new HomePage(driver);
	//		login = new UserLoginPage(driver);
	//		homeObject.openRgisterationLink();
	//		login.userLogin(lastUser.email, lastUser.pass);
	//	}

}

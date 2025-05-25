package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;
import data.ExcellReader;

public class UserRegisterationTestWithDDTAndExcelFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;
	
	@DataProvider (name = "excellData")
	public Object[][] getDataFromExcelSheet () throws IOException{
		ExcellReader reader =  new ExcellReader();
		return reader.getExcelData();

	}

	@Test (priority = 1 , dataProvider = "excellData")
	public void userCanRegistersuccessfully(String name,String email, String fNAme , String lName ,String pass, String address , 
			String country ,String state ,String city, String zCode , String mobNo )  {
		homeObject = new HomePage(driver);
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(driver);
		register.newUserSignup(name ,  email);
		register.userRegisteration( fNAme ,lName,pass ,address ,country ,state ,city ,zCode ,mobNo);
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

package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;

	@DataProvider (name = "testdata")
	public static Object [][] userData(){

		return new Object [][] {
			{"amir","amrgad7001@gmail.com","Amr" ," ali", "amr@6789","cairo","Canada", "district 4" ,"giza","12309" ,"1090394812"},
			{"Ahmed" ,"amrgad001@gmail.com", "sayed", "ali", "ah@9000","asyut","Canada", "district 90" ,"haram","10909" ,"109000000"}
		};
	} 	

	@Test (priority = 1 , dataProvider = "testdata")
	public void userCanRegistersuccessfully(String name,String email, String fNAme , String lName ,String pass, String address , 
			String country ,String state ,String city, String zCode , String mobNo ) {
		homeObject = new HomePage(driver);
		homeObject.openRgisterationLink();
		register = new UserRegisterationPage(driver);
		register.newUserSignup(name ,  email);
		register.userRegisteration( fNAme ,lName,pass ,address ,country ,state ,city ,zCode ,mobNo );
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

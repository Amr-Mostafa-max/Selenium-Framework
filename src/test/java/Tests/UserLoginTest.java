package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;

public class UserLoginTest extends TestBase  {

	HomePage homeObject;
	UserLoginPage login ;
	
	@Test
	public void userCanLoginSuccessfully() {
		homeObject =  new HomePage(driver);
		login = new UserLoginPage(driver);
		homeObject.openRgisterationLink();
		login.userLogin("amrgado67o54@gmail.com", "amr@1234");
//		assertTrue(login.logoutLink.isDisplayed());
	}
}

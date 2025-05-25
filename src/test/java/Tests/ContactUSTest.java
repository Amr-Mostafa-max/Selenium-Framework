package Tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import Pages.ContactUSPage;
import Pages.HomePage;

public class ContactUSTest extends TestBase {

	HomePage home ;
	ContactUSPage contact ;
	String name = "Amr Ali" ;
	String email = "amr55@gmail.com";
	String subject = "my order" ;
	String msg = "I want to know about my orders";
	String imageName =  "download1.jpg";
	String imgPath = System.getProperty("user.dir")+ "/Uploads/" + imageName;


	@Test
	public void userCanUseContactUs()   {
		home = new HomePage(driver);
		contact = new ContactUSPage(driver);
		home.openContactUsLink();
		contact.contactUS(name, email, subject, msg , imgPath);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		home.scrollPageUp();
		assertTrue(contact.successMsg.getText().contains("Success! Your details have been submitted successfully."));
		System.out.println(contact.successMsg.getText());


	}
}

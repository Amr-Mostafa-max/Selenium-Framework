package Tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndCSVFile extends TestBase {

	HomePage homeObject;
	UserRegisterationPage register;
	UserLoginPage login;
	CSVReader reader ;
	String	lastUsedEmail  ;
	String	lastUsedPassword ;
	
	@Test (priority = 1)
	public void userCanRegistersuccessfully() throws CsvValidationException, IOException  {

		String csvFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userdata.csv";
		reader = new CSVReader(new FileReader(csvFile));
		String [] csvCell  ;

		// loop until last value in CSV file
		while ((csvCell = reader.readNext()) != null) {
			if (csvCell.length >= 11) {


				String Name = csvCell [0];
				String email = csvCell [1];
				String fNAme = csvCell [2];
				String lName = csvCell [3];
				String pass= csvCell [4];
				String address = csvCell [5];
				String country= csvCell [6];
				String state = csvCell [7];
				String city= csvCell [8];
				String zCode = csvCell [9];
				String mobNo= csvCell [10];
				lastUsedEmail = email;
				lastUsedPassword = pass;
				

				homeObject = new HomePage(driver);
				homeObject.openRgisterationLink();
				register = new UserRegisterationPage(driver);
				register.newUserSignup(Name, email);
				register.userRegisteration( fNAme , lName ,pass ,address ,country, state, city, zCode , mobNo);
				//assertTrue(register.successTxt.getText().contains("Account Created!") );
				//assertEquals(register.successTxt.getText(), "ACCOUNT CREATED!");

			}
			else {
				System.out.println("Invalid CSV row with insufficient columns");
			}
		}
	}

	@Test (dependsOnMethods = {"userCanRegistersuccessfully"})
	public void userCanLogout() {
		register = new UserRegisterationPage(driver);
		register.userLogout();
	}

	@Test (dependsOnMethods = {"userCanLogout"})
	public void userCanLoginSuccessfully() {
		homeObject =  new HomePage(driver);
		login = new UserLoginPage(driver);
		homeObject.openRgisterationLink();
		login.userLogin(lastUsedEmail, lastUsedPassword);
	}

}

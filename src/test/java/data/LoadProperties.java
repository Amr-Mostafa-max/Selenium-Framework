package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	// load the properties file from the folder
	public static Properties userData = 
			loadProperties(System.getProperty("user.dir") +"\\src\\main\\java\\properites\\userdata.properties");

	private static Properties loadProperties(String path) {

		Properties pro =new Properties();
		//stream to read the file 
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println(" the error" + e.getMessage());
		} catch (IOException e) {
			System.out.println(" the error" + e.getMessage());

		}
		return pro;

	}




}

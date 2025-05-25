package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public List<Users> users = new ArrayList<>();

	public void jsonReader() throws IOException, ParseException {

		String  filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.json";
		File file = new File(filePath);
		FileReader reader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray)parser.parse(reader);

		for (Object jsonObj : jArray) {

			JSONObject person = (JSONObject) jsonObj ;
			Users user = new Users();

			user.name = (String) person.get("name");
			System.out.println(user.name);
			user.email =(String) person.get("email");
			System.out.println(user.email);
			user.fName =(String) person.get("fName");
			System.out.println(user.fName);
			user.lName = (String) person.get("lName");
			System.out.println(user.lName);
			user.pass = (String) person.get("pass");
			System.out.println(user.pass);
			user.address = (String) person.get("address");
			System.out.println(user.address);
			user.country = (String) person.get("country");
			System.out.println(user.country);
			user.state= (String) person.get("state");
			System.out.println(user.state);
			user.city= (String) person.get("city");
			System.out.println(user.city);
			user.zCode= (String) person.get("zCode");
			System.out.println(user.zCode);
			user.mobNo = (String) person.get("mobNo");
			System.out.println(user.mobNo);

			users.add(user);
		}
	}
}

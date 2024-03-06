package jdbc;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FetchDataFromJsonFile {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fp = new FileReader(".\\src\\test\\resources\\common.json");
		JSONParser parser = new JSONParser();
		Object parse = parser.parse(fp);
		JSONObject obj = (JSONObject)parse;
		System.out.println(obj.get("browser"));
		System.out.println(obj.get("url"));
		System.out.println(obj.get("username"));
		System.out.println(obj.get("password"));
		
		
		
	}

}

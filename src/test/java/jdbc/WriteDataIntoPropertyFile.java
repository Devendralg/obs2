package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class WriteDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.setProperty("url", "google");
		p.setProperty("url", "google");
		p.setProperty("url", "google");
		p.setProperty("url", "google");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\commonData.properties");
		p.store(fout, "Data");
	}

}

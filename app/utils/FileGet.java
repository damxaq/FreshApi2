package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileGet {

	public static String getApiKey() {
		String ApiKey = "ApiKey";
		return readProperty(ApiKey);
	}

	public static String getApiSign() {
		String ApiSign = "ApiSign";
		return readProperty(ApiSign);
	}
	
	public static String getApiList() {
		String ApiList = "ApiList";
		return readProperty(ApiList);
	}
	
	

	public static String readProperty(String property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("conf/Api.txt");
			prop.load(input);
			return prop.getProperty(property);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}



}

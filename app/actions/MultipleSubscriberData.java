package actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import hash.HashGenerator;
import play.mvc.Controller;
import utils.ByteReader;
import utils.FileGet;
public class MultipleSubscriberData{
	
	public static String[] EmailList={
			"email1@info-baza.ayz.pl", "email2@info-baza.ayz.pl", "email3@info-baza.ayz.pl",
			"email4@info-baza.ayz.pl", "email5@info-baza.ayz.pl", "email6@info-baza.ayz.pl",
			"email7@info-baza.ayz.pl", "email8@info-baza.ayz.pl", "email9@info-baza.ayz.pl",
			};
	
	public static void readMultipleSubscriberData() throws IOException{
		for(String email:EmailList)
			readSinlgeSubscriberData(email);
	}
	
	private static void readSinlgeSubscriberData(String email) throws IOException {

		String GET_data = "/rest/subscriber/get/";
		String Address = "https://api.freshmail.com";
		String Content = "application/json";
		
		String ApiKey = FileGet.getApiKey();
		String ApiList = FileGet.getApiList();
		
		GET_data+=ApiList;
		GET_data+="/";
		GET_data+=email;
		
		Address+=GET_data;
		GET_data=ApiKey+GET_data;
		
		URL url = new URL(Address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		HashGenerator hashGenerator = new HashGenerator();
		String ApiSign = hashGenerator.createHash(GET_data);
		
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", Content);
		con.setRequestProperty("X-Rest-ApiKey", ApiKey);
		con.setRequestProperty("X-Rest-ApiSign", ApiSign);
		

		System.out.println(ByteReader.readFullyAsString(con.getInputStream(), "UTF-8"));

	}

}

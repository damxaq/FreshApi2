package actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import hash.HashGenerator;
import play.mvc.Controller;
import utils.ByteReader;
import utils.FileGet;
public class SingleSubscriberData{
	
	public static void readSinlgeSubscriberData() throws IOException {

		String GET_data = "/rest/subscriber/get/";
		String Address = "https://api.freshmail.com";
		String Content = "application/json";
		
		String ApiKey = FileGet.getApiKey();
		String ApiList = FileGet.getApiList();
		
		GET_data+=ApiList;
		GET_data+="/email1@info-baza.ayz.pl";
		
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

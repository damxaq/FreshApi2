package actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import hash.HashGenerator;
import play.mvc.Controller;
import utils.ByteReader;
import utils.FileGet;
public class SubscribersListAction{
	
	public static void readSubscribersList() throws IOException {

		String GET_data = "/rest/subscribers_list/lists";
		String Address = "https://api.freshmail.com";
		String ApiKey = FileGet.getApiKey();
		String Content = "application/json";
		
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

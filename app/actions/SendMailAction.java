package actions;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hash.HashGenerator;
import models.Email;
import utils.ByteReader;
import utils.FileGet;

public class SendMailAction {
	
	public static void sendEmail() throws IOException{
		
		String GET_data = "/rest/mail";
		String Address = "https://api.freshmail.com";
		String Content = "application/json";
		
		Email email = new Email("email1@info-baza.ayz.pl","subject","content of email");
		Gson gson = new GsonBuilder().create();
		
		String JSON_data = gson.toJson(email);
		
		String ApiKey = FileGet.getApiKey();
		
		
		Address+=GET_data;
		GET_data=ApiKey+GET_data;
		GET_data+=JSON_data;
		
		URL url = new URL(Address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		HashGenerator hashGenerator = new HashGenerator();
		String ApiSign = hashGenerator.createHash(GET_data);
		System.out.println(ApiSign);
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", Content);
		con.setRequestProperty("X-Rest-ApiKey", ApiKey);
		con.setRequestProperty("X-Rest-ApiSign", ApiSign);
		con.setRequestProperty("JSON_data", JSON_data);
		
		
		byte[] JSON_dataInBytes = JSON_data.getBytes("UTF-8");
		OutputStream os = con.getOutputStream();
		os.write( JSON_dataInBytes );    
		os.close();
		

		System.out.println(con.getResponseMessage());
		con.disconnect();
		
	}

}

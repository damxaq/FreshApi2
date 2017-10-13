package actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import utils.ByteReader;

public class Ping {

	public static void readPing() throws IOException {

		URL url = new URL("https://api.freshmail.com/rest/ping");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("X-Rest-ApiKey", "1912cf4c2a8b21303a3b32f65d3b3496");
		con.setRequestProperty("X-Rest-ApiSign", "6dca264c0b5195af3179fcde4a67ae0cc66cabb0");

		System.out.println(ByteReader.readFullyAsString(con.getInputStream(), "UTF-8"));

	}
	
}

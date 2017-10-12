package controllers;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.User;
import pl.com.softproject.utils.freshmail.client.FreshMailClient;
import pl.com.softproject.utils.freshmail.config.Configuration;
import pl.com.softproject.utils.freshmail.config.FreshMailConfiguration;
import pl.com.softproject.utils.freshmail.hash.HashGenerator;
import pl.com.softproject.utils.freshmail.hash.JsonHashGenerator;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Scope.Session;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	@Before
	static void setConnectedUser() throws IOException {

		URL url = new URL("https://api.freshmail.com/rest/mail");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("X-Rest-ApiKey", "1912cf4c2a8b21303a3b32f65d3b3496");
		con.setRequestProperty("X-Rest-ApiSign", "5ff57995a53a433878750627966a325d78ebf6e6");

		System.out.println(readFullyAsString(con.getInputStream(), "UTF-8"));

		/*
		 * URL url = new
		 * URL("https://api.freshmail.com/rest/subscribers_list/lists");
		 * HttpURLConnection con = (HttpURLConnection)url.openConnection();
		 * con.setRequestMethod("GET");
		 * 
		 * con.setRequestProperty("Content-Type", "application/json");
		 * con.setRequestProperty("X-Rest-ApiKey",
		 * "1912cf4c2a8b21303a3b32f65d3b3496");
		 * con.setRequestProperty("X-Rest-ApiSign",
		 * "707f36f31be89146842598b68e2580e5363c1f35");
		 * 
		 * String contentType = con.getHeaderField("Content-Type");
		 * System.out.println(contentType);
		 * 
		 * Configuration configuration = new Configuration() {
		 * 
		 * public String getUrl() { String Url = getUrl(); return Url; }
		 * 
		 * public String getHttpHeaderForApiSign() { String HttpHeaderForApiSign
		 * = getHttpHeaderForApiSign(); return HttpHeaderForApiSign; }
		 * 
		 * public String getHttpHeaderForApiKey() { String HttpHeaderForApiKey =
		 * getHttpHeaderForApiKey(); return HttpHeaderForApiKey; }
		 * 
		 * public String getApiSecret() { String ApiSecret = getApiSecret();
		 * return ApiSecret; }
		 * 
		 * public String getApiKey() { String ApiKey = getApiKey(); return
		 * ApiKey; } };
		 * 
		 * HashGenerator hashGenerator = new HashGenerator() {
		 * 
		 * public String getContentType() { return null; }
		 * 
		 * public String generate(String apiKey, String getData, String
		 * postData, String apiSecret) { return null; } };
		 * 
		 * FreshMailClient client = new FreshMailClient(configuration,
		 * hashGenerator);
		 */

		/*
		 * Configuration configuration;
		 * 
		 * HashGenerator hashGenerator = new JsonHashGenerator();
		 * 
		 * FreshMailClient freshMailClient;
		 * 
		 * 
		 * class Configuration {
		 * 
		 * private static final String URL = "https://api.freshmail.com/";
		 * private static final String API_KEY =
		 * "1912cf4c2a8b21303a3b32f65d3b3496"; private static final String
		 * API_SECRET = "045243266e31f8ec7204ff44fb96f1a897fc8487"; private
		 * static final String HTTP_HEADER_API_KEY = "X-Rest-ApiKey"; private
		 * static final String HTTP_HEADER_API_SIGN = "X-Rest-ApiSign"; }
		 * 
		 * configuration = new FreshMailConfiguration(Configuration.URL,
		 * Configuration.API_KEY, Configuration.API_SECRET,
		 * Configuration.HTTP_HEADER_API_KEY,
		 * Configuration.HTTP_HEADER_API_SIGN);
		 * 
		 * freshMailClient = new FreshMailClient(configuration, hashGenerator);
		 * 
		 * 
		 * freshMailClient.ping();
		 */

		if (Security.isConnected()) {
			User user = User.find("byLogin", Security.connected()).first();
			renderArgs.put("user", user.login);
		}
	}

	public static void index() {
		String user = Security.connected();

		render(user);
	}

	public static String readFullyAsString(InputStream inputStream, String encoding) throws IOException {
		return readFully(inputStream).toString(encoding);
	}

	public static ByteArrayOutputStream readFully(InputStream inputStream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(buffer)) != -1) {
			baos.write(buffer, 0, length);
		}
		return baos;
	}

}

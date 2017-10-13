package controllers;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.HttpGet;

import actions.SubscribersListAction;
import models.User;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.Scope.Session;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller{

	@Before
	static void setConnectedUser() throws IOException {

		Request request = Request.current();
		String name = request.params.get("name");
	    String password = request.params.get("password");

	    System.out.println(name + " " + password);
		if (Security.isConnected()==false) {
	    System.out.println("sprawdzm2");
			User user = new User(name, password);
			if(name!=null)
			Security.authenticate(name, password);
	
			renderArgs.put("user", user.login);
		}
	}

	public static void index() {
		Request request = Request.current();
		String name = request.params.get("name");
	    String password = request.params.get("password");

	    System.out.println(name + " " + password);
	    System.out.println("Security " + Security.isConnected());
		String user = Security.connected();
		render(user);
	}
	

}

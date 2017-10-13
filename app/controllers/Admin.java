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

import actions.SubscribersList;
import models.User;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Scope.Session;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	@Before
	static void setConnectedUser() throws IOException {

		SubscribersList.readSubscribersList();
		
		if (Security.isConnected()) {
			User user = User.find("byLogin", Security.connected()).first();
			renderArgs.put("user", user.login);
		}
	}

	public static void index() {
		String user = Security.connected();

		render(user);
	}


}

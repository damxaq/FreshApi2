package controllers;

import models.User;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import controllers.Application;
import play.Play;
import play.mvc.Scope.Session;

public class Security extends Secure.Security {

	static boolean authenticate(String username, String password){
		
		Boolean connect = User.connect(username, password);
		if (connect==true) {
			session.put("name", username);
			Security.connected();
			Security.onAuthenticated();
			}
		return connect==true;
	}

	static void onDisconnected() {
	
	    Application.index();
	}
	
	static void onAuthenticated() {
	    Application.index();
	}
	
}

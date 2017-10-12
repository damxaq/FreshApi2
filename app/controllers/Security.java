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
		User connect = User.connect(username, password);
		return  connect!= null;
	}

	static void onDisconnected() {
	
	    Application.index();
	}
	
	static void onAuthenticated() {
	    Admin.index();
	}
	
}

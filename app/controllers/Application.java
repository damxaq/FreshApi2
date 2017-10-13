package controllers;

import play.Play;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Http.Response;

import java.util.HashMap;
import java.util.Map;


public class Application extends Controller {


	public static void index() {
		System.out.println("Session " + session.get("name"));
		render();
	}

}
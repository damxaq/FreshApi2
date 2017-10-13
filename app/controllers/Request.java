package controllers;

import java.io.IOException;

import actions.MultipleSubscriberData;
import actions.Ping;
import actions.SingleSubscriberData;
import actions.SubscribersList;
import play.mvc.Controller;

public class Request extends Controller {
	
	public static void subList() throws IOException{
		SubscribersList.readSubscribersList();
		render();
	}
	
	public static void ping() throws IOException{
		Ping.readPing();
		render();
	}
	
	public static void singleSubData() throws IOException{
		SingleSubscriberData.readSinlgeSubscriberData();
		render();
	}
	
	public static void multiSubData() throws IOException{
		MultipleSubscriberData.readMultipleSubscriberData();
		render();
	}
	
	public static void index(){
		render();
	}

}

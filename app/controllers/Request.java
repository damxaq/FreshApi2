package controllers;

import java.io.IOException;

import actions.MultipleSubscriberDataAction;
import actions.PingAction;
import actions.SendMailAction;
import actions.SingleSubscriberDataAction;
import actions.SubscribersListAction;
import play.mvc.Controller;

public class Request extends Controller {
	
	public static void subList() throws IOException{
		SubscribersListAction.readSubscribersList();
		render();
	}
	
	public static void ping() throws IOException{
		String ping = PingAction.readPing();
		
		render(ping);
	}
	
	public static void singleSubData() throws IOException{
		SingleSubscriberDataAction.readSinlgeSubscriberData();
		render();
	}
	
	public static void multiSubData() throws IOException{
		MultipleSubscriberDataAction.readMultipleSubscriberData();
		render();
	}
	
	public static void sendingEmail() throws IOException{
		SendMailAction.sendEmail();
		render();
	}
	
	public static void index(){
		render();
	}

}

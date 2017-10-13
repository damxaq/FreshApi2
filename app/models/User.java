package models;


import play.db.jpa.Model;
import utils.FileGet;


public class User extends Model{
	
	public String login;
	public String password;
	public User(String login, String password) {

		this.login = login;
		this.password = password;
	}
	
    public static boolean connect(String login, String password){
    	System.out.println("proba polaczenia: " + login + password);
    	return (FileGet.readProperty(login).equals(password));
    }

	
}

package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model{
	
	public String login;
	public String password;
	public User(String login, String password) {

		this.login = login;
		this.password = password;
	}
	
    public static User connect(String login, String password){
    	return find("byLoginAndPassword", login, password).first();
    }

	
}

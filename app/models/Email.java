package models;

public class Email {

	String subscriber;
	String subject;
	String text;
	
	
	public Email(String subscriber, String subject, String text) {
		this.subscriber = subscriber;
		this.subject = subject;
		this.text = text;
	}
	
	public String getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}

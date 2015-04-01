package models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

public class PrivateMessage extends Model{
	
	@Id
	public int id;
	
	@Required
	public String content;
	
	@ManyToOne
	public User user;
	
	public static Finder<Integer, PrivateMessage> find = new Finder<Integer, PrivateMessage>(Integer.class, PrivateMessage.class);

	public PrivateMessage(String content, User user) {
		this.content = content;
		this.user = user;
	}

	public PrivateMessage() {
		this.content = "no content";
		this.user = null;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public static PrivateMessage create(String content, User user) {
		PrivateMessage newMessage = new PrivateMessage(content, user);
		newMessage.save();
		return newMessage;
	}
	
	public static void delete(int id) {
		  find.ref(id).delete();
	}
	

}
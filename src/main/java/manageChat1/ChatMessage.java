package manageChat1;

import java.io.Serializable;
import java.util.Date;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = -7112675831284153371L;
	
	private String user;
	private Date date;
	private String text;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
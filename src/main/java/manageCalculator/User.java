package manageCalculator;

import java.util.ArrayList;

public class User {

	private String name;
	private String pass;
	private boolean logged;
	private ArrayList<String> chatMessages;
	//synchornize??

    public User(String name, String pass) {
    	this.name = name;
    	this.pass = pass;
    	this.logged = false;
    	this.chatMessages = new ArrayList<String>();
//		this.chatMessages.add("Live Chat");
    }

    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    }
    
	public ArrayList<String> getChatMessages() {
		return chatMessages;
	}

	public void setChatMessages(ArrayList<String> chatMessages) {
		this.chatMessages = chatMessages;
	}
	
	public void addMessage(String message){
		this.chatMessages.add(message);
	}
	
	public void clean(){
		logged = false;
		chatMessages.clear();
	}

	public boolean checkPass(String p) {
		return pass.equals(p); 
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

}
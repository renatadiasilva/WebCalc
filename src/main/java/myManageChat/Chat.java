package myManageChat;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import manageCalculator.User;

import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class Chat implements Serializable {

	private static final long serialVersionUID = -2100178258836575648L;
	
	@Inject
	ListUsers users;

	private User user;
	private boolean active;
	private boolean login;

	private String name;
	private String pass; 
	private String repeatPass;
	
	private String message;
	private boolean error;

	public Chat() {
		active = false;
		login = true;
		name = "";
		pass = "";
		repeatPass = "";
		message = "";
		error = false;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
		reset();
	}

	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return this.pass;
	}

	public void setRepeatPass(String repeatPass) {
		this.repeatPass = repeatPass;
	}

	public String getRepeatPass() {
		return this.repeatPass;
	}

	public void signUp() {
		if (!name.isEmpty() ) {
			if (!pass.isEmpty() ) {
				if (pass.equals(repeatPass)) {
					user = users.newUser(name, pass);
					if (user != null) { //new user registed
						pass="";
						login = true;
						active = false;
						error = false;
					} else { // existent user
						error = true;
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This username already exists!"));
						reset();
					}
				} else { // pass not equal
					error = true;
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repeat password not equal to password!"));
					repeatPass="";
				}
				
			} else { //empty pass
				error = true;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty password!"));
				pass="";
			}
		} else { //empty name
			error = true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty username!"));
			reset();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void newUser() {
		login = false;
		error = false;
		reset();
	}
	
	public void goBack() {
		login = true;
		error = false;
		reset();
	}

	public void loginUser(){
		if(!name.isEmpty() ) {
			if(!pass.isEmpty() ) {
				user = users.findUser(name, pass);

				if (user != null) {
					error = false;
					user.setLogged(true);
				} else { //non-existent user or wrong pass
					error = true;
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong username or password!"));
				}

				active = user!=null;
			} else { //empty pass
				error = true;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty password!"));
				pass = "";
			}
		} else { //empty name
			error = true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty username!"));
			reset();
		}
	}

	public void logoutUser(){
		user.clean();
		reset();
		message="";
		login = true;
		active = false;
		error = false;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// new message added to all logged users
	public void addMessage() {
		if(!message.isEmpty()){
			error = false;
			users.addMessage(user.getName()+": "+message);
			message = "";
		} else { // empty message
			error = true;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message!"));
		}

	}
	
	public ArrayList<String> getUserChat() {
		if (user == null) {
			ArrayList<String> as = new ArrayList<String>(1);
			as.add("No chat messages yet");
			return as;
		} else return user.getChatMessages();
	}

	public void refresh() {
		active = true;		
	}


	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public void reset() {
		name = ""; 
		pass = ""; 
		repeatPass = "";
	}
	
}
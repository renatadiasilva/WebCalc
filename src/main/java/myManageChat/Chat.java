package myManageChat;

import javax.enterprise.context.SessionScoped;
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
	private int errorType;

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
		if(!pass.isEmpty()&&pass.equals(repeatPass)){
			if(!name.isEmpty()) {
				user = users.newUser(name, pass);
				if (user != null) {
//					user.setLogged(true);
				}
				else; //erro - já existe!!
			} // else aviso name n preenchido!!

			reset();
			login = true;
			active = false;
		}
		//else alerta pass mal repetida
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void loginUser(){
		user = users.findUser(name, pass);
		
		if (user != null) {
			user.setLogged(true);
		} else { // non existent user
			error = true;
			errorType = 1;
			errorMessage(errorType);
			reset();
		}
		
		active = user!=null;
	}

	public void logoutUser(){
		user.clean();
		reset();
		login = true;
		active = false;
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
			users.addMessage(user.getName()+": "+message);
			this.message = "";
		} else; // erro
	}
	
	public ArrayList<String> getUserChat() {
		if (user == null) {
			ArrayList<String> as = new ArrayList<String>(1);
			as.add("No chat messages yet");
			return as;
		} else return user.getChatMessages();
	}

	//Refresh - Vai confirmar o estado activo do utiizador e vai retirar utilizadores inactivos
	public void refresh() {
//		if (!user.isLogged()) {
//			user.clean();
//			user = null;
//			reset();
//			login = true;
//			active = false;
//		} else 
		active = true;		
	}
	
	public void errorMessage(int i) {
		switch (i) {
		case 1: message = "Erro 1!!"; break;
		}
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public void reset() {
		name = ""; 
		pass = ""; 
		repeatPass = "";
	}
	
}
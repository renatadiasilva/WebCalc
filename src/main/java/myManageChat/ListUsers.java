package myManageChat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import manageCalculator.User;

@Named
@ApplicationScoped
public class ListUsers {
	
	
	private final List<User> users;

	public ListUsers() {
		users = Collections.synchronizedList(new LinkedList<User>());
		
		users.add(new User("renata","passR")); 
		users.add(new User("jack","passJ")); 
		users.add(new User("marisa","passM")); 
		users.add(new User("gilnei","passG")); 
		users.add(new User("eduarda","passE")); 
		users.add(new User("lucas","passL")); 		
	}

	// boolean?
	public User findUser(String name, String pass) {
		for (User u: users) {
			if (u.getName().equals(name)) {
				if (u.checkPass(pass)) {
					return u;
				} // verificar erros!
			}
		}
		return null;
	}
	
	// boolean?
	public User newUser(String name, String pass) {
		for(User u:users) {
			if (u.getName().equals(name)) {
				return null; //já existe!!! deixar??
			}
		}
		//novo user
		User newU = new User(name,pass);
		users.add(newU);
		return newU;
	}
	
	public void addMessage(String message) {
		for(User u : users){
			if (u.isLogged()) u.addMessage(message);
		}

	}
	
}
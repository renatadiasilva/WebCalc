package manageCalculator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class User implements Serializable {

	private static final long serialVersionUID = -6768869063601481932L;
	private String name;
	private String pass;

    public User() {}

    public String getName() {
    	return name;
    }

    public void setName(String user_name) {
    	name = user_name;
    }
    
    public String getClear() {
    	name = "";
    	return name;
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
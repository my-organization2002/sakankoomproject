package mysakanclasses;

public class Administrator  {
	private String username;
	private String password;
public Administrator(String username, String password) {
		this.username=username;
		this.password=password;
	}


public Administrator() {
}


private boolean loggedIn;



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public boolean isLoggedIn() {
	return loggedIn;
}

public void setLoggedIn(boolean loggedIn) {
	this.loggedIn = loggedIn;
}


	

}

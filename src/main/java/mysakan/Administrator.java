package mysakan;

public class Administrator  {
	private String username;
	private String password;
public Administrator(String username, String password) {
		this.username=username;
		this.password=password;
		// TODO Auto-generated constructor stub
	}


public Administrator() {
	// TODO Auto-generated constructor stub
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

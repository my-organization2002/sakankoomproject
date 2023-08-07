package mysakan;
import mydbs.*;
public class MyApp {
	private String username;
	private String password;
//	public boolean flag_login;
//	public Object pass="12345";
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
	public MyApp(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public MyApp() {
		super();
	}
	public static String login(String username2, String password2) {
		// TODO Auto-generated method stub
		if(AdministratorsDB.containsKey(username2, password2)) return "ADMIN";
		else if(OwnersDB.containsKey(username2, password2))return "OWNER";
		else if(TenantsDB.containsKey(username2, password2))return "TENANT";
		else return "N/F";
		
	}
	
	
	

}

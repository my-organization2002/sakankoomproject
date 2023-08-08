package mysakan;
public class tenants  {
	private String name;
	private String email;
	private String phoneNumber;
	private boolean loggedIn;
	private int age;
	private String username;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public tenants(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.loggedIn=false;
	}
	
	public tenants(String name, String email, String phoneNumber, boolean loggedIn, int age) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.loggedIn = loggedIn;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public tenants(String username,String password) {
		this.username=username;
		this.password=password;
		this.loggedIn=false;
	}
	public tenants() {
	}
	public void setLoggedIn(boolean b) {
		this.loggedIn=b;
		
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
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
	
	
	
}

package mysakan;
public class tenants {
	private String name;
	private String email;
	private String phoneNumber;
	private boolean loggedIn;
	private int age;
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
	public tenants() {
		// TODO Auto-generated constructor stub
		this.loggedIn=false;
	}
	public void setLoggedIn(boolean b) {
		// TODO Auto-generated method stub
		this.loggedIn=b;
		
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	
}

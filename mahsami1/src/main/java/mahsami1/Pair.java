package mahsami1;

public class Pair {
	 private String name;
	    private String password ;
	    private String type;

	    public Pair (String name, String password,String type) {
	        this.name = name;
	        this.password  = password;
	        this.type=type;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getpassword() {
	        return password;
	    }
	    
	    public String gettype() {
	        return type;
	    }

}

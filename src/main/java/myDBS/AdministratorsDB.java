package myDBS;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mysakan.Administrator;
import mysakan.Reservation;

public class AdministratorsDB {
    private static final Logger LOGGER = Logger.getLogger(AdministratorsDB.class.getName());
    private static final List<Administrator> administratorsList = new ArrayList();

    private AdministratorsDB() {
        throw new IllegalStateException("Utility class");
    }

    static {
        // Create some sample administrators and add them to the list
        Administrator admin1 = new Administrator("admin1", "password1");
        Administrator admin2 = new Administrator("admin2", "password2");

        administratorsList.add(admin1);
        administratorsList.add(admin2);
    }

    public static List<Administrator> getAdministrators() {
        return administratorsList;
    }

    public static void addAdministrator(Administrator administrator) {
        administratorsList.add(administrator);
    }
    public static boolean containsKey(String username,String password) {
		// TODO Auto-generated method stub
		for(Administrator admin:administratorsList)
		{
			
			if(admin.getUsername().equals(username)&&admin.getPassword().equals(password)) 
			{
				return true;
			}
			
		}
		return false;
	}

	public static Administrator getAdmin(String username, String password) {
		// TODO Auto-generated method stub
		for(Administrator admin:administratorsList)
		{
			
			if(admin.getUsername().equals(username)&&admin.getPassword().equals(password)) 
			{
				return admin;
			}
			
		}
		return null;
	}

    // Add other methods as needed to interact with the administrators list
}

package myDBS;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mysakan.*;

public class OwnersDB {
    private static final Logger LOGGER = Logger.getLogger(OwnersDB.class.getName());
    private static final List<owner> ownersList = new ArrayList();

    private OwnersDB() {
        throw new IllegalStateException("Utility class");
    }

    static {
        // Create some sample owners and add them to the list
    	owner owner1 = new owner();
    	owner1.setUsername("John");
    	owner1.setPassword("1234");
    	owner owner2 = new owner();
    	owner2.setUsername("Alice");
    	owner2.setPassword("0000");

        ownersList.add(owner1);
        ownersList.add(owner2);
    }

    public static List<owner> getOwners() {
        return ownersList;
    }

    public static void addOwner(owner owner) {
        ownersList.add(owner);
    }
    public static boolean containsKey(String username,String password) {
		// TODO Auto-generated method stub
		for(owner ownerr:ownersList)
		{
			
			if(ownerr.getUsername().equals(username)&&ownerr.getPassword().equals(password)) 
			{
				return true;
			}
			
		}
		return false;
	}

	public static owner getOwner(String username, String password) {
		// TODO Auto-generated method stub
		for(owner ownerr:ownersList)
		{
			
			if(ownerr.getUsername().equals(username)&&ownerr.getPassword().equals(password)) 
			{
				return ownerr;
			}
			
		}
		return null;
	}

    // Add other methods as needed to interact with the owners list
}

package mydbs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mysakan.Owner;

public class OwnersDB {
    private static final Logger LOGGER = Logger.getLogger(OwnersDB.class.getName());
    private static final List<Owner> ownersList = new ArrayList();

    private OwnersDB() {
        throw new IllegalStateException("Utility class");
    }

    static {
        // Create some sample owners and add them to the list
    	Owner owner1 = new Owner();
    	owner1.setUsername("John");
    	owner1.setPassword("1234");
    	Owner owner2 = new Owner();
    	owner2.setUsername("Alice");
    	owner2.setPassword("0000");

        ownersList.add(owner1);
        ownersList.add(owner2);
    }

    public static List<Owner> getOwners() {
        return ownersList;
    }

    public static void addOwner(Owner owner) {
        ownersList.add(owner);
    }
    public static boolean containsKey(String username,String password) {
		for(Owner ownerr:ownersList)
		{
			
			if(ownerr.getUsername().equals(username)&&ownerr.getPassword().equals(password)) 
			{
				return true;
			}
			
		}
		return false;
	}

	public static Owner getOwner(String username, String password) {
		for(Owner ownerr:ownersList)
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

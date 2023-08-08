package mydbs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mysakan.Tenants;

public class TenantsDB {
    private static final Logger LOGGER = Logger.getLogger(TenantsDB.class.getName());
    private static final List<Tenants> tenantsList = new ArrayList();

    private TenantsDB() {
        throw new IllegalStateException("Utility class");
    }

    static {
        // Create some sample tenants and add them to the list
    	Tenants tenant1 = new Tenants("Omar", "1234");
    	Tenants tenant2 = new Tenants("Ali", "4444");

        tenantsList.add(tenant1);
        tenantsList.add(tenant2);
    }

    public static List<Tenants> getTenants() {
        return tenantsList;
    }

    public static void addTenant(Tenants tenant) {
        tenantsList.add(tenant);
    }
    public static boolean containsKey(String username,String password) {
		for(Tenants tenant:tenantsList)
		{
			
			if(tenant.getUsername().equals(username)&&tenant.getPassword().equals(password)) 
			{
				return true;
			}
			
		}
		return false;
	}

	public static Tenants getTenant(String username, String password) {
		for(Tenants tenant:tenantsList)
		{
			
			if(tenant.getUsername().equals(username)&&tenant.getPassword().equals(password)) 
			{
				return tenant;
			}
			
		}
		return null;
	}

    // Add other methods as needed to interact with the tenants list
}

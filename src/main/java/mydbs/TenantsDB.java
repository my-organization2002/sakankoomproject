package mydbs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mysakan.tenants;

public class TenantsDB {
    private static final Logger LOGGER = Logger.getLogger(TenantsDB.class.getName());
    private static final List<tenants> tenantsList = new ArrayList();

    private TenantsDB() {
        throw new IllegalStateException("Utility class");
    }

    static {
        // Create some sample tenants and add them to the list
    	tenants tenant1 = new tenants("Omar", "1234");
    	tenants tenant2 = new tenants("Ali", "4444");

        tenantsList.add(tenant1);
        tenantsList.add(tenant2);
    }

    public static List<tenants> getTenants() {
        return tenantsList;
    }

    public static void addTenant(tenants tenant) {
        tenantsList.add(tenant);
    }
    public static boolean containsKey(String username,String password) {
		for(tenants tenant:tenantsList)
		{
			
			if(tenant.getUsername().equals(username)&&tenant.getPassword().equals(password)) 
			{
				return true;
			}
			
		}
		return false;
	}

	public static tenants getTenant(String username, String password) {
		for(tenants tenant:tenantsList)
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

package other;
import mysakan.*;
import myDBS.*;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyApp userApp = new MyApp();
        boolean running_logging = true;
        boolean running_logged = false;
        String username, password;
        User loggedInUser = null;
        int choice;
        while (running_logging) {
            System.out.println("Admin/tenant/owner dashboard");
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();
            String loggedIn = MyApp.login(username, password);
            if(loggedIn.equals("ADMIN")) {
            	System.out.println("ADMIN LOGIN");
            	Administrator adminUser=AdministratorsDB.getAdmin(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showSystemAdminDashboard( adminUser);
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			break;
            		case 2:
            			break;
            		case 3:
            			break;
            		case 4:
            			break;
            		default: running_logged=false;
            			break;
            		} //case
            	}
            }
            else if(loggedIn.equals("OWNER")) {
            	System.out.println("OWNER LOGIN");
            	owner ownerUser=OwnersDB.getOwner(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showHousingOwnerDashboard( ownerUser);
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			break;
            		case 2:
            			break;
            		case 3:
            			break;
            		case 4:
            			break;
            		default: running_logged=false;
            			break;
            		} //case
            	}
            }
            else if(loggedIn.equals("TENANT")) {
            	System.out.println("TENANT LOGIN");
            	tenants tenantsUser=TenantsDB.getTenant(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showTenantDashboard( tenantsUser);
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			break;
            		case 2:
            			break;
            		case 3:
            			break;
            		case 4:
            			break;
            		default: running_logged=false;
            			break;
            		} //case
            	}
            }
            else {
            	System.out.println("NOT FOUND!!");
            }
//            if (loggedInUser != null) {
//                // User successfully logged in, show the corresponding dashboard
//                switch (loggedInUser.getUserType()) {
//                    case TENANT:
//                        showTenantDashboard((Tenant) loggedInUser);
//                        break;
//                    case HOUSING_OWNER:
//                        showHousingOwnerDashboard((HousingOwner) loggedInUser);
//                        break;
//                    case SYSTEM_ADMINISTRATOR:
//                        showSystemAdminDashboard((SystemAdministrator) loggedInUser);
//                        break;
//                }
//            }
        }

        scanner.close();
    }

    private static void showTenantDashboard(tenants tenant) {
        // Implement tenant dashboard functionality here based on product functions and user characteristics
        // For example:
        System.out.println("Welcome, " + tenant.getUsername() + "!");
        System.out.println("1. View available housing");
        System.out.println("2. View pictures and details of housing");
        System.out.println("3. Book accommodation");
        System.out.println("4. Logout");
        // Add more options based on tenant functions
        // Example: 4. View personal data, 5. View residence owner details, etc.
    }

    private static void showHousingOwnerDashboard(owner housingOwner) {
        // Implement housing owner dashboard functionality here based on product functions and user characteristics
        // For example:
        System.out.println("Welcome, " + housingOwner.getUsername() + "!");
        System.out.println("1. Add new housing unit");
        System.out.println("2. View list of your housing units");
        System.out.println("3. View tenant details for a specific housing unit");
        System.out.println("4. Logout");
        // Add more options based on housing owner functions
        // Example: 4. Modify housing unit details, 5. View requests for housing advertisement, etc.
    }

    private static void showSystemAdminDashboard(Administrator systemAdministrator) {
        // Implement system administrator dashboard functionality here based on product functions and user characteristics
        // For example:
        System.out.println("Welcome, System Administrator!");
        System.out.println("1. View requests for housing advertisement");
        System.out.println("2. Watch reservations via the system");
        System.out.println("3. Add and advertise housing units");
        System.out.println("4. Logout");
        // Add more options based on system administrator functions
        // Example: 4. Modify housing unit data, 5. Manage users, etc.
    }
}

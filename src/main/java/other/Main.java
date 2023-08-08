package other;
import mysakan.*;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.Logger;

import io.cucumber.plugin.event.Node.Example;
import mydbs.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyApp userApp = new MyApp();
        boolean running_logging = true;
        boolean running_logged = false;
        String username, password;
        User loggedInUser = null;
        int choice;
        int choice3=1;
        residenceAnnounced ressAn;
        boolean choseflag=false;
        LogLevelSetter.setLevel(logger);
        
        while (running_logging) {
            logger.info("Admin/tenant/owner dashboard");
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();
            String loggedIn = MyApp.login(username, password);
            if(loggedIn.equals("ADMIN")) {
            	logger.info("ADMIN LOGIN");
            	Administrator adminUser=AdministratorsDB.getAdmin(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showSystemAdminDashboard( adminUser);
//                    logger.info("1. View requests for housing advertisement");
//                    logger.info("2. Watch reservations via the system");
//                    logger.info("3. Add and advertise housing units");
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			logger.info("Viewing requests for housing advertisements");
            			break;
            		case 2:
            			logger.info("Watching reservations via the system");
            			break;
            		case 3:
            			logger.info("Adds a housing unit and advertises it");
            			break;
            		case 4: running_logged=false;
        				break;
            		default: logger.info("You entered wrong command!");
        				break;
            		} //case
            	}
            }
            else if(loggedIn.equals("OWNER")) {
            	logger.info("OWNER LOGIN");
            	owner ownerUser=OwnersDB.getOwner(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showHousingOwnerDashboard( ownerUser);
//            		logger.info("1. Add new housing unit");
//                    logger.info("2. View list of your housing units");
//                    logger.info("3. View tenant details for a specific housing unit");
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			int newID,newNumOfF;
            			String newName;
            			int isStudentHousing;
            			boolean cont=true;
            			residence newRes=new residence();
            			logger.config("Select The Residence ID");
            			newID=scanner.nextInt();
            			for(residence res:ResidentsDB.getResidences()) {
            				if (res.getResidenceID()==newID){
            					cont=false;
            					logger.info("ID is not unique!!");
            					break;
            				}
            			}
            			if(cont) {
            			newRes.setResidenceID(newID);
            			logger.config("Select The Residence Name");
            			newName=scanner.nextLine();
            			newRes.setResidenceName(newName);
            			logger.config("Select The # of Floors");
            			newNumOfF=scanner.nextInt();
            			newRes.setNumOfFloors(newNumOfF);
            			logger.config("Is it a student housing?/n 1 for Yes/n 0 for No");
            			isStudentHousing=scanner.nextInt();
            			newRes.setStudentHousing(isStudentHousing==1);
            			ResidentsDB.addResident(newRes);
            			logger.info("Resident was Added");
            			}
            			break;
            		case 2:
            			int number=1;
            			for(residence res:ResidentsDB.getResidences()) {
            				if (res.getOwnerName().equals(username)){
            					logger.info(number+".\n");
                				logger.info("Housing Name:"+res.getResidenceName());
                				number++;
            				}
            			}
            			break;
            		case 3:
            			int numberr=1;
            			logger.info("Please select a housing first!");	
            			for(residence res:ResidentsDB.getResidences()) {
            				if (res.getOwnerName().equals(username)){
            					logger.info(numberr+".\n");
                				logger.info("Housing Name:"+res.getResidenceName());
                				numberr++;
            				}
            			}
            			numberr=scanner.nextInt();
            			 residence myres=ResidentsDB.getResidences().get(numberr-1);
            			logger.info("residence Name:"+myres.getResidenceName());
            			logger.info("# of tenants"+myres.getNumOfTens());
            			for(int i=0;i<myres.getNumOfFloors();i++) {
            				for(int j=0;j<myres.getFloors().get(i).getNumOfApartements();j++) {
            					logger.info("Apartment ID:"+myres.getFloors().get(i).getApartments().get(j).getAppartmentId());
            					int numberTenants=1;
            					for(tenants myten:myres.getFloors().get(i).getApartments().get(j).getTenantslist()) {
            						logger.info(numberTenants+".\n");
            						logger.info("Name:"+myten.getName());
            						logger.info("Age:"+myten.getAge());
            						logger.info("Email:"+myten.getEmail());
            						logger.info("Phone Number:"+myten.getPhoneNumber());
            					}
            				}
            			}
            			break;
            		case 4: running_logged=false;
        				break;
            		default: logger.info("You entered wrong command!");
        				break;
            		} //case
            	}
            }
            else if(loggedIn.equals("TENANT")) {
            	logger.info("TENANT LOGIN");
            	tenants tenantsUser=TenantsDB.getTenant(username,password);
            	running_logged=true;
            	running_logging=false;
            	while(running_logged) {
            		showTenantDashboard( tenantsUser);
//           x 		logger.info("1. View available housing");
//           x         logger.info("2. View pictures and details of housing");
//                    logger.info("3. Book accommodation");
            		choice=scanner.nextInt();
            		switch(choice) {
            		case 1:
            			int choice2=1;
            			for(residenceAnnounced resAn: Announcedresidences.getAnnouncedResidences()) {
            				logger.info(choice2+".\n");
            				logger.info("Housing Name:"+resAn.getResidenceName());
            				choice2++;
            			}
            			break;
            		case 2:
            			logger.info("Please select a housing first!");
            			
            			
            			for(residenceAnnounced resAn: Announcedresidences.getAnnouncedResidences()) {
            				logger.info(choice3+".\n");
            				logger.info("Housing Name:"+resAn.getResidenceName());
            				choice3++;
            			}
            			choice3=scanner.nextInt();
            			 ressAn=Announcedresidences.getAnnouncedResidences().get(choice3-1);
            			logger.info("Monthly Rent:"+ressAn.getMonthlyRent());
        				logger.info("Description:"+"\n"+ressAn.getDescription());
        				logger.info("Contact Info:"+"\n"+ressAn.getContactName());
        				logger.info(ressAn.getPhoneNumber());
            			break;
            		case 3:
            			logger.info("Please select a housing first!");
            			for(residenceAnnounced ressAnnn: Announcedresidences.getAnnouncedResidences()) {
            				logger.info(choice3+".\n");
            				logger.info("Housing Name:"+ressAnnn.getResidenceName());
            				choice3++;
            			}
            			choice3=scanner.nextInt();
            			residenceAnnounced ressAnnn=Announcedresidences.getAnnouncedResidences().get(choice3-1);
            				int NumOfF=ressAnnn.getRecidence().getNumOfFloors();
            				int Floor;
            				int Apartment;
            				logger.info("There are "+NumOfF+" Floors.\n Please Pick a Floor");
            				Floor=scanner.nextInt();
            				floors pickedFloor=ressAnnn.getRecidence().getFloors().get(Floor-1);
            				
            				logger.info("There are "+pickedFloor.getNumOfApartements()+" Apartements in this floor.\n Please Pick an apartment.");
            				Apartment=scanner.nextInt();
            				appartment pickedApartment=pickedFloor.getApartments().get(Apartment-1);
            				pickedApartment.setNumOfTens(pickedApartment.getNumOfTens()+1);
            			
            			break;
            		case 4: running_logged=false;
            			break;
            		default: logger.info("You entered wrong command!");
            			break;
            		} //case
            	}
            }
            else {
            	logger.info("NOT FOUND!!");
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
    	
        logger.info("Welcome, " + tenant.getUsername() + "!");
        logger.info("1. View available housing");
        logger.info("2. View pictures and details of housing");
        logger.info("3. Book accommodation");
        logger.info("4. Logout");
        // Add more options based on tenant functions
        // Example: 4. View personal data, 5. View residence owner details, etc.
    }

    private static void showHousingOwnerDashboard(owner housingOwner) {
        // Implement housing owner dashboard functionality here based on product functions and user characteristics
        // For example:
        logger.info("Welcome, " + housingOwner.getUsername() + "!");
        logger.info("1. Add new housing unit");
        logger.info("2. View list of your housing units");
        logger.info("3. View tenant details for a specific housing unit");
        logger.info("4. Logout");
        // Add more options based on housing owner functions
        // Example: 4. Modify housing unit details, 5. View requests for housing advertisement, etc.
    }

    private static void showSystemAdminDashboard(Administrator systemAdministrator) {
        // Implement system administrator dashboard functionality here based on product functions and user characteristics
        // For example:
        logger.info("Welcome, System Administrator!");
        logger.info("1. View requests for housing advertisement");
        logger.info("2. Watch reservations via the system");
        logger.info("3. Add and advertise housing units");
        logger.info("4. Logout");
        // Add more options based on system administrator functions
        // Example: 4. Modify housing unit data, 5. Manage users, etc.
    }
}
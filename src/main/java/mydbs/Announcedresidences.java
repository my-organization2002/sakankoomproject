package mydbs;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import mysakan.appartment;
import mysakan.floors;
import mysakan.residence;
import mysakan.residenceAnnounced;
import mysakan.tenants;
public class Announcedresidences {
	   private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<residenceAnnounced> announceResidencesList=new ArrayList<residenceAnnounced>();

	   private Announcedresidences() {
		    throw new IllegalStateException("Utility class");
	   }
	   static {
		   tenants Ali= new tenants("Ali","Ali@email.com","0594234232");
		    tenants Omar= new tenants("Omar","Omar@email.com","0594232231");
		   ArrayList<tenants> Tenants=new ArrayList();
		   Tenants.add(Omar);
		   Tenants.add(Ali);
		   appartment App=new appartment(1,4,2,2,false,Tenants);
		   ArrayList<appartment>Appartments=new ArrayList();
		   Appartments.add(App);
		   floors Floor=new floors(Appartments,3,40);
		   ArrayList<floors>Floors=new ArrayList();
		   Floors.add(Floor);
		   residence myres=new residence(Floors, 125, 9, 1,true,"");
		    String residenceName="Sakan Nablus";
		    String address="Nablus-Rafidia";
		    String description="This is a student sakan";
			 int monthlyRent=450;
			 boolean rentInclusive=true;
			 String contactName="Saleem";
			 String email="Saleem@email.com";
			 String phoneNumber="+1 (555) 123-4567";
			 boolean announced=true;
			 residenceAnnounced resAnn=new residenceAnnounced(myres,residenceName,
					 address,description,monthlyRent,rentInclusive
					 ,contactName,email,phoneNumber,announced,null,null, 1);
			 announceResidencesList.add(resAnn);
			 
	   }
       

	public static List<residenceAnnounced> getAnnouncedResidences() {
		return announceResidencesList;
	}

	public static void addResident(residenceAnnounced myresidence) {
		announceResidencesList.add(myresidence);
	}
	
	public static residenceAnnounced findAnnouncedResidence(Integer id) {
		for(residenceAnnounced resAnnounced:Announcedresidences.getAnnouncedResidences())
		{
			
			if(resAnnounced.getRecidenceID()==id) 
			{
				return resAnnounced;
			}
		}
		return null;
		
	}

	public static void displayAnnouncedResidence(residenceAnnounced resAnn) {
		if(resAnn==null)
		{
			LOGGER.info("This residence does not exist");
		}
		else 
			 LOGGER.info("Residence Name: " + resAnn.getResidenceName()
             + "\nAddress: " + resAnn.getAddress()
             + "\nDescription: " + resAnn.getDescription()
             + "\nMonthly Rent: " + resAnn.getMonthlyRent()
             + "\nRent Inclusive: " + resAnn.isRentInclusive()
             + "\nContact Name: " + resAnn.getContactName()
             + "\nEmail: " + resAnn.getEmail()
             + "\nPhone Number: " + resAnn.getPhoneNumber());
	}
	public static void displayAnnouncedResidences(List<residenceAnnounced> resAnnouncedList) {
		for(residenceAnnounced resAnn:resAnnouncedList)
		{
			displayAnnouncedResidence(resAnn);	
		}
		
	}
	public static void suppressResidence(residenceAnnounced resAnn) {
		announceResidencesList.remove(resAnn);
		
	}

	public static void noAnnouncedRes() {
		LOGGER.warning("The Residence Does Not Exist/Is Not Announced");
	}

	public static List<residenceAnnounced> findAnnouncedResidenceByName(String name) {
		List<residenceAnnounced> announcedResidenceByName=new ArrayList<residenceAnnounced>();
		for(residenceAnnounced resAnn : announceResidencesList)
		{
			if(resAnn.getResidenceName().contains(name)) 
			{
				announcedResidenceByName.add(resAnn);	
			}
		}
		return announcedResidenceByName;
	}
	
	

}
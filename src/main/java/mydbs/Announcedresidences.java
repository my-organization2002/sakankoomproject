package mydbs;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import mysakan.Apartment;
import mysakan.Floors;
import mysakan.Residence;
import mysakan.ResidenceAnnounced;
import mysakan.Tenants;
public class Announcedresidences {
	   private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<ResidenceAnnounced> announceResidencesList= new ArrayList<>();

	   private Announcedresidences() {
		    throw new IllegalStateException("Utility class");
	   }
	   static {
		   Tenants ali= new Tenants("Ali","Ali@email.com","0594234232");
		    Tenants omar= new Tenants("Omar","Omar@email.com","0594232231");
		   ArrayList<Tenants> tenantss=new ArrayList();
		   tenantss.add(omar);
		   tenantss.add(ali);
		   Apartment App=new Apartment(1,4,2,2,false,tenantss);
		   ArrayList<Apartment>appartments=new ArrayList();
		   appartments.add(App);
		   Floors Floor=new Floors(appartments,3,40);
		   ArrayList<Floors>floorss=new ArrayList();
		   floorss.add(Floor);
		   Residence myres=new Residence(floorss, 125, 9, 1,true,"");
		    String residenceName="Sakan Nablus";
		    String address="Nablus-Rafidia";
		    String description="This is a student sakan";
			 int monthlyRent=450;
			 boolean rentInclusive=true;
			 String contactName="Saleem";
			 String email="Saleem@email.com";
			 String phoneNumber="+1 (555) 123-4567";
			 boolean announced=true;
			 ResidenceAnnounced resAnn=new ResidenceAnnounced(myres,residenceName,
					 address,description,monthlyRent,rentInclusive
					 ,contactName,email,phoneNumber,announced,null,null, 1);
			 announceResidencesList.add(resAnn);
			 
	   }
       

	public static List<ResidenceAnnounced> getAnnouncedResidences() {
		return announceResidencesList;
	}

	public static void addResident(ResidenceAnnounced myresidence) {
		announceResidencesList.add(myresidence);
	}
	
	public static ResidenceAnnounced findAnnouncedResidence(Integer id) {
		for(ResidenceAnnounced resAnnounced:Announcedresidences.getAnnouncedResidences())
		{
			
			if(resAnnounced.getRecidenceID()==id) 
			{
				return resAnnounced;
			}
		}
		return null;
		
	}

	public static void displayAnnouncedResidence(ResidenceAnnounced resAnn) {
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
	public static void displayAnnouncedResidences(List<ResidenceAnnounced> resAnnouncedList) {
		for(ResidenceAnnounced resAnn:resAnnouncedList)
		{
			displayAnnouncedResidence(resAnn);	
		}
		
	}
	public static void suppressResidence(ResidenceAnnounced resAnn) {
		announceResidencesList.remove(resAnn);
		
	}

	public static void noAnnouncedRes() {
		LOGGER.warning("The Residence Does Not Exist/Is Not Announced");
	}

	public static List<ResidenceAnnounced> findAnnouncedResidenceByName(String name) {
	    List<ResidenceAnnounced> announcedResidenceByName = new ArrayList<>();
		for(ResidenceAnnounced resAnn : announceResidencesList)
		{
			if(resAnn.getResidenceName().contains(name)) 
			{
				announcedResidenceByName.add(resAnn);	
			}
		}
		return announcedResidenceByName;
	}
	
	

}
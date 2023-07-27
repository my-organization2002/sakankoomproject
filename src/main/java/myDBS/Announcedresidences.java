package myDBS;
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
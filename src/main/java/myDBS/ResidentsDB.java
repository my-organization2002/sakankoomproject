package myDBS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import mysakan.residence;
import mysakan.residenceAnnounced;
public class ResidentsDB {
	   private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<residence> ResidencesList=new ArrayList<residence>();

	   private ResidentsDB() {
		    throw new IllegalStateException("Utility class");
	   }
       

	public static List<residence> getResidences() {
		return ResidencesList;
	}

	public static void addResident(residence myresidence) {
		ResidencesList.add(myresidence);
	}
	
	public static residence findAnnouncedResidence(Integer id) {
		for(residence res:ResidentsDB.getResidences())
		{
			
			if(res.getResidenceID()==id) 
			{
				return res;
			}
		}
		return null;
		
	}

	public static void displayResidence(residence res) {
		if(res==null)
		{
			LOGGER.info("This residence does not exist");
		}
		else 
			LOGGER.info("Number of Tenants: " + res.getNumOfTens()
            + "\nNumber of Floors: " + res.getNumOfFloors()
            + "\nResidence ID: " + res.getResidenceID());
	}
	public static void displayResidences(List<residence> resList) {
		for(residence res:resList)
		{
			displayResidence(res);	
		}
		
	}
	public static void suppressResidence(residence res) {
		ResidencesList.remove(res);
		
	}

	public static void noRes() {
		LOGGER.warning("The Residence Does Not Exist/Is Not Announced");
	}
	
	

}
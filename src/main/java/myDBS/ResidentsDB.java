package myDBS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import mysakan.appartment;
import mysakan.floors;
import mysakan.residence;
import mysakan.residenceAnnounced;
import mysakan.tenants;
public class ResidentsDB {
	   private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<residence> ResidencesList=new ArrayList<residence>();

	   private ResidentsDB() {
		    throw new IllegalStateException("Utility class");
	   }
	   static 
	    {
		  // appartment(int appartmentId, int numOfBedrooms,
				//   int numOfBathrooms, int numOfTens, boolean hasBalcony,
				//	ArrayList<tenants> tenantslist)
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
		   ResidencesList.add(new residence(Floors, 125, 9, 1,true,""));
		   
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

	public static residence getStudentHousingUnitById(Integer housingUnitId) {
		// TODO Auto-generated method stub
		for(residence res:ResidentsDB.getResidences())
		{
			
			if(res.getResidenceID()==housingUnitId && res.isStudentHousing()) 
			{
				return res;
			}
		}
		return null;
		
	}
	
	

}
package mydbs;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import mysakan.Apartment;
import mysakan.Floors;
import mysakan.Residence;
import mysakan.Tenants;
public class ResidentsDB {
	   private static final Logger LOGGER = Logger.getLogger(Residence.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<Residence> ResidencesList=new ArrayList<>();

	   private ResidentsDB() {
		    throw new IllegalStateException("Utility class");
	   }
	   static 
	    {
		  // appartment(int appartmentId, int numOfBedrooms,
				//   int numOfBathrooms, int numOfTens, boolean hasBalcony,
				//	ArrayList<tenants> tenantslist)
		    Tenants ali= new Tenants("Ali","Ali@email.com","0594234232");
		    Tenants omar= new Tenants("Omar","Omar@email.com","0594232231");
		   ArrayList<Tenants> Tenants=new ArrayList<>();
		   Tenants.add(omar);
		   Tenants.add(ali);
		   Apartment app=new Apartment(1,4,2,2,false,Tenants);
		   ArrayList<Apartment>appartments=new ArrayList<>();
		   appartments.add(app);
		   Floors floor=new Floors(appartments,3,40);
		   ArrayList<Floors>floorss=new ArrayList<>();
		   floorss.add(floor);
		   ResidencesList.add(new Residence(floorss, 125, 9, 1,true,""));
		   
	    }

	public static List<Residence> getResidences() {
		return ResidencesList;
	}

	public static void addResident(Residence myresidence) {
		ResidencesList.add(myresidence);
	}
	
	public static Residence findAnnouncedResidence(Integer id) {
		for(Residence res:ResidentsDB.getResidences())
		{
			
			if(res.getResidenceID()==id) 
			{
				return res;
			}
		}
		return null;
		
	}

	public static void displayResidence(Residence res) {
		if(res==null)
		{
			LOGGER.info("This residence does not exist");
		}
		else 
			LOGGER.info("Number of Tenants: " + res.getNumOfTens()
            + "\nNumber of Floors: " + res.getNumOfFloors()
            + "\nResidence ID: " + res.getResidenceID());
	}
	public static void displayResidences(List<Residence> resList) {
		for(Residence res:resList)
		{
			displayResidence(res);	
		}
		
	}
	public static void suppressResidence(Residence res) {
		ResidencesList.remove(res);
		
	}

	public static void noRes() {
		LOGGER.warning("The Residence Does Not Exist/Is Not Announced");
	}

	public static Residence getStudentHousingUnitById(Integer housingUnitId) {
		for(Residence res:ResidentsDB.getResidences())
		{
			
			if(res.getResidenceID()==housingUnitId && res.isStudentHousing()) 
			{
				return res;
			}
		}
		return null;
		
	}
	
	

}
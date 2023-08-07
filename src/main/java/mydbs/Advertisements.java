package mydbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import mysakan.residenceAnnounced;

public class Advertisements {
	 private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<Map<String, String>> Ads=new ArrayList();

	   private Advertisements() {
		    throw new IllegalStateException("Utility class");
	   }
     

	   public static List<Map<String, String>> getAds() {
	        return Ads;
	    }

	   public static void advertise(Map<String, String> furnitureData) {
	        Ads.add(furnitureData);
	    }
	 

}

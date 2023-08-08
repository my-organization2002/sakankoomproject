package mydbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Advertisements {


	   private static List<Map<String, String>> ads=new ArrayList();

	   private Advertisements() {
		    throw new IllegalStateException("Utility class");
	   }
     

	   public static List<Map<String, String>> getads() {
	        return ads;
	    }

	   public static void advertise(Map<String, String> furnitureData) {
	        ads.add(furnitureData);
	    }
	 

}

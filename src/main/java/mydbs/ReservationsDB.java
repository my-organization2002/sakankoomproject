package mydbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import mysakan.Reservation;
import mysakan.residence;

public class ReservationsDB {
	 private static final Logger LOGGER = Logger.getLogger(Announcedresidences.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<Reservation> ReservationsList=new ArrayList<Reservation>();

	public static void put(int reservationId, Map<String, String> reservationDetails) {
			Reservation x=new Reservation(reservationId,reservationDetails);
			ReservationsList.add(x);
	}
	static {
		Map<String, String> reservationDetails = new HashMap();
	    reservationDetails.put("status", "Rejected");
	    reservationDetails.put("rejectionReason", "Reason is");
		ReservationsList.add(new Reservation(123, reservationDetails));
		ReservationsList.add(new Reservation(456,reservationDetails));
	}

	public static Map<String, String> get(int selectedReservationId) {
		for(Reservation res:ReservationsList)
		{
			
			if(res.getReservationId()==selectedReservationId) 
			{
				return res.getReservationDetails();
			}
		}
		return null;
	}

	public static boolean containsKey(Integer reservationId) {
		for(Reservation res:ReservationsList)
		{
			
			if(res.getReservationId()==reservationId) 
			{
				return true;
			}
			
		}
		return false;
	}

}

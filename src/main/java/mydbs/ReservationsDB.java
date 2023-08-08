package mydbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import mysakan.Reservation;

public class ReservationsDB {
	 private static final Logger LOGGER = Logger.getLogger(ReservationsDB.class.getName());
	   private static final String COMPLETE = "complete";  // Compliant

	   private static List<Reservation> reservationsList=new ArrayList<>();

	public static void put(int reservationId, Map<String, String> reservationDetails) {
			Reservation x=new Reservation(reservationId,reservationDetails);
			reservationsList.add(x);
	}
	static {
		Map<String, String> reservationDetails = new HashMap<>();
	    reservationDetails.put("status", "Rejected");
	    reservationDetails.put("rejectionReason", "Reason is");
		reservationsList.add(new Reservation(123, reservationDetails));
		reservationsList.add(new Reservation(456,reservationDetails));
	}

	public static Map<String, String> get(int selectedReservationId) {
		for(Reservation res:reservationsList)
		{
			
			if(res.getReservationId()==selectedReservationId) 
			{
				return res.getReservationDetails();
			}
		}
		return null;
	}

	public static boolean containsKey(Integer reservationId) {
		for(Reservation res:reservationsList)
		{
			
			if(res.getReservationId()==reservationId) 
			{
				return true;
			}
			
		}
		return false;
	}

}

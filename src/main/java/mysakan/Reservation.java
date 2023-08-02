package mysakan;

import java.util.Map;

public class Reservation {
	private int reservationId;
	private Map<String, String> reservationDetails;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	public Map<String, String> getReservationDetails() {
		return reservationDetails;
	}
	public void setReservationDetails(Map<String, String> reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
	
	public Reservation(int reservationId, Map<String, String> reservationDetails) {
		super();
		this.reservationId = reservationId;
		this.reservationDetails = reservationDetails;
	}
	public Reservation() {
		super();
	}
	
}

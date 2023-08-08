package mysakan;

import java.util.ArrayList;
import java.util.List;

public class residenceAnnounced {
	private residence Recidence;
	private String residenceName;
	private String address;
	private String description;
	private int monthlyRent;
	private boolean rentInclusive;
	private String contactName;
	private String email;
	private String phoneNumber;
	private boolean announced;
	private  boolean Advertised;
	ArrayList <Photos> Photos=new ArrayList();
	ArrayList <String> availableServices=new ArrayList();
	private int recidenceID;
	

	public residenceAnnounced(residence recidence, String residenceName, String address, String description,
			int monthlyRent, boolean rentInclusive, String contactName, String email, String phoneNumber,
			boolean announced, ArrayList<mysakan.Photos> photos, ArrayList<String> availableServices, int recidenceID) {
		super();
		Recidence = recidence;
		this.residenceName = residenceName;
		this.address = address;
		this.description = description;
		this.monthlyRent = monthlyRent;
		this.rentInclusive = rentInclusive;
		this.contactName = contactName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.announced = announced;
		Photos = photos;
		this.availableServices = availableServices;
		this.recidenceID = recidenceID;
	}

	public residenceAnnounced() {
		super();
	}

	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}
	public void addPhoto(String photoName, String photoURL) {
		this.Photos.add(new Photos(photoName,photoURL));
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAvailableServices(List<String> availableServices) {
	    // Create a new ArrayList and add all elements from the original list
		this.availableServices = new ArrayList<String>(availableServices);

	}
	public void setMonthlyRent(Integer rentAmount) {
		this.monthlyRent=rentAmount;
		
	}
	public void setRentInclusive(boolean b) {
		this.rentInclusive=b;
		
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public residence getRecidence() {
		return Recidence;
	}
	public void setRecidence(residence recidence) {
		this.Recidence = recidence;
	}
	public int getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public boolean isRentInclusive() {
		return rentInclusive;
	}
	public String getErrorMessage() {
		return "The ID of the residence you're trying to announce does not exist";
		
	}

	public int getRecidenceID() {
		return this.recidenceID;
	}

	public void setRecidenceID(int recidenceID) {
		this.recidenceID = recidenceID;
	}

	public boolean isAdvertised() {
		return Advertised;
	}

	public void setAdvertised(boolean advertised) {
		Advertised = advertised;
	}
	
	
	
}
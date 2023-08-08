package mysakan;

import java.util.ArrayList;
import java.util.List;

public class ResidenceAnnounced {
	private Residence myRecidence;
	private String residenceName;
	private String address;
	private String description;
	private int monthlyRent;
	private boolean rentInclusive;
	private String contactName;
	private String email;
	private String phoneNumber;
	private boolean announced;
	private  boolean advertised;
	ArrayList <Photos> photos=new ArrayList<>();
	ArrayList <String> availableServices=new ArrayList<>();
	private int recidenceID;
	

	public ResidenceAnnounced(Residence recidence, String residenceName, String address, String description,
			int monthlyRent, boolean rentInclusive, String contactName, String email, String phoneNumber,
			boolean announced, List<mysakan.Photos> photos, List<String> availableServices, int recidenceID) {
		super();
		myRecidence = recidence;
		this.residenceName = residenceName;
		this.address = address;
		this.description = description;
		this.monthlyRent = monthlyRent;
		this.rentInclusive = rentInclusive;
		this.contactName = contactName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.announced = announced;
		this.photos = (ArrayList<Photos>) photos;
		this.availableServices = (ArrayList<String>) availableServices;
		this.recidenceID = recidenceID;
	}

	public ResidenceAnnounced() {
		super();
	}

	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}
	public void addPhoto(String photoName, String photoURL) {
		this.photos.add(new Photos(photoName,photoURL));
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
	    this.availableServices = new ArrayList<>(availableServices);
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
	public Residence getRecidence() {
		return this.myRecidence;
	}
	public void setRecidence(Residence recidence) {
		this.myRecidence = recidence;
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
		return advertised;
	}

	public void setAdvertised(boolean advertised) {
		this.advertised = advertised;
	}
	
	
	
}
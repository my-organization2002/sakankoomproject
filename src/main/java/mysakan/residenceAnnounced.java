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
	ArrayList <Photos> Photos=new ArrayList();
	ArrayList <String> availableServices=new ArrayList();
	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}
	public void addPhoto(String photoName, String photoURL) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		this.availableServices=(ArrayList<String>) availableServices;
	}
	public void setMonthlyRent(Integer rentAmount) {
		// TODO Auto-generated method stub
		this.monthlyRent=rentAmount;
		
	}
	public void setRentInclusive(boolean b) {
		// TODO Auto-generated method stub
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
		Recidence = recidence;
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
	
	
}

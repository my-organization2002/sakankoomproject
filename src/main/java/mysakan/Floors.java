package mysakan;
import java.util.ArrayList;
import java.util.List;

public class Floors {
	ArrayList <Apartment> appartmentList=new ArrayList<>();
	private int floorID;
	private int numOfApartements;
	
	public Floors() {
		super();
	}
	public int getFloorID() {
		return floorID;
	}
	public void setFloorID(int floorID) {
		this.floorID = floorID;
	}
	public int getNumOfApartements() {
		return numOfApartements;
	}
	public void setNumOfApartements(int numOfApartements) {
		this.numOfApartements = numOfApartements;
	}
	public Floors(List<Apartment> appartmentList, int floorID, int numOfApartements) {
		super();
		this.appartmentList = (ArrayList<Apartment>) appartmentList;
		this.floorID = floorID;
		this.numOfApartements = numOfApartements;
	}
	
	public Apartment selectApartment(Integer apartmentId) {
		for(Apartment appartmentunit:appartmentList) {
			if(appartmentunit.getAppartmentId()==apartmentId) {
				return appartmentunit;
			}
		}
		return null;
	}
	public List<Apartment> getApartments() {
		return this.appartmentList;
	}

}

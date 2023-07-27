package mysakan;
import java.util.ArrayList;

public class floors {
	ArrayList <appartment> appartmentlist=new ArrayList();
	private int floorID;
	private int numOfApartements;
	
	public floors() {
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
	public floors(ArrayList<appartment> appartmentlist, int floorID, int numOfApartements) {
		super();
		this.appartmentlist = appartmentlist;
		this.floorID = floorID;
		this.numOfApartements = numOfApartements;
	}
	
	public appartment selectApartment(Integer apartmentId) {
		// TODO Auto-generated method stub
		for(appartment appartmentunit:appartmentlist) {
			if(appartmentunit.getAppartmentId()==apartmentId) {
				return appartmentunit;
			}
		}
		return null;
	}

}

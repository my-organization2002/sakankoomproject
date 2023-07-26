package mysakan;
import java.util.ArrayList;
import java.util.List;

public class residence {
	ArrayList <floors> floorlist=new ArrayList();
	private int numOfTens;
	private int numOfFloors;
	private int residenceID;
	
	

	public residence(ArrayList<floors> floorlist, int numOfTens, int numOfFloors, int residenceID) {
		super();
		this.floorlist = floorlist;
		this.numOfTens = numOfTens;
		this.numOfFloors = numOfFloors;
		this.residenceID = residenceID;
	}
	public residence() {
		super();
	}
	
	public int getNumOfTens() {
		return numOfTens;
	}
	public void setNumOfTens(int numOfTens) {
		this.numOfTens = numOfTens;
	}
	public int getNumOfFloors() {
		return numOfFloors;
	}
	public void setNumOfFloors(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}
	
	public int getResidenceID() {
		return residenceID;
	}
	public void setResidenceID(int residenceID) {
		this.residenceID = residenceID;
	}
	public floors selectFloor(Integer FloorId) {
		// TODO Auto-generated method stub
		for(floors floor:floorlist) {
			if(floor.getFloorID()==FloorId) {
				return floor;
			}
		}
		return null;
	}
	
	
	

}

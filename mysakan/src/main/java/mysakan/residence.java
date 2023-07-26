package mysakan;
import java.util.ArrayList;

public class residence {
	ArrayList <floors> floorlist=new ArrayList();
	private int numOfTens;
	private int numOfFloors;
	private int residenceID;
	private String residenceName;
	
	public residence(ArrayList<floors> floorlist, int numOfTens, int numOfFloors, String residenceName) {
		super();
		this.floorlist = floorlist;
		this.numOfTens = numOfTens;
		this.numOfFloors = numOfFloors;
		this.residenceName = residenceName;
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
	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
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

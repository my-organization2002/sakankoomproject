package mysakan;
import java.util.ArrayList;
import java.util.List;

public class residence {
	ArrayList <floors> floorlist=new ArrayList();
	private int numOfTens;
	private int numOfFloors;
	private int residenceID;
	private boolean StudentHousing;
	private String residenceName;
	private String ownerName;
	
	

	public residence(ArrayList<floors> floorlist, int numOfTens, int numOfFloors, int residenceID, boolean StudentHouse,String residenceName) {
		super();
		this.floorlist = floorlist;
		this.numOfTens = numOfTens;
		this.numOfFloors = numOfFloors;
		this.residenceID = residenceID;
		this.StudentHousing=StudentHouse;
		this.residenceName=residenceName;
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
		for(floors floor:floorlist) {
			if(floor.getFloorID()==FloorId) {
				return floor;
			}
		}
		return null;
	}
	public boolean isStudentHousing() {
		return this.StudentHousing;
	}
	public void setStudentHousing(boolean studentHousing) {
		StudentHousing = studentHousing;
	}
	public ArrayList<floors> getFloors() {
		return this.floorlist;
	}
	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	
	
	

}

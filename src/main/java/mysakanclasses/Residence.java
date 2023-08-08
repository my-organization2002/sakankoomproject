package mysakanclasses;
import java.util.ArrayList;
import java.util.List;
public class Residence {
	ArrayList <Floors> floorlist=new ArrayList<>();
	private int numOfTens;
	private int numOfFloors;
	private int residenceID;
	private boolean studentHousing;
	private String residenceName;
	private String ownerName;
	
	

	public Residence(List<Floors> floorlist, int numOfTens, int numOfFloors, int residenceID, boolean StudentHouse,String residenceName) {
		super();
		this.floorlist = (ArrayList<Floors>) floorlist;
		this.numOfTens = numOfTens;
		this.numOfFloors = numOfFloors;
		this.residenceID = residenceID;
		this.studentHousing=StudentHouse;
		this.residenceName=residenceName;
	}
	public Residence() {
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
	public Floors selectFloor(Integer floorId) {
		for(Floors floor:floorlist) {
			if(floor.getFloorID()==floorId) {
				return floor;
			}
		}
		return null;
	}
	public boolean isStudentHousing() {
		return this.studentHousing;
	}
	public void setStudentHousing(boolean studentHousing) {
		this.studentHousing = studentHousing;
	}
	public List<Floors> getFloors() {
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

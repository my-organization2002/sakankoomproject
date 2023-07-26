package mysakan;

import java.util.ArrayList;

public class appartment {
	private int appartmentId;
	private int numOfBedrooms;
	private int numOfBathrooms;
	private int numOfTens;
	private boolean hasBalcony;
	ArrayList <tenants> tenantslist=new ArrayList();
	public int getAppartmentId() {
		return appartmentId;
	}
	public void setAppartmentId(int appartmentId) {
		this.appartmentId = appartmentId;
	}
	public int getNumOfBedrooms() {
		return numOfBedrooms;
	}
	public void setNumOfBedrooms(int numOfBedrooms) {
		this.numOfBedrooms = numOfBedrooms;
	}
	public int getNumOfBathrooms() {
		return numOfBathrooms;
	}
	public void setNumOfBathrooms(int numOfBathrooms) {
		this.numOfBathrooms = numOfBathrooms;
	}
	public boolean isHasBalcony() {
		return hasBalcony;
	}
	public void setHasBalcony(boolean hasBalcony) {
		this.hasBalcony = hasBalcony;
	}
	
	public appartment(int appartmentId, int numOfBedrooms, int numOfBathrooms, int numOfTens, boolean hasBalcony,
			ArrayList<tenants> tenantslist) {
		super();
		this.appartmentId = appartmentId;
		this.numOfBedrooms = numOfBedrooms;
		this.numOfBathrooms = numOfBathrooms;
		this.numOfTens = numOfTens;
		this.hasBalcony = hasBalcony;
		this.tenantslist = tenantslist;
	}
	
	public int getNumOfTens() {
		return numOfTens;
	}
	public void setNumOfTens(int numOfTens) {
		this.numOfTens = numOfTens;
	}
	public boolean hasTenant(String name) {
		// TODO Auto-generated method stub
		for(tenants tenant:tenantslist) {
			if(tenant.getName()==name) {
				return true;
			}
		}
		return false;
	}
	
}

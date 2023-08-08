package mysakanclasses;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
	private int appartmentId;
	private int numOfBedrooms;
	private int numOfBathrooms;
	private int numOfTens;
	private boolean hasBalcony;
	ArrayList <Tenants> tenantsList=new ArrayList<>();
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
	
	public Apartment(int appartmentId, int numOfBedrooms, int numOfBathrooms, int numOfTens, boolean hasBalcony,
			List<Tenants> tenantslist) {
		super();
		this.appartmentId = appartmentId;
		this.numOfBedrooms = numOfBedrooms;
		this.numOfBathrooms = numOfBathrooms;
		this.numOfTens = numOfTens;
		this.hasBalcony = hasBalcony;
		this.tenantsList = (ArrayList<Tenants>) tenantslist;
	}
	
	public int getNumOfTens() {
		return numOfTens;
	}
	public void setNumOfTens(int numOfTens) {
		this.numOfTens = numOfTens;
	}
	
	public List<Tenants> getTenantslist() {
		return tenantsList;
	}
	public void setTenantslist(List<Tenants> tenantslist) {
		this.tenantsList = (ArrayList<Tenants>) tenantslist;
	}
	public boolean hasTenant(String name) {
		for(Tenants tenant:tenantsList) {
			if(tenant.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
}

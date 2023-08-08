package mysakanclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Owner {
    private ArrayList<Residence> residenceList;
    private ArrayList<ResidenceAnnounced> announcedResidences;
    private boolean loggedInFlag;
    private int chosenResidence;
    private int numOfTenants;
    private int numOfFloors;
    private String username;
    private String password;
    private Scanner input;

    public Owner(List<Residence> residenceList) {
        this.residenceList=(ArrayList<Residence>) residenceList;
        loggedInFlag = false;
        input = new Scanner(System.in);
        numOfFloors=0;
        numOfTenants=0;
        chosenResidence=0;
    }
    public Owner() {
    	this.residenceList=new ArrayList<>();
    	loggedInFlag = false;
        input = new Scanner(System.in);
        numOfFloors=0;
        numOfTenants=0;
        chosenResidence=0;
    }
	public ArrayList<Residence> getResidenceList() {
		return residenceList;
	}
    public void addResidence(Residence myResidence) {
    	this.residenceList.add(myResidence);
    }
	public void setResidenceList(List<Residence> residenceList) {
		this.residenceList = (ArrayList<Residence>) residenceList;
	}
	public boolean getLoggedInFlag() {
		return loggedInFlag;
	}
	public void setLoggedInFlag(boolean loggedInFlag) {
		this.loggedInFlag = loggedInFlag;
	}
	public int getChosenResidence() {
		return chosenResidence;
	}
	public void setChosenResidence(int chosenResidence) {
		this.chosenResidence = chosenResidence;
	}
	public int getNumOfTenants() {
		return numOfTenants;
	}
	public void setNumOfTenants(int numOfTenants) {
		this.numOfTenants = numOfTenants;
	}
	public int getNumOfFloors() {
		return numOfFloors;
	}
	public void setNumOfFloors(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}
	public Scanner getInput() {
		return input;
	}
	public void setInput(Scanner input) {
		this.input = input;
	}
	public void accessControlPanel() {
        if (residenceList.isEmpty()) {
            System.out.println("No housing units available.");
        }
    }

    public boolean hasHousingUnits() {
        return true;
    }

    public void clickOnHousingUnit() {
        if (chosenResidence < 1 || chosenResidence > residenceList.size()) {
            System.out.println("Invalid residence number.");
            return;
        }

        Residence selectedResidence = residenceList.get(chosenResidence - 1);
        numOfTenants = selectedResidence.getNumOfTens();
        numOfFloors = selectedResidence.getNumOfFloors();
    }

    public boolean hasNumberOfTenantsAndFloors() {
        return (numOfTenants + numOfFloors) > 0;
    }

    public void chooseSpecificFloor() {
        // Implement the logic to choose a specific floor
    	
    }

    public boolean hasTenantNames() {
        // Implement the logic to check if tenant names are available
        return false;
    }

    public boolean hasMeansOfCommunication() {
        // Implement the logic to check if means of communication are available
        return false;
    }

    public boolean hasBathroomsAndBedrooms() {
        // Implement the logic to check if bathrooms and bedrooms information is available
        return false;
    }

    public boolean hasBalcony() {
        // Implement the logic to check if balcony information is available
        return false;
    }
	public boolean apartmentsAppearFromFloor() {
		return false;
	}
	public Residence selectHousingUnit(Integer housingUnitId) {
		for(Residence housingunit:residenceList) {
			if(housingunit.getResidenceID()==housingUnitId) {
				return housingunit;
			}
		}
		return null;
	}
	public void clearResidences() {
		this.residenceList.clear();
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<ResidenceAnnounced> getAnnouncedResidences() {
		return announcedResidences;
	}
	public void setAnnouncedResidences(ArrayList<ResidenceAnnounced> announcedResidences) {
		this.announcedResidences = announcedResidences;
	}
	

    // Add methods to add residences and perform other relevant operations

    // Getters and setters for class properties
}

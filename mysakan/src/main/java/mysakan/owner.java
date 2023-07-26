package mysakan;

import java.util.ArrayList;
import java.util.Scanner;

public class owner {
    private ArrayList<residence> residenceList;
    private boolean loggedInFlag;
    private int chosenResidence;
    private int numOfTenants;
    private int numOfFloors;
    private Scanner input;

    public owner(ArrayList<residence> residenceList) {
        this.residenceList=residenceList;
        loggedInFlag = false;
        input = new Scanner(System.in);
        numOfFloors=0;
        numOfTenants=0;
        chosenResidence=0;
    }
    public owner() {
    	this.residenceList=new ArrayList();
    	loggedInFlag = false;
        input = new Scanner(System.in);
        numOfFloors=0;
        numOfTenants=0;
        chosenResidence=0;
    }
    

    public ArrayList<residence> getResidenceList() {
		return residenceList;
	}
	public void setResidenceList(ArrayList<residence> residenceList) {
		this.residenceList = residenceList;
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
            return;
        }
    }

    public boolean hasHousingUnits() {
        return !residenceList.isEmpty();
    }

    public void clickOnHousingUnit() {
        if (chosenResidence < 1 || chosenResidence > residenceList.size()) {
            System.out.println("Invalid residence number.");
            return;
        }

        residence selectedResidence = residenceList.get(chosenResidence - 1);
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
		// TODO Auto-generated method stub
		return false;
	}
	public residence selectHousingUnit(Integer housingUnitId) {
		// TODO Auto-generated method stub
		for(residence housingunit:residenceList) {
			if(housingunit.getResidenceID()==housingUnitId) {
				return housingunit;
			}
		}
		return null;
	}

    // Add methods to add residences and perform other relevant operations

    // Getters and setters for class properties
}

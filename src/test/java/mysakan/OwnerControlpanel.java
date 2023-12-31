package mysakan;

import io.cucumber.java.en.*;
import mydbs.ResidentsDB;
import mysakanclasses.Apartment;
import mysakanclasses.Floors;
import mysakanclasses.Owner;
import mysakanclasses.Residence;

import static org.junit.Assert.assertTrue;

public class OwnerControlpanel {
    Owner housingowner;
    Residence selectedHousingUnit;
    Floors selectedFloor;
    Apartment selectedApartment;

    public OwnerControlpanel(Owner housingowner) {
        this.housingowner = housingowner;
    } // Dependency injection
    
    @Given("The owner is Logged in")
    public void theownerIsLoggedIn() {
    	housingowner.setLoggedInFlag(true);
        assertTrue(housingowner.getLoggedInFlag());
    }

    @When("I access my control panel")
    public void iAccessMyControlPanel() {
        housingowner.accessControlPanel();
    }

    @Then("I should see a list of my housing units")
    public void iShouldSeeAListOfMyHousingUnits() {
        assertTrue(housingowner.hasHousingUnits());
    }

    @When("I choose housing unit with ID {int}")
    public void iChooseHousingUnitWithID(Integer housingUnitId) {
        selectedHousingUnit = ResidentsDB.findAnnouncedResidence(housingUnitId);
    }

    @Then("I should see that it has {int} Tenants and {int} Floors")
    public void iShouldSeeThatItHasTenantsAndFloors(Integer numTenants, Integer numFloors) {
        assertTrue(selectedHousingUnit.getNumOfTens() == numTenants);
        assertTrue(selectedHousingUnit.getNumOfFloors() == numFloors);
    }
    @Given("I have chose housing unit with ID {int}")
    public void iHaveChoseHousingUnitWithID(Integer housingUnitId) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        selectedHousingUnit = ResidentsDB.findAnnouncedResidence(housingUnitId);

    }

    @When("I choose the Floor with ID {int}")
    public void iChooseTheFloorWithID(Integer floorId) {
        selectedFloor = selectedHousingUnit.selectFloor(floorId);
    }
    @Then("I should see that it has {int} Apartements")
    public void iShouldSeeThatItHasApartements(Integer numApartments) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    	assertTrue(selectedFloor.getNumOfApartements() == numApartments);
    }


    @When("I choose the Apartment with ID {int}")
    public void iChooseTheApartmentWithID(Integer apartmentId) {
        selectedApartment = selectedFloor.selectApartment(apartmentId);
    }

    @Then("I should see that it has {int} Tenants")
    public void iShouldSeeThatItHasTenants(Integer numTenants) {
        assertTrue(selectedApartment.getNumOfTens() == numTenants);
    }

    @Then("Their names being {string} and {string}")
    public void theirNamesBeingAnd(String name1, String name2) {
        assertTrue(selectedApartment.hasTenant(name1));
        assertTrue(selectedApartment.hasTenant(name2));
    }
    @Then("the means of communication with them should be displayed {string},{string}")
    public void theMeansOfCommunicationWithThemShouldBeDisplayed(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    	assertTrue(selectedApartment.getTenantslist().get(1).getEmail().equalsIgnoreCase(string));
    	assertTrue(selectedApartment.getTenantslist().get(0).getEmail().equalsIgnoreCase(string2));

    }

    @Then("the number of bathrooms being {int}")
    public void theNumberOfBathroomsBeing(Integer numBathrooms) {
        assertTrue(selectedApartment.getNumOfBathrooms() == numBathrooms);
    }

    @Then("the number of bedrooms being {int}")
    public void theNumberOfBedroomsBeing(Integer numBedrooms) {
        assertTrue(selectedApartment.getNumOfBedrooms() == numBedrooms);
    }
    @Then("if it has a balcony of not being true")
    public void ifItHasABalconyOfNotBeingTrue() {
        // Write code here that turns the phrase above into concrete actions
    	assertTrue(!(selectedApartment.isHasBalcony()));
    }
}

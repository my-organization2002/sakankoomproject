package mysakan;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;

public class ownercontrolpanel {
    owner housingowner;
    residence selectedHousingUnit;
    floors selectedFloor;
    appartment selectedApartment;

    public ownercontrolpanel(owner housingowner) {
        this.housingowner = housingowner;
    } // Dependency injection
    
    @Given("The owner is Logged in")
    public void theownerIsLoggedIn() {
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
        selectedHousingUnit = housingowner.selectHousingUnit(housingUnitId);
    }

    @Then("I should see that it has {int} Tenants and {int} Floors")
    public void iShouldSeeThatItHasTenantsAndFloors(Integer numTenants, Integer numFloors) {
        assertTrue(selectedHousingUnit.getNumOfTens() == numTenants);
        assertTrue(selectedHousingUnit.getNumOfFloors() == numFloors);
    }

    @When("I choose the Floor with ID {int}")
    public void iChooseTheFloorWithID(Integer floorId) {
        selectedFloor = selectedHousingUnit.selectFloor(floorId);
    }

    @Then("I should see that it has {int} Apartments")
    public void iShouldSeeThatItHasApartments(Integer numApartments) {
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
    	assertTrue(selectedApartment.isHasBalcony());
    }
}
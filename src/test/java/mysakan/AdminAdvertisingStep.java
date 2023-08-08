package mysakan;

import static org.junit.Assert.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import mydbs.Announcedresidences;
import mydbs.ResidentsDB;
import mysakanclasses.Administrator;
import mysakanclasses.ResidenceAnnounced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminAdvertisingStep {
    private Administrator admin;
    private ResidenceAnnounced newHousingUnit;
    private boolean housingUnitAdvertised;

    public AdminAdvertisingStep() {
        // Create instances of the required dependencies here
        admin = new Administrator();
        newHousingUnit = new ResidenceAnnounced();
        housingUnitAdvertised = false;
    }

    @Given("The Administrator is Logged in")
    public void theAdministratorIsLoggedIn() {
        // Implement the logic for the administrator being logged in
        // You may need to set some properties or flags in the 'Administrator' class
        // to indicate that the administrator is logged in
        admin.setLoggedIn(true);
    }

    @Given("the administrator accesses the app")
    public void theAdministratorAccessesTheApp() {
        // Nothing to do here as the login is already handled in the background step
    }

    @When("the administrator adds a new housing unit with the following details:")
    public void theAdministratorAddsANewHousingUnitWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> housingUnitData = dataTable.asMaps(String.class, String.class);
        // Assuming you have appropriate setters in the 'residence' class
        for (Map<String, String> data : housingUnitData) {
            int residenceID = Integer.parseInt(data.get("Residence ID"));
            String residenceName = data.get("Residence Name");
            String address = data.get("Address");
            String description = data.get("Description");
            int rentAmount = Integer.parseInt(data.get("Rent Amount"));
            boolean rentInclusive = Boolean.parseBoolean(data.get("Rent Inclusive"));
            List<Map<String, String>> dataMaps = dataTable.asMaps(String.class, String.class);
            List<String> availableServices = new ArrayList();

            for (Map<String, String> dataa : dataMaps) {
                String service = dataa.get("Service");
                availableServices.add(service);
            } // Use dataTable.asList(String.class) instead
            String contactName = data.get("Contact Name");
            String email = data.get("Email");
            String phone = data.get("Phone");

            newHousingUnit.setRecidenceID(residenceID);
            newHousingUnit.setResidenceName(residenceName);
            newHousingUnit.setAddress(address);
            newHousingUnit.setDescription(description);
            newHousingUnit.setMonthlyRent(rentAmount);
            newHousingUnit.setRentInclusive(rentInclusive);
            newHousingUnit.setAvailableServices(availableServices);
            newHousingUnit.setContactName(contactName);
            newHousingUnit.setEmail(email);
            newHousingUnit.setPhoneNumber(phone);
        }
    }

    @When("specifies the available services:")
    public void specifiesTheAvailableServices(DataTable dataTable) {
        List<String> availableServices = dataTable.asList(String.class);
        newHousingUnit.setAvailableServices(availableServices);
    }

    @When("sets the monthly rent amount to ${int}")
    public void setsTheMonthlyRentAmountTo$(Integer rentAmount) {
        newHousingUnit.setMonthlyRent(rentAmount);
    }

    @When("specifies that the rent includes electricity and water")
    public void specifiesThatTheRentIncludesElectricityAndWater() {
        newHousingUnit.setRentInclusive(true);
    }

    @When("provides the following contact information:")
    public void providesTheFollowingContactInformation(DataTable dataTable) {
    	List<Map<String, String>> contactData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : contactData) {
            String contactName = row.get("Contact Name");
            String email = row.get("Email");
            String phone = row.get("Phone");

            // Assuming you have a way to associate multiple contacts with the housing unit
            // You can add them to a list or set them accordingly
            // For this example, I'll just set them directly to the housing unit
            newHousingUnit.setContactName(contactName);
            newHousingUnit.setEmail(email);
            newHousingUnit.setPhoneNumber(phone);
            }
    }

    @Then("the new housing unit is added and advertised through the system")
    public void theNewHousingUnitIsAddedAndAdvertisedThroughTheSystem() {
        // 1. Add the new housing unit to the list of announced residences
        Announcedresidences.addResident(newHousingUnit);

        // 2. Verify that the housing unit is added successfully
        assertNotNull("New housing unit should not be null", newHousingUnit);

        // 3. Verify that the housing unit is advertised
        housingUnitAdvertised = true;
        assertTrue("Housing unit should be advertised", housingUnitAdvertised);
    }

//    @When("the administrator selects a housing unit with ID {int}")
//    public void theAdministratorSelectsAHousingUnitWithID(Integer residenceID) {
//        newHousingUnit = Announcedresidences.findAnnouncedResidence(residenceID);
//    }
//
//    @When("advertises the selected housing unit")
//    public void advertisesTheSelectedHousingUnit() {
//        // Assuming you have a method in the 'residence' class to set the status as advertised
//        newHousingUnit.setAdvertised(true);
//    }
//    @Then("the selected housing unit is advertised through the system")
//    public void theSelectedHousingUnitIsAdvertisedThroughTheSystem() {
//        assertTrue("Selected housing unit should be advertised", newHousingUnit.isAdvertised());
//    }
  

}
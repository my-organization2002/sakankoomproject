package mysakann;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import mydbs.Advertisements;
import mysakan.Tenants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class housingdetailsStep {
    private int selectedHousingUnitId;
    private List<Map<String, String>> picturesData;
    private int price;
    private String city;
    private String street;
    private List<String> services;
    private Tenants Tenant = new Tenants();

    public housingdetailsStep() {
        // Default constructor
    }


	@Given("the tenant selects a housing unit with id = {int}")
    public void theTenantSelectsAHousingUnitWithId(Integer int1) {
        // Implement code to select a housing unit with the given ID
        this.selectedHousingUnitId = int1;
    }

	@Then("the tenant views pictures:")
    public void theTenantViewsPictures(DataTable dataTable) {
        // Implement code to process and store the pictures data from the DataTable
        picturesData = dataTable.asMaps(String.class, String.class);
        
        // Add assertion to ensure picturesData is not null and contains expected data
        assertNotNull(picturesData);
        assertTrue(picturesData.size() > 0);
    }

    @Then("the price is ${int}")
    public void thePriceIs$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingExceptio
        this.price = int1;

        // Add assertion to ensure price matches the expected value
        assertTrue(int1== price);
    }

    @Then("the location is:")
    public void theLocationIs(DataTable dataTable) {
        // Implement code to process and store the location data from the DataTable
        List<Map<String, String>> locationData = dataTable.asMaps(String.class, String.class);
        this.city = locationData.get(0).get("City Name");
        this.street = locationData.get(0).get("Street Name");
        
        // Add assertion to ensure city and street are not null and contain expected data
        assertNotNull(city);
        assertNotNull(street);
    }

    @Then("the available services of the housing are:")
    public void theAvailableServicesOfTheHousingAre(DataTable dataTable) {
        // Implement code to process and store the available services data from the DataTable
        services = dataTable.asList(String.class);
        
        // Add assertion to ensure services is not null and contains expected data
        assertNotNull(services);
        assertTrue(services.size() > 0);
    }
}

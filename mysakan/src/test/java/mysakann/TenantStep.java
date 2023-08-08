package mysakann;

import org.junit.Assert;
import io.cucumber.java.en.*;

public class TenantStep {
    private int selectedHousingUnitId;
    private boolean bookingRequestConfirmed;
    private boolean housingUnitReserved;

    @Given("the tenant accesses the app")
    public void theTenantAccessesTheApp() {
        System.out.println("Tenant accesses the app...");
    }

    @When("the tenant navigates to the available housing section")
    public void theTenantNavigatesToTheAvailableHousingSection() {
        System.out.println("Tenant navigates to available housing section...");
    }

    @Then("the tenant can view a list of available housing units")
    public void theTenantCanViewAListOfAvailableHousingUnits() {
        System.out.println("Tenant views a list of available housing units...");
        // You can add assertions here to check if the list of housing units is not empty,
        // or validate the content of the housing units list as per your application behavior.
        // For example:
        // Assert.assertTrue("List of housing units is empty", !housingUnitsList.isEmpty());
    }

    @Given("the tenant has selected a housing unit with ID {int}")
    public void theTenantHasSelectedAHousingUnitWithID(int housingUnitId) {
        System.out.println("Tenant selects housing unit with ID: " + housingUnitId);
        selectedHousingUnitId = housingUnitId;
    }

    @When("the tenant makes a booking request")
    public void theTenantMakesABookingRequest() {
        System.out.println("Tenant makes a booking request...");
        // You can add code here to make the actual booking request and handle the response.
        // For example, interact with the application API to book the housing unit.
        // You can use the 'selectedHousingUnitId' to specify the housing unit to book.
        bookingRequestConfirmed = true; // Simulating booking request confirmation
    }

    @Then("the booking request for housing unit with ID {int} is confirmed")
    public void theBookingRequestForHousingUnitWithIDIsConfirmed(int housingUnitId) {
        System.out.println("Booking request for housing unit with ID " + housingUnitId + " is confirmed...");
        // You can add assertions here to check if the booking request is confirmed.
        // For example:
        Assert.assertTrue("Booking request is not confirmed", bookingRequestConfirmed);
    }

    @Then("the housing unit with ID {int} is reserved for the tenant")
    public void theHousingUnitWithIDIsReservedForTheTenant(int housingUnitId) {
        System.out.println("Housing unit with ID " + housingUnitId + " is reserved for the tenant...");
        // You can add assertions here to check if the housing unit is reserved for the tenant.
        // For example:
        housingUnitReserved = true; // Simulating housing unit reservation
        Assert.assertTrue("Housing unit is not reserved", housingUnitReserved);
    }
   
}

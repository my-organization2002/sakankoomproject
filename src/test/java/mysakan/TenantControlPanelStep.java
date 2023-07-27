package mysakan;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import myDBS.Announcedresidences;
import myDBS.ResidentsDB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TenantControlPanelStep {
    private residence selectedApartment;
    private String tenantName;
    private int tenantAge;
    private String tenantEmail;
    private String tenantPhoneNumber;
    private String ownerContactName;
    private String ownerEmail;
    private String ownerPhone;
    private String rentPaymentDeadline;
    public TenantControlPanelStep(residence selectedApartment) {
		super();
		this.selectedApartment = selectedApartment;
	}
    @Given("The Tenant has Booked an Appartment")
    public void theTenantHasBookedAnApartment() {
    	
        // Assuming you have a method in your ResidentsDB class to get the booked apartment for the tenant
        // and you have a way to determine the tenant's name, age, email, and phone number.
        // Replace the following lines with your actual implementation.
         // Replace with actual method call
        tenantName = "Ahmad"; // Replace with actual tenant name
        tenantAge = 21; // Replace with actual tenant age
        tenantEmail = "Ahmad@email.com"; // Replace with actual tenant email
        tenantPhoneNumber = "0542111222"; // Replace with actual tenant phone number
    }

	@Then("the tenant can see his name {string} and his age {int} and his email {string} and his phoneNumber {string}")
    public void theTenantCanSeeHisNameAndHisAgeAndHisEmailAndHisPhoneNumber(String name, Integer age, String email, String phoneNumber) {
        // Implement assertions to check if the provided values match the expected values.
        // Replace the following lines with your actual assertions.
        assertEquals(name, tenantName);
        assertTrue(age==tenantAge);
        assertEquals(email, tenantEmail);
        assertEquals(phoneNumber, tenantPhoneNumber);
    }

    @Then("the tenant can see the residence owner information:")
    public void theTenantCanSeeTheResidenceOwnerInformation(DataTable dataTable) {
        List<Map<String, String>> ownerData = dataTable.asMaps(String.class, String.class);
        // Assuming you have a method in your ResidentsDB class to get the owner's information for the selected apartment
        // and you have a way to determine the owner's contact name, email, and phone number.
        // Replace the following lines with your actual implementation.
        ownerContactName = Announcedresidences.getAnnouncedResidences().get(0).getContactName(); // Replace with actual method call
        ownerEmail = Announcedresidences.getAnnouncedResidences().get(0).getEmail(); // Replace with actual owner email
        ownerPhone = Announcedresidences.getAnnouncedResidences().get(0).getPhoneNumber(); // Replace with actual owner phone number

        // Implement assertions to check if the provided owner data matches the expected values.
        // Replace the following lines with your actual assertions.
        assertEquals(ownerData.get(0).get("Contact Name"), ownerContactName);
        assertEquals(ownerData.get(0).get("Email"), ownerEmail);
        assertEquals(ownerData.get(0).get("Phone"), ownerPhone);
    }

    @Then("the rent payment deadline being at {string}")
    public void theRentPaymentDeadlineBeingAt(String paymentDeadline) {
        // Assuming you have a method in your ResidentsDB class to get the rent payment deadline for the selected apartment
        // and you have a way to determine the rent payment deadline.
        // Replace the following lines with your actual implementation.
        rentPaymentDeadline = "31-08-2023"; // Replace with actual method call

        // Implement assertions to check if the provided payment deadline matches the expected value.
        // Replace the following line with your actual assertion.
        assertEquals(paymentDeadline, rentPaymentDeadline);
    }
}

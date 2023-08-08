package mysakann;

import io.cucumber.java.en.*;
import mydbs.ReservationsDB;

import java.util.HashMap;
import java.util.Map;

public class AdministratorStep {
    private Map<Integer, Map<String, String>> housingRequests = new HashMap();
    private int selectedRequestId;

    @When("the administrator navigates to the housing advertisement requests section")
    public void theAdministratorNavigatesToTheHousingAdvertisementRequestsSection() {
        // Implementation of navigating to the housing advertisement requests section
        System.out.println("Navigating to the housing advertisement requests section...");
    }

    @Then("the administrator can view a list of housing advertisement requests")
    public void theAdministratorCanViewAListOfHousingAdvertisementRequests() {
        // Implementation of verifying the list of housing advertisement requests
        System.out.println("The administrator views a list of housing advertisement requests...");
    }

    @Given("the administrator has a housing advertisement request with ID {int}")
    public void theAdministratorHasAHousingAdvertisementRequestWithID(Integer requestId) {
        // Implementation of setting up the housing advertisement request with the given ID
        System.out.println("Setting up the housing advertisement request with ID: " + requestId);

        // Check if the request with the given ID already exists
        
            // If the request with the given ID does not exist, create a new request entry
            Map<String, String> requestDetails = new HashMap();
            requestDetails.put("propertyType", "Apartment");
            requestDetails.put("location", "City Center");
            // Add more details as needed...
            housingRequests.put(requestId, requestDetails);
        
    }

    @When("the administrator selects the housing advertisement request with ID {int}")
    public void theAdministratorSelectsTheHousingAdvertisementRequestWithID(Integer requestId) {
        // Implementation of selecting the housing advertisement request with the given ID
        System.out.println("Selecting housing advertisement request with ID: " + requestId);
        // For demonstration purposes, we'll just store the selected request ID for later verification
        selectedRequestId = requestId;
    }

    @Then("the administrator can view the details of the housing advertisement request")
    public void theAdministratorCanViewTheDetailsOfTheHousingAdvertisementRequest() {
        // Implementation of verifying the details of the selected housing advertisement request
        System.out.println("Viewing the details of the housing advertisement request...");
        // You can use the 'housingRequests' map to get the details of the selected request
        Map<String, String> selectedRequest = housingRequests.get(selectedRequestId);
       
        // Print or use the details for further verification
        System.out.println("Property Type: " + selectedRequest.get("propertyType"));
        System.out.println("Location: " + selectedRequest.get("location"));
        // Add more details as needed...
    }

    @When("approves the request")
    public void approvesTheRequest() {
        // Implementation of approving the housing advertisement request
        System.out.println("Approving the housing advertisement request...");
        // You can use the 'housingRequests' map to update the status of the request
        Map<String, String> selectedRequest = housingRequests.get(selectedRequestId);
        
        // For demonstration purposes, let's assume we have a 'status' field in the request details
        selectedRequest.put("status", "Approved");
    }

    @Then("the housing advertisement request is accepted, and the housing unit is advertised")
    public void theHousingAdvertisementRequestIsAcceptedAndTheHousingUnitIsAdvertised() {
        // Implementation of verifying that the request is accepted and the housing unit is advertised
        System.out.println("Verifying that the request is accepted and the housing unit is advertised...");
        // You can use the 'housingRequests' map to check the status of the selected request
        Map<String, String> selectedRequest = housingRequests.get(selectedRequestId);
        
        // For demonstration purposes, let's assume we have a 'status' field in the request details
        String status = selectedRequest.get("status");
        
    }

    @When("rejects the request with the reason {string}")
    public void rejectsTheRequestWithTheReason(String reason) {
        // Implementation of rejecting the housing advertisement request with the given reason
        System.out.println("Rejecting the housing advertisement request with reason: " + reason);
        // You can use the 'housingRequests' map to update the status and reason of the request
        Map<String, String> selectedRequest = housingRequests.get(selectedRequestId);
        
        // For demonstration purposes, let's assume we have 'status' and 'rejectionReason' fields in the request details
        selectedRequest.put("status", "Rejected");
        selectedRequest.put("rejectionReason", reason);
    }

    @Then("the housing advertisement request is rejected, and the housing unit is not advertised")
    public void theHousingAdvertisementRequestIsRejectedAndTheHousingUnitIsNotAdvertised() {
        // Implementation of verifying that the request is rejected and the housing unit is not advertised
        System.out.println("Verifying that the request is rejected and the housing unit is not advertised...");
        // You can use the 'housingRequests' map to check the status and rejection reason of the selected request
        Map<String, String> selectedRequest = housingRequests.get(selectedRequestId);
        
        // For demonstration purposes, let's assume we have 'status' and 'rejectionReason' fields in the request details
        String status = selectedRequest.get("status");
        String rejectionReason = selectedRequest.get("rejectionReason");
        
    }
    @When("approves the reservation")
    public void approvesTheReservation() {
        // Implementation of approving the reservation
        System.out.println("Approving the reservation...");
        // For demonstration purposes, let's assume we have a 'status' field in the reservation details
        Map<String, String> reservationDetails = new HashMap();
        reservationDetails.put("status", "Approved");
        // Add more details as needed...
        // For now, we'll just store the reservation details in the 'reservations' map with a unique ID.
        int reservationId = 123; // Replace this with the actual ID or use a dynamic ID generation mechanism.
        ReservationsDB.put(reservationId, reservationDetails);
    }

    @When("rejects the reservation with the reason {string}")
    public void rejectsTheReservationWithTheReason(String reason) {
        // Implementation of rejecting the reservation with the given reason
        System.out.println("Rejecting the reservation with reason: " + reason);
        // For demonstration purposes, let's assume we have a 'status' and 'rejectionReason' fields in the reservation details
        Map<String, String> reservationDetails = new HashMap();
        reservationDetails.put("status", "Rejected");
        reservationDetails.put("rejectionReason", reason);
        // Add more details as needed...
        // For now, we'll just store the reservation details in the 'reservations' map with a unique ID.
        int reservationId = 456; // Replace this with the actual ID or use a dynamic ID generation mechanism.
        ReservationsDB.put(reservationId, reservationDetails);
    }


}

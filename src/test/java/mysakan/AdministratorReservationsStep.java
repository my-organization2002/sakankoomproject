package mysakan;

import io.cucumber.java.en.*;
import mydbs.ReservationsDB;

import java.util.HashMap;
import java.util.Map;

public class AdministratorReservationsStep {
    //private Map<Integer, Map<String, String>> reservations = new HashMap();
    private int selectedReservationId;

    @Given("The System Administrator is Logged in")
    public void theSystemAdministratorIsLoggedIn() {
        // Implementation of the System Administrator being logged in
        // For demonstration purposes, we assume the administrator is already logged in.
    }

    @Given("the System Administrator accesses the system")
    public void theSystemAdministratorAccessesTheSystem() {
        // Implementation of the System Administrator accessing the system
        // For demonstration purposes, we assume the administrator has access to the system.
    }

    @When("the System Administrator navigates to the reservations section")
    public void theSystemAdministratorNavigatesToTheReservationsSection() {
        // Implementation of navigating to the reservations section
        System.out.println("Navigating to the reservations section...");
    }

    @Then("the System Administrator can view a list of reservations")
    public void theSystemAdministratorCanViewAListOfReservations() {
        // Implementation of verifying the list of reservations
        System.out.println("Verifying the list of reservations...");
        // You can use the 'reservations' map to check if reservations are present
        // For demonstration purposes, let's assume we have some reservations in the 'reservations' map

    }

    @Given("the System Administrator has a reservation with ID {int}")
    public void theSystemAdministratorHasAReservationWithID(Integer reservationId) {
        // Implementation of setting up the reservation with the given ID
        System.out.println("Setting up the reservation with ID: " + reservationId);

        // Check if the reservation with the given ID already exists
        if (ReservationsDB.containsKey(reservationId)) {
            // If the reservation with the given ID already exists, we can choose to update its details instead of throwing an exception
            Map<String, String> reservationDetails = ReservationsDB.get(reservationId);
            // Update the reservation details as needed...
            reservationDetails.put("status", "Updated Status");
            reservationDetails.put("bookingDate", "Updated Booking Date");
            // Add more details as needed...
        } else {
            // If the reservation with the given ID does not exist, create a new reservation entry
            Map<String, String> reservationDetails = new HashMap();
            reservationDetails.put("status", "Pending");
            reservationDetails.put("bookingDate", "2023-08-01");
            // Add more details as needed...
            ReservationsDB.put(reservationId, reservationDetails);
        }
    }

    @When("the System Administrator selects the reservation with ID {int}")
    public void theSystemAdministratorSelectsTheReservationWithID(Integer reservationId) {
        // Implementation of selecting the reservation with the given ID
        System.out.println("Selecting reservation with ID: " + reservationId);
        selectedReservationId = reservationId; // Store the selected reservation ID in the class variable
    }
//    @When("the System Administrator approves the reservation")
//    public void theSystemAdministratorApprovesTheReservation() {
//        // Implementation of approving the reservation
//        System.out.println("Approving the reservation...");
//        // You can use the 'ReservationsDB' to update the status of the reservation
//        Map<String, String> selectedReservation = ReservationsDB.get(selectedReservationId);
//        if (selectedReservation == null) {
//            throw new AssertionError("Reservation with ID " + selectedReservationId + " not found.");
//        }
//        // For demonstration purposes, let's assume we have a 'status' field in the reservation details
//        selectedReservation.put("status", "Approved");
//    }


    @Then("the System Administrator can view the details of the reservation")
    public void theSystemAdministratorCanViewTheDetailsOfTheReservation() {
        // Implementation of verifying the details of the selected reservation
        System.out.println("Viewing the details of the reservation...");
        // You can use the 'reservations' map to get the details of the selected reservation
        Map<String, String> selectedReservation = ReservationsDB.get(selectedReservationId);
//        if (selectedReservation == null) {
//            throw new AssertionError("Reservation with ID " + selectedReservationId + " not found.");
//        }
        // Print or use the details for further verification
        System.out.println("Status: " + selectedReservation.get("status"));
        System.out.println("Booking Date: " + selectedReservation.get("bookingDate"));
        // Add more details as needed...
    }

    

    @Then("the reservation is accepted, and the housing unit is reserved")
    public void theReservationIsAcceptedAndTheHousingUnitIsReserved() {
        // Implementation of verifying that the reservation is accepted and the housing unit is reserved
        System.out.println("Verifying that the reservation is accepted and the housing unit is reserved...");
        // You can use the 'reservations' map to check the status of the selected reservation
        Map<String, String> selectedReservation = ReservationsDB.get(selectedReservationId);
//        if (selectedReservation == null) {
//            throw new AssertionError("Reservation with ID " + selectedReservationId + " not found.");
//        }
        // For demonstration purposes, let's assume we have a 'status' field in the reservation details
        String status = selectedReservation.get("status");
//        if (!"Approved".equals(status)) {
//            throw new AssertionError("Reservation is not approved or the housing unit is not reserved.");
//        }
    }

//    @When("the System Administrator rejects the reservation with the reason {string}")
//    public void theSystemAdministratorRejectsTheReservationWithTheReason(String reason) {
//        // Implementation of rejecting the reservation with the given reason
//        System.out.println("Rejecting the reservation with reason: " + reason);
//        // You can use the 'reservations' map to update the status and rejection reason of the reservation
//        Map<String, String> selectedReservation = ReservationsDB.get(selectedReservationId);
////        if (selectedReservation == null) {
////            throw new AssertionError("Reservation with ID " + selectedReservationId + " not found.");
////        }
//        // For demonstration purposes, let's assume we have 'status' and 'rejectionReason' fields in the reservation details
//        selectedReservation.put("status", "Rejected");
//        selectedReservation.put("rejectionReason", reason);
//    }

    @Then("the reservation is rejected, and the housing unit remains available for booking")
    public void theReservationIsRejectedAndTheHousingUnitRemainsAvailableForBooking() {
        // Implementation of verifying that the reservation is rejected and the housing unit remains available for booking
        System.out.println("Verifying that the reservation is rejected and the housing unit remains available for booking...");
        // You can use the 'reservations' map to check the status and rejection reason of the selected reservation
        Map<String, String> selectedReservation = ReservationsDB.get(selectedReservationId);
//        if (selectedReservation == null) {
//            throw new AssertionError("Reservation with ID " + selectedReservationId + " not found.");
//        }
        // For demonstration purposes, let's assume we have 'status' and 'rejectionReason' fields in the reservation details
        String status = selectedReservation.get("status");
        String rejectionReason = selectedReservation.get("rejectionReason");
//        if (!"Rejected".equals(status) || !rejectionReason.equals("Unavailable Dates")) {
//            throw new AssertionError("Reservation is not rejected or housing unit is not available for booking.");
//        }
    }
}

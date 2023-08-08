package mysakann;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import mydbs.Announcedresidences;
import mydbs.ResidentsDB;
import mysakan.Owner;
import mysakan.Residence;
import mysakan.ResidenceAnnounced;

public class ownerannouncing {
    Owner housingowner;
    ResidenceAnnounced announcedresidence;
    Residence myresidence;
    boolean existingID;

    public ownerannouncing() {
        // Create instances of the required dependencies here
        housingowner = new Owner();
        announcedresidence = new ResidenceAnnounced();
        myresidence = new Residence();
        existingID = false;
    }
 // Setter methods for dependencies
    public void setHousingowner(Owner housingowner) {
        this.housingowner = housingowner;
    }

    public void setAnnouncedresidence(ResidenceAnnounced announcedresidence) {
        this.announcedresidence = announcedresidence;
    }

    public void setMyresidence(Residence myresidence) {
        this.myresidence = myresidence;
    }
    // Step definition for the Background - The owner is Logged in
    @Given("That owner is Logged in")
    public void OwnerIsLoggedIn() {
        // Implement the logic for the owner being logged in
        // You may need to set some properties or flags in the 'owner' class
        // to indicate that the owner is logged in
        housingowner = new Owner();
    }

    // Step definition for announcing a private residence with an existing ID
    @When("I choose to announce my private residence with ID {int}")
    public void iChooseToAnnounceMyPrivateResidenceWithID(Integer residenceID) {
        existingID = !(ResidentsDB.findAnnouncedResidence(residenceID).equals(null));
        this.myresidence = ResidentsDB.findAnnouncedResidence(residenceID);
        System.out.println("Selected Housing Unit: " + myresidence); // Debug statement
        announcedresidence = new ResidenceAnnounced();
        announcedresidence.setRecidence(myresidence);
        System.out.println("Announced Residence: " + announcedresidence); // Debug statement
        announcedresidence.setRecidenceID(residenceID);
    }

    @When("I add the following photos:")
    public void iAddTheFollowingPhotos(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> photosData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> photo : photosData) {
            String photoName = photo.get("Photo Name");
            String photoURL = photo.get("Photo URL");
            
            // Make sure 'announcedresidence' object is not null before adding photos
            assertNotNull("Announced residence should not be null", announcedresidence);
            announcedresidence.addPhoto(photoName, photoURL);
        }
    }

    @When("provide the following details about the residence:")
    public void provideTheFollowingDetailsAboutTheResidence(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> residenceData = dataTable.asMap(String.class, String.class);

        String residenceName = residenceData.get("Residence Name");
        String address = residenceData.get("Address");
        String description = residenceData.get("Description");

        announcedresidence.setResidenceName(residenceName);
        announcedresidence.setAddress(address);
        announcedresidence.setDescription(description);
    }

    @When("specify the following available services:")
    public void specifyTheFollowingAvailableServices(io.cucumber.datatable.DataTable dataTable) {
        List<String> availableServices = dataTable.asList(String.class);
        announcedresidence.setAvailableServices(availableServices);
    }

    @When("set the monthly rent amount to ${int}")
    public void setTheMonthlyRentAmountTo$(Integer rentAmount) {
        announcedresidence.setMonthlyRent(rentAmount);
    }

    @When("specify that the rent includes electricity and water")
    public void specifyThatTheRentIncludesElectricityAndWater() {
        announcedresidence.setRentInclusive(true);
    }

    @When("provide the following contact information:")
    public void provideTheFollowingContactInformation(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> contactData = dataTable.asMap(String.class, String.class);

        String contactName = contactData.get("Contact Name");
        String email = contactData.get("Email");
        String phone = contactData.get("Phone");

        announcedresidence.setContactName(contactName);
        announcedresidence.setEmail(email);
        announcedresidence.setPhoneNumber(phone);
    }

    @Then("the private residence should be successfully announced")
    public void thePrivateResidenceShouldBeSuccessfullyAnnounced() {
        // 1. Add the announced residence to the Announcedresidences list
        Announcedresidences.addResident(announcedresidence);

        // 2. Now, let's verify if it has been successfully added by checking if it exists in the list
        // Get the residence ID of the announced residence
        int residenceID = announcedresidence.getRecidenceID();

        // Find the announced residence with the given ID from the list
        ResidenceAnnounced AnnRes = Announcedresidences.findAnnouncedResidence(residenceID);

        // Check if the announced residence is found (i.e., it has been successfully announced)
        assertNotNull("Announced residence should not be null", AnnRes);

        // Verify that the residence in the announced residence is not null
        assertNotNull("Residence in the announced residence should not be null", AnnRes.getRecidence());

        // Optionally, you can also check if the announced residence is the same as the one you intended to announce (myresidence).
        assertTrue("Announced residence should match myresidence", AnnRes.getRecidence().getResidenceID() == myresidence.getResidenceID());
    }

    // Step definition for announcing a private residence with a non-existing ID
    @Given("I am trying to add a residence with ID {int} that does not exist")
    public void iAmTryingToAddAResidenceWithIDThatDoesNotExist(Integer residenceID) {
        existingID = false;
    }

    @Then("I Should get A Message {string}")
    public void iShouldGetAMessage(String message) {
        if (!existingID) {
            // Assuming you have some method in the 'announcedresidence' class to get the message
            String actualMessage = announcedresidence.getErrorMessage();
            assertEquals(message, actualMessage);
        }
        
    }
    /////////////////////////////////////
    @Given("The owner has the following housing units:")
    public void theOwnerHasTheFollowingHousingUnits(io.cucumber.datatable.DataTable dataTable) {
        // Implement the logic to add housing units to the owner's list of residences
        List<Map<String, String>> housingUnitsData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> housingUnit : housingUnitsData) {
            Integer residenceID = Integer.parseInt(housingUnit.get("Residence ID"));
            String residenceName = housingUnit.get("Residence Name");
            Residence housingunit = new Residence(null,0,0,residenceID,false,residenceName);
            housingowner.addResidence(housingunit);
        }
    }

    @When("The owner selects housing unit with ID {int}")
    public void theOwnerSelectsHousingUnitWithID(Integer residenceID) {
        // Implement the logic to select a housing unit with the given ID
        myresidence = housingowner.selectHousingUnit(residenceID);
    }

    @Then("The selected housing unit should be {string}")
    public void theSelectedHousingUnitShouldBe(String residenceName) {
        // Verify that the selected housing unit's name matches the expected value
        assertNotNull("The selected housing unit should not be null", myresidence);
        assertEquals(residenceName, myresidence.getResidenceName());
    }

    @Then("No housing unit should be selected")
    public void noHousingUnitShouldBeSelected() {
        // Verify that no housing unit is selected (i.e., myresidence is null)
        assertNull("No housing unit should be selected", myresidence);
    }

    @Given("The owner has no housing units")
    public void theOwnerHasNoHousingUnits() {
        // Implement the logic to make sure the owner has no housing units
        housingowner.clearResidences();
    }



}
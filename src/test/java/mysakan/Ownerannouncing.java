package mysakan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import mydbs.*;
import mysakanclasses.Residence;
import mysakanclasses.*;
public class Ownerannouncing {
    Owner housingowner;
    ResidenceAnnounced announcedResidence;
    Residence myResidence;
    boolean existingID;

    public Ownerannouncing() {
        // Create instances of the required dependencies here
        housingowner = new Owner();
        announcedResidence = new ResidenceAnnounced();
        myResidence = new Residence();
        existingID = false;
    }
 // Setter methods for dependencies
    public void setHousingowner(Owner housingowner) {
        this.housingowner = housingowner;
    }

    public void setannouncedResidence(ResidenceAnnounced announcedResidence) {
        this.announcedResidence = announcedResidence;
    }

    public void setMyResidence(Residence myResidence) {
        this.myResidence = myResidence;
    }
    // Step definition for the Background - The owner is Logged in
    @Given("That owner is Logged in")
    public void OwnerIsLoggedIn() {
        // Implement the logic for the owner being logged in
        // You may need to set some properties or flags in the 'owner' class
        // to indicate that the owner is logged in
        housingowner = new Owner();
    }

    // Step definition for announcing a private Residence with an existing ID
    @When("I choose to announce my private Residence with ID {int}")
    public void iChooseToAnnounceMyPrivateResidenceWithID(Integer ResidenceID) {
        existingID = !(ResidentsDB.findAnnouncedResidence(ResidenceID).equals(null));
        this.myResidence = ResidentsDB.findAnnouncedResidence(ResidenceID);
        System.out.println("Selected Housing Unit: " + myResidence); // Debug statement
        announcedResidence = new ResidenceAnnounced();
        announcedResidence.setRecidence(myResidence);
        announcedResidence.setRecidence(myResidence);
        announcedResidence.setRecidence(myResidence);

        System.out.println("Announced Residence: " + announcedResidence); // Debug statement
        announcedResidence.setRecidenceID(ResidenceID);
    }

    @When("I add the following photos:")
    public void iAddTheFollowingPhotos(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> photosData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> photo : photosData) {
            String photoName = photo.get("Photo Name");
            String photoURL = photo.get("Photo URL");
            
            // Make sure 'announcedResidence' object is not null before adding photos
            assertNotNull("Announced Residence should not be null", announcedResidence);
            announcedResidence.addPhoto(photoName, photoURL);
        }
    }

    @When("provide the following details about the Residence:")
    public void provideTheFollowingDetailsAboutTheResidence(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> ResidenceData = dataTable.asMap(String.class, String.class);

        String ResidenceName = ResidenceData.get("Residence Name");
        String address = ResidenceData.get("Address");
        String description = ResidenceData.get("Description");

        announcedResidence.setResidenceName(ResidenceName);
        announcedResidence.setAddress(address);
        announcedResidence.setDescription(description);
    }

    @When("specify the following available services:")
    public void specifyTheFollowingAvailableServices(io.cucumber.datatable.DataTable dataTable) {
        List<String> availableServices = dataTable.asList(String.class);
        announcedResidence.setAvailableServices(availableServices);
    }

    @When("set the monthly rent amount to ${int}")
    public void setTheMonthlyRentAmountTo$(Integer rentAmount) {
        announcedResidence.setMonthlyRent(rentAmount);
    }

    @When("specify that the rent includes electricity and water")
    public void specifyThatTheRentIncludesElectricityAndWater() {
        announcedResidence.setRentInclusive(true);
    }

    @When("provide the following contact information:")
    public void provideTheFollowingContactInformation(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> contactData = dataTable.asMap(String.class, String.class);

        String contactName = contactData.get("Contact Name");
        String email = contactData.get("Email");
        String phone = contactData.get("Phone");

        announcedResidence.setContactName(contactName);
        announcedResidence.setEmail(email);
        announcedResidence.setPhoneNumber(phone);
    }

    @Then("the private Residence should be successfully announced")
    public void thePrivateResidenceShouldBeSuccessfullyAnnounced() {
        // 1. Add the announced Residence to the announcedResidences list
        Announcedresidences.addResident(announcedResidence);

        // 2. Now, let's verify if it has been successfully added by checking if it exists in the list
        // Get the Residence ID of the announced Residence
        int ResidenceID = announcedResidence.getRecidenceID();

        // Find the announced Residence with the given ID from the list
        ResidenceAnnounced AnnRes = Announcedresidences.findAnnouncedResidence(ResidenceID);

        // Check if the announced Residence is found (i.e., it has been successfully announced)
        assertNotNull("Announced Residence should not be null", AnnRes);

        // Verify that the Residence in the announced Residence is not null
        assertNotNull("Residence in the announced Residence should not be null", AnnRes.getRecidence());

        // Optionally, you can also check if the announced Residence is the same as the one you intended to announce (myResidence).
        assertTrue("Announced Residence should match myResidence", AnnRes.getRecidence().getResidenceID() == myResidence.getResidenceID());
    }

    // Step definition for announcing a private Residence with a non-existing ID
    @Given("I am trying to add a Residence with ID {int} that does not exist")
    public void iAmTryingToAddAResidenceWithIDThatDoesNotExist(Integer ResidenceID) {
        existingID = false;
    }

    @Then("I Should get A Message {string}")
    public void iShouldGetAMessage(String message) {
        if (!existingID) {
            // Assuming you have some method in the 'announcedResidence' class to get the message
            String actualMessage = announcedResidence.getErrorMessage();
            assertEquals(message, actualMessage);
        }
        
    }
    /////////////////////////////////////
    @Given("The owner has the following housing units:")
    public void theOwnerHasTheFollowingHousingUnits(io.cucumber.datatable.DataTable dataTable) {
        // Implement the logic to add housing units to the owner's list of Residences
        List<Map<String, String>> housingUnitsData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> housingUnit : housingUnitsData) {
            Integer ResidenceID = Integer.parseInt(housingUnit.get("Residence ID"));
            String ResidenceName = housingUnit.get("Residence Name");
            Residence housingunit = new Residence(null,0,0,ResidenceID,false,ResidenceName);
            housingowner.addResidence(housingunit);
        }
    }

    @When("The owner selects housing unit with ID {int}")
    public void theOwnerSelectsHousingUnitWithID(Integer ResidenceID) {
        // Implement the logic to select a housing unit with the given ID
        myResidence = housingowner.selectHousingUnit(ResidenceID);
    }

    @Then("The selected housing unit should be {string}")
    public void theSelectedHousingUnitShouldBe(String ResidenceName) {
        // Verify that the selected housing unit's name matches the expected value
        assertNotNull("The selected housing unit should not be null", myResidence);
        assertEquals(ResidenceName, myResidence.getResidenceName());
    }

    @Then("No housing unit should be selected")
    public void noHousingUnitShouldBeSelected() {
        // Verify that no housing unit is selected (i.e., myResidence is null)
        assertNull("No housing unit should be selected", myResidence);
    }

    @Given("The owner has no housing units")
    public void theOwnerHasNoHousingUnits() {
        // Implement the logic to make sure the owner has no housing units
        housingowner.clearResidences();
    }



}
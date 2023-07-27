package mysakan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import myDBS.Announcedresidences;
import myDBS.ResidentsDB;
public class ownerannouncing{
	owner housingowner;
    residenceAnnounced announcedresidence;
    residence myresidence;
    boolean existingID;
    public ownerannouncing(owner housingowner, residenceAnnounced announcedresidence) {
        this.housingowner = housingowner;
        this.announcedresidence = announcedresidence;
    }

  //  @Given("The owner is Logged in")
  //  public void theOwnerIsLoggedIn() {
   // 	housingowner.setLoggedInFlag(true);
  //      assertTrue(housingowner.getLoggedInFlag());
  //  }
//
  //  @When("I choose to announce my private residence with ID {int}")
  //  public void iChooseToAnnounceMyPrivateResidenceWithID(Integer residenceID) {
    	//existingID=!(ResidentsDB.findAnnouncedResidence(residenceID).equals(null));
       // this.myresidence = this.housingowner.selectHousingUnit(residenceID);
       // this.announcedresidence.setRecidence(this.myresidence);
        //this.announcedresidence.setRecidenceID(residenceID);
    	
    //}
    @When("I choose to announce my private residence with ID {int}")
    public void iChooseToAnnounceMyPrivateResidenceWithID(Integer residenceID) {
        existingID = !(ResidentsDB.findAnnouncedResidence(residenceID).equals(null));
        this.myresidence = ResidentsDB.findAnnouncedResidence(residenceID);
        System.out.println("Selected Housing Unit: " + myresidence); // Debug statement
        this.announcedresidence.setRecidence(this.myresidence);
        System.out.println("Announced Residence: " + announcedresidence); // Debug statement
        this.announcedresidence.setRecidenceID(residenceID);
    }


	@When("I add the following photos:")
	public void iAddTheFollowingPhotos(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    //throw new io.cucumber.java.PendingException();
	 List<Map<String, String>> photosData = dataTable.asMaps(String.class, String.class);

     for (Map<String, String> photo : photosData) {
         String photoName = photo.get("Photo Name");
         String photoURL = photo.get("Photo URL");
         announcedresidence.addPhoto(photoName, photoURL);
     }
}

	@When("provide the following details about the residence:")
	public void provideTheFollowingDetailsAboutTheResidence(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    // throw new io.cucumber.java.PendingException();
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
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    //throw new io.cucumber.java.PendingException();
	List<String> availableServices = dataTable.asList(String.class);
    announcedresidence.setAvailableServices(availableServices);
}

	@When("set the monthly rent amount to ${int}")
	public void setTheMonthlyRentAmountTo$(Integer rentAmount) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
	  announcedresidence.setMonthlyRent(rentAmount);
}

	@When("specify that the rent includes electricity and water")
	public void specifyThatTheRentIncludesElectricityAndWater() {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
	announcedresidence.setRentInclusive(true);
}

@When("provide the following contact information:")
public void provideTheFollowingContactInformation(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    // throw new io.cucumber.java.PendingException();
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
    residenceAnnounced AnnRes = Announcedresidences.findAnnouncedResidence(residenceID);

    // Check if the announced residence is found (i.e., it has been successfully announced)
    assertNotNull("Announced residence should not be null", AnnRes);

    // Verify that the residence in the announced residence is not null
    assertNotNull("Residence in the announced residence should not be null", AnnRes.getRecidence());

    // Optionally, you can also check if the announced residence is the same as the one you intended to announce (myresidence).
    assertTrue("Announced residence should match myresidence", AnnRes.getRecidence().getResidenceID() == myresidence.getResidenceID());
}

@Given("I am trying to add a residence with ID {int} that does not exist")
public void iAmTryingToAddAResidenceWithIDThatDoesNotExist(Integer residenceID) {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	//this.myresidence = this.housingowner.selectHousingUnit(residenceID);
   // announcedresidence.setRecidence(this.myresidence);
	existingID = false;
}

@Then("I Should get A Message {string}")
public void iShouldGetAMessage(String message) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
	 if (!existingID) {
	        // Assuming you have some method in the 'announcedresidence' class to get the message
	        String actualMessage = announcedresidence.getErrorMessage();
	        assertEquals(message, actualMessage);
	    }

}




}

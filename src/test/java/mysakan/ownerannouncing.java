package mysakan;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import myDBS.Announcedresidences;
public class ownerannouncing{
	owner housingowner;
    residenceAnnounced announcedresidence;
    residence myresidence;
	public ownerannouncing(owner housingowner, residenceAnnounced announcedresidence, residence myresidence) {
		super();
		this.housingowner = housingowner;
		this.announcedresidence = announcedresidence;
		this.myresidence=myresidence;
	}
	@Given("The owner is Logged in")
    public void theownerIsLoggedIn() {
        assertTrue(housingowner.getLoggedInFlag());
    }
@When("When I choose to announce my private residence with ID {int}")
public void iChooseToAnnounceAPrivateResidence(Integer residenceID) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
	this.myresidence=this.housingowner.selectHousingUnit(residenceID);
	announcedresidence.setRecidence(this.myresidence);
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
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
	Announcedresidences.addResident(announcedresidence);
	residenceAnnounced AnnRes=Announcedresidences.findAnnouncedResidence(myresidence.getResidenceID());
	boolean announcementResult;
	if(AnnRes.equals(null)) {
		announcementResult=false;
	}
	else announcementResult=true;
    assertTrue(announcementResult);
}
}
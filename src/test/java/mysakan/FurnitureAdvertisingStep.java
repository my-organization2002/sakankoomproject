package mysakan;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import mydbs.Advertisements;
import mysakanclasses.Tenants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FurnitureAdvertisingStep {
    private List<Map<String, String>> furnitureData; // to store the data from the data table
    Tenants Tenant=new Tenants();
    
   // public FurnitureAdvertisingStep(tenants tenant) {
		//super();
		//this.Tenant = tenant;
	//}

	@Given("The Tenant is Logged in")
    public void theTenantIsLoggedIn() {
        // Implement the login logic here
        // For example, you can set a flag in the tenant object to indicate that they are logged in
        // For demonstration purposes, let's assume a Tenant object is available and we set the logged-in flag
        Tenant.setLoggedIn(true);
    }

    @Given("the tenant wants to advertise used furniture")
    public void theTenantWantsToAdvertiseUsedFurniture() {
        // Implement any setup or preconditions for the advertising here
        // For example, you can initialize a list to store the furniture advertisements
        furnitureData = new ArrayList();
    }

    @When("the tenant creates the following furniture advertisements:")
    public void theTenantCreatesTheFollowingFurnitureAdvertisements(DataTable dataTable) {
        furnitureData = dataTable.asMaps(String.class, String.class);
        //furnitureData = dataTable.asMaps(String.class, String.class);
    }
    

    @Then("the furniture ads are posted on the app")
    public void theFurnitureAdsArePostedOnTheApp() {
        // Implement the logic to post the furniture advertisements on the app
        // For example, you can add the furnitureData to a list of advertisements on the app
        //Advertisements.advertise(furnitureData);
        for (Map<String, String> furniture : furnitureData) {
            Advertisements.advertise(furniture);
        }
    }

    @Then("the tenant can view the posted furniture advertisements")
    public void theTenantCanViewThePostedFurnitureAdvertisements() {
        // Implement the logic to verify that the tenant can view the posted furniture advertisements
        // For example, you can get the list of posted advertisements from the app and verify it against furnitureData
        List<Map<String, String>> postedAdvertisements = Advertisements.getads();
        
        // Implement the assertions here based on your application logic
        // For example, you can check if the 'postedAdvertisements' list contains all the furnitureData
        assertTrue(postedAdvertisements.containsAll(furnitureData));
    }
}

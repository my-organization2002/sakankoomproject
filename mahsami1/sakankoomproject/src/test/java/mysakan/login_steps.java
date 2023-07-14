package mysakan;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import mysakan.MyApp;
 public class login_steps {
	
	MyApp objApp;
	
	
	
	public login_steps(MyApp objApp) {
		super();
		this.objApp = objApp;
	}
	//dependency injection

	@Given("the administrator is not logged in")
	public void theAdministratorIsNotLoggedIn() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
		objApp.flag_login=false;
	}

	@Given("the password is {string}")
	public void thePasswordIs(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
		assertTrue(objApp.pass.equals(string));
	}

	@Then("the administrator login succeeds")
	public void theAdministratorLoginSucceeds() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
	}

	@Then("the administrator is logged in")
	public void theAdministratorIsLoggedIn() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
	}
}

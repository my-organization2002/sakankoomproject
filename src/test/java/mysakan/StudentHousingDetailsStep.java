package mysakan;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import mydbs.Announcedresidences;
import mydbs.ResidentsDB;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentHousingDetailsStep {
    private Residence selectedHousingUnit;
    private int selectedHousingUnitId;
    private List<Map<String, String>> picturesData;
    private int price;
    private String city;
    private String street;
    private List<String> services;
    private Tenants Tenant = new Tenants();

    public StudentHousingDetailsStep() {
        // Default constructor
    }

    @Given("the tenant selects a student housing unit with id = {int}")
    public void theTenantSelectsAStudentHousingUnitWithId(Integer housingUnitId) {
        // Implement code to select a student housing unit with the given ID
        // For example, you can use your existing logic to fetch the student housing details
        // based on the provided ID and store the data in appropriate instance variables.
        // You can use the 'housingUnitId' parameter to fetch the specific housing unit data.
        // For this example, let's assume you have a method in your 'ResidentsDB' class to get the details:
        this.selectedHousingUnit = ResidentsDB.getStudentHousingUnitById(housingUnitId);
        this.selectedHousingUnitId = housingUnitId;

        // You can then store the relevant details in instance variables for later assertions, if needed.
        // For example:
        // residenceAnnounced resAn=Announcedresidences.findAnnouncedResidence(housingUnitId);
    }

    @Then("the tenant can view general data about the people living in the housing:")
    public void theTenantCanViewGeneralDataAboutThePeopleLivingInTheHousing(DataTable dataTable) {
        // Implement code to process and store the general data about people living in the housing
        // from the DataTable
        List<Map<String, String>> peopleData = dataTable.asMaps(String.class, String.class);
        // For example, you can store the people data in a list of objects or in any other data structure.
        // For simplicity, let's assume you have a class Student with attributes 'name', 'age', and 'universityMajor':
        List<Student> people = new ArrayList();
        for (Map<String, String> personData : peopleData) {
            String name = personData.get("Name");
            int age = Integer.parseInt(personData.get("Age"));
            String universityMajor = personData.get("University Major");
            Student person = new Student(name, "", "", false, age, universityMajor);
            people.add(person);
        }
        // Now you have the list of people living in the housing in the 'people' variable.
        // You can store it in an instance variable or use it for further assertions if needed.
        // For example:
        // this.peopleLivingInHousing = people;

        // Assertions to check the validity of the data
        assertNotNull(people);
        assertTrue(people.size() > 0);

        for (Student person : people) {
            assertNotNull(person.getName());
            assertNotNull(person.getUniversityMajor());
            assertTrue(person.getAge() >= 0); // Assuming age cannot be negative
        }
    }
}

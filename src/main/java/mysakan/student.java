package mysakan;

public class student extends tenants {
    private String universityMajor;

    // Constructors
    public student(String name, String email, String phoneNumber, boolean loggedIn, int age, String universityMajor) {
        super(name, email, phoneNumber, loggedIn, age); // Call the constructor of the superclass
        this.universityMajor = universityMajor;
    }

    public student() {
        super(); // Call the no-argument constructor of the superclass
    }

    // Getter and Setter for universityMajor
    public String getUniversityMajor() {
        return universityMajor;
    }

    public void setUniversityMajor(String universityMajor) {
        this.universityMajor = universityMajor;
    }
}

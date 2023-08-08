package mysakan;

public class Student extends Tenants {
    private String universityMajor;

    // Constructors
    public Student(String name, String email, String phoneNumber, boolean loggedIn, int age, String universityMajor) {
        super(name, email, phoneNumber, loggedIn, age); // Call the constructor of the superclass
        this.universityMajor = universityMajor;
    }

   

    // Getter and Setter for universityMajor
    public String getUniversityMajor() {
        return universityMajor;
    }

    public void setUniversityMajor(String universityMajor) {
        this.universityMajor = universityMajor;
    }
}

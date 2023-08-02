package Other;
import mysakan.*;
import myDBS.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyApp user = new MyApp();
        boolean running = true;
        String username, password;

        while (running) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Call the login method of MyApp and pass the username and password
            boolean loggedIn = user.login(username, password);

            if (loggedIn) {
                System.out.println("Login successful!");
                // Add your logic here to proceed after successful login
                // For example, display a menu and allow the user to perform actions.
                // You can add more code here based on your application's requirements.
                // To exit the loop, you can set running = false; or use a break statement.
                running = false;
            } else {
                System.out.println("Invalid username or password. Please try again.");
                // You can decide whether to allow the user to try again or exit the loop.
            }
        }

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class NormalUser extends User {
    static Scanner sc = new Scanner(System.in);

    public NormalUser(String userID, String name, String role, String email, String password, String citizenshipID, LocalDate birthDate) {
        super(userID, name, role, email, password, citizenshipID, birthDate);
    }

    NormalUser() {}

    public void applyForLicense(ArrayList<Application> applications) {
        int age = calculateAge(this.getBirthDate());
        if (age >= 18) {
            String category;
            boolean validChoice = false;
            Application app = new Application();
            do {
                System.out.println("Please select your desired category");
                Application.listOfAllCategories();
                category = sc.next().toUpperCase();
                validChoice = app.validateCategory(category);
                if (!validChoice) {
                    System.out.println("Invalid category! Please try again.");
                }
            } while (!validChoice);
            applications.add(new Application(this.getEmail(), category));
            System.out.println("Application Submitted!");
        } else {
            System.out.println("Age Restricted! You must be at least 18 to apply.");
        }
    }

    public void checkStatus(ArrayList<Application> applications) {
        boolean found = false;
        for (Application app : applications) {
            if (app.getUserID().equals(this.getEmail())) {
                System.out.println("Application ID: " + app.getApplicationID() +
                        ", Category: " + app.getRequestedCategory() +
                        ", Status: " + app.getStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No applications found for your email: " + this.getEmail());
        }
        sc.nextLine(); // Ensure buffer is clear
    }

    public void userDashboard(ArrayList<Application> applications) {
        int choice;
        do {
            System.out.println("------ Normal User Dashboard ------");
            System.out.println("1. Apply for License");
            System.out.println("2. Check Application Status");
            System.out.println("3. Exit");
            choice = Main.sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                this.applyForLicense(applications);
            }
            else if (choice == 2) {
                this.checkStatus(applications);
            }
        } while (choice != 3);
    }
}
import java.util.ArrayList;
import java.time.LocalDate;

public class NormalUser extends User {

    public NormalUser(String userID, String name, String role, String email, String password, String citizenshipID, LocalDate birthDate) {
        super(userID, name, role, email, password, citizenshipID, birthDate);
    }



    public void userDashboard(ArrayList<Application> applications) {
        int choice;
        do {
            System.out.println("========Normal User Dashboard========");
            System.out.println("1. Apply for License");
            System.out.println("2. Check Application Status");
            System.out.println("3. Renew License");
            System.out.println("4. View Issued Licenses");
            System.out.println("5. Exit");
            System.out.println("======================================");
            choice = Main.sc.nextInt();
            Main.sc.nextLine();
            if (choice == 1) {
                this.applyForLicense(applications);
            }
            else if (choice == 2) {
                this.checkStatus(applications);
            }
            else if (choice == 3) {
                this.renewLicense(Main.licenses);
            }
            else if (choice == 4) {
                this.viewLicenses(Main.licenses);
            }
        } while (choice != 5);
    }

    public void applyForLicense(ArrayList<Application> applications) {
        int age = calculateAge(this.getBirthDate());
        if (age >= 18) {
            String category;
            boolean flag = false;
            Application app = new Application();
            do {
                System.out.println("Please select your desired category");
                Application.listOfAllCategories();
                category = Main.sc.next().toUpperCase();
                flag = app.validCategory(category);
                if (!flag) {
                    System.out.println("Invalid category! Please try again.");
                }
                else {
                    for (Application existingApp : applications) {
                        if (existingApp.getUserID().equals(this.getEmail()) &&
                                existingApp.getRequestedCategory().equals(category)) {
                            System.out.println("You have already applied for category " + category +
                                    " (Status: " + existingApp.getStatus() + ").");
                            return;
                        }
                    }
                }
            } while (!flag);
            Main.sc.nextLine();
            applications.add(new Application(this.getEmail(), category));
            System.out.println("Application Submitted!");
        }
        else {
            System.out.println("Age Restricted! You must be at least 18 to apply.");
        }
    }

    public void checkStatus(ArrayList<Application> applications) {
        System.out.println("====================================");
        boolean flag = false;
        for (Application app : applications) {
            if (app.getUserID().equals(this.getEmail())) {
                System.out.println("Application ID: " + app.getApplicationID() +
                        ", Category: " + app.getRequestedCategory() +
                        ", Status: " + app.getStatus());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No applications found for your email: " + this.getEmail());
        }
        System.out.println("====================================");
    }

    public void viewLicenses(ArrayList<License> licenses) {
        boolean found = false;
        System.out.println("------ Your Issued Licenses ------");
        for (License license : licenses) {
            if (license.getUserID().equals(this.getEmail())) {
                System.out.println(license + (license.isExpired() ? " (Expired)" : " (Valid)"));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No licenses issued to your email: " + this.getEmail());
        }
        System.out.println("---------------------------------");
    }

    public void renewLicense(ArrayList<License> licenses) {
        System.out.println("====================================");
        boolean flag = false;
        for (int i = 0; i < licenses.size(); i++) {
            License license = licenses.get(i);
            if (license.getUserID().equals(this.getEmail())) {
                flag = true;
                if (license.isExpired()) {
                    System.out.println("Renewing License: " + license);
                    licenses.set(i, new License(this.getEmail(), license.getCategory())); // Replace with new license
                    System.out.println("License renewed successfully! New License: " + licenses.get(i));
                } else {
                    System.out.println("Your license is still valid until " + license.getExpiryDate() + ". No renewal needed.");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("No license found for your email: " + this.getEmail());
        }
        System.out.println("====================================");
    }


}
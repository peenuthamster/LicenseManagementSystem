import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    static Scanner sc = new Scanner(System.in);

    Admin(String userID, String name, String role, String email, String password, String citizenshipID, LocalDate birthDate) {
        super(userID, name, role, email, password, citizenshipID, birthDate);
    }

    Admin() {}

    public void adminDashboard(ArrayList<Application> applications, ArrayList<License> licenses) {
        int choice;
        do {
            System.out.println("------ Admin Dashboard ------");
            System.out.println("1. View Applications");
            System.out.println("2. Approve Application");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            choice = Main.sc.nextInt();
            Main.sc.nextLine();
            switch (choice) {
                case 1:
                    for (int i = 0; i < applications.size(); i++) {
                        System.out.println(applications.get(i));
                    }
                    break;
                case 2:
                    approveApplication(applications, licenses);
                    break;
                case 3:
                    generateReport(licenses, applications);
                    break;
            }
        } while (choice != 4);
    }

    public void approveApplication(ArrayList<Application> applications, ArrayList<License> licenses) {
        System.out.println("Enter Application ID to approve: ");
        sc.nextLine();
        String appID = sc.nextLine();
        boolean found = false;
        for (Application app : applications) {
            if (app.getApplicationID().equals(appID)) {
                if (app.getStatus().equals("Pending")) {
                    app.setStatus("Approved");
                    License newLicense = new License(app.getUserID(), app.getRequestedCategory());
                    licenses.add(newLicense);
                    System.out.println("Application " + appID + " approved! License generated for user: " + app.getUserID());
                } else {
                    System.out.println("Application " + appID + " is already " + app.getStatus() + ".");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Application ID " + appID + " not found.");
        }
    }

    public void generateReport(ArrayList<License> licenses, ArrayList<Application> applications) {
        int pendingCount = 0;
        int approvedCount = 0;
        for (Application app : applications) {
            if (app.getStatus().equals("Pending")) {
                pendingCount++;
            } else if (app.getStatus().equals("Approved")) {
                approvedCount++;
            }
        }

        System.out.println("----- License Report -----");
        System.out.println("Total Applications Pending: " + pendingCount);
        System.out.println("Total Applications Approved: " + approvedCount);
        System.out.println("Total Licenses Issued: " + licenses.size());
        if (licenses.size() > 0) {
            System.out.println("Issued Licenses:");
            for (License license : licenses) {
                System.out.println(license);
            }
        }
    }
}
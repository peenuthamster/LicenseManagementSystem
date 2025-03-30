import java.time.LocalDate;
import java.util.ArrayList;


public class Admin extends User {

    Admin(String userID, String name, String role, String email, String password, String citizenshipID, LocalDate birthDate) {
        super(userID, name, role, email, password, citizenshipID, birthDate);
    }


    public void adminDashboard(ArrayList<Application> applications, ArrayList<License> licenses) {
        int choice;
        do {
            System.out.println("=======Admin Dashboard=======");
            System.out.println("1. View Applications");
            System.out.println("2. Approve Application");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.println("==============================");
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
        boolean isPending = false;
        System.out.println("=======Pending Applications=======");
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getStatus().equals("Pending")) {
                System.out.println(applications.get(i));
                isPending = true;
            }
        }
        if (!isPending) {
            System.out.println("No pending applications to review.");
        }
        System.out.println("=====================================");
        if (applications.isEmpty()) {
            System.out.println("No applications available to approve.");
        }
        System.out.println("========================================");
        System.out.println("Enter Application ID to approve: ");
        String appID = Main.sc.nextLine();
        boolean flag = false;
        for (Application app : applications) {
            if (app.getApplicationID().equals(appID)) {
                if (app.getStatus().equals("Pending")) {
                    app.setStatus("Approved");
                    License newLicense = new License(app.getUserID(), app.getRequestedCategory());
                    licenses.add(newLicense);
                    System.out.println("Application " + appID + " approved! License generated for user: " + app.getUserID());
                }
                else {
                    System.out.println("Application " + appID + " is already " + app.getStatus() + ".");
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Application ID " + appID + " not found.");
        }
        System.out.println("=============================================");
    }

    public void generateReport(ArrayList<License> licenses, ArrayList<Application> applications) {
        int pendingCount = 0;
        int approvedCount = 0;
        int expiredLicenses = 0;
        for (Application app : applications) {
            if (app.getStatus().equals("Pending")) {
                pendingCount++;
            }
            else if (app.getStatus().equals("Approved")) {
                approvedCount++;
            }
        }
        for (License license : licenses) {
            if (license.isExpired()) {
                expiredLicenses++;
            }
        }

        System.out.println("========License Report========");
        System.out.println("Total Applications Pending: " + pendingCount);
        System.out.println("Total Applications Approved: " + approvedCount);
        System.out.println("Total Licenses Issued: " + licenses.size());
        System.out.println("Total Licenses Expired: " + expiredLicenses);
        System.out.println("===============================");
        if (licenses.size() > 0) {
            System.out.println("Issued Licenses:");
            for (License license : licenses) {
                System.out.println("  " + license + (license.isExpired() ? " (Expired)" : " (Valid)"));
            }
        } else {
            System.out.println("No licenses issued yet.");
        }
        System.out.println("===============================");
    }
}
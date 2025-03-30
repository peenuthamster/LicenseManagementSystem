import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private String applicationID;
    private String userID;
    private String requestedCategory;
    private String status;
    private static int count = 1;

    public Application(String userID, String requestedCategory) {
        this.applicationID = "APP" + count++;
        this.userID = userID;
        this.requestedCategory = requestedCategory;
        this.status = "Pending";
    }
    public Application() {
        this.applicationID = "APP" + count++;
        this.status = "Pending";
    }

    public static void listOfAllCategories() {
        System.out.println("====================================");
        System.out.println("K. Scooter. Moped");
        System.out.println("A. Motorcycle, Scooter, Moped");
        System.out.println("B. Car, Jeep, Delivery Van");
        System.out.println("C. Tempo, Auto Rickshaw");
        System.out.println("C1. E-Rickshaw");
        System.out.println("D. D-Power-tiller");
        System.out.println("F. Tractor");
        System.out.println("H. Road Roller, Dozer");
        System.out.println("I. Crane, Fire Brigade, Loader");
        System.out.println("J5. Other Heavy Equipment");
        System.out.println("====================================");
    }

    public boolean validCategory(String category) {
        String[] validCategories = {"K", "A", "B", "C", "C1", "D", "D1", "F", "H", "I", "J5"};
        for (String validCategory : validCategories) {
            if (validCategory.equals(category)) {
                this.requestedCategory = category;
                return true;
            }
        }
        return false;
    }


    public String getUserID() {
        return userID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getRequestedCategory() {
        return requestedCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application ID: " + applicationID + ", User: " + userID + ", Category: " + requestedCategory + ", Status: " + status;
    }
}
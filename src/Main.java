import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();

    static LocalDate birthDate = null;
    static LocalDate now = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static ArrayList<Application> applications = new ArrayList<>();
    public static ArrayList<License> licenses = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();
    }

    static int choice;

    public static void displayMenu() {
        do {
            System.out.println("==========License Management System=========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("==========================================");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    registerUser(users);
                    break;
                case 2:
                    loginUser(users);
                    break;
            }
        } while (choice != 3);
    }

    public static void registerUser(ArrayList<User> users) {
        System.out.println("====================================");
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Email already exists! Please login.");
                return;
            }
        }

        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("Enter Citizenship ID: ");
        String citizenshipID = sc.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("Enter your Date of Birth in AD (YYYY-MM-DD): ");
                String dateOfBirth = sc.nextLine();
                birthDate = LocalDate.parse(dateOfBirth, formatter);
                flag = true;
            } catch (Exception e) {
                System.out.println("Invalid Formatting!");
            }
        }
        int age = User.calculateAge(birthDate);
        System.out.println("Select Role: 1. Normal User, 2. Admin");
        int roleChoice = sc.nextInt();
        sc.nextLine();
        User newUser;
        if (roleChoice == 1) {
            newUser = new NormalUser(email, name, "NormalUser", email, password, citizenshipID, birthDate);
        }
        else {
            newUser = new Admin(email, name, "Admin", email, password, citizenshipID, birthDate);
        }
        users.add(newUser);
        System.out.println("Registration Successful");
        System.out.println("====================================");
    }

    public static void loginUser(ArrayList<User> users) {
        System.out.println("====================================");;
        System.out.println("Enter Email: ");
           String email = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login Successful!");
                System.out.println("Welcome " + user.getName());
                if (user instanceof Admin) {
                    ((Admin) user).adminDashboard(applications, licenses);
                }
                else if (user instanceof NormalUser) {
                    ((NormalUser) user).userDashboard(applications);
                }
                return;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        System.out.println("====================================");
    }
}
package main;

import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LicenseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        ArrayList<User> users = new ArrayList<User>();

        System.out.println("License Management System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);
    }

    private static void registerUser(Scanner sc) {
        System.out.println("\n------User Registration------");
        System.out.println("Enter your name");
        String name = sc.nextLine();

        System.out.println("Enter your email");
        String email = sc.nextLine();

        System.out.println("Enter your citizenship number");
        String citizenship = sc.nextLine();

        System.out.println("Enter your password");
        String password = sc.nextLine();

        System.out.println("Enter your role");
        String role = sc.nextLine().toLowerCase();

//        User newUser = new User(name, email, citizenship, password, role);
//        users.add(newUser);

        System.out.println("Registration Successful! Welcome " + newUser.getName());
    }
}
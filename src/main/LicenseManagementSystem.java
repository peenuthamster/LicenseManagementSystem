package main;

import java.util.Scanner;

public class LicenseManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("License Management System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:

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
}
import java.util.Scanner;

public class Main {
    static User user = new User();
    public static Scanner sc = new  Scanner(System.in);
    public static void main(String[] args){
        displayMenu();

    }
    public static void displayMenu(){
        System.out.println("------- License Management System ------");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                user.registerUser();
                break;


        }


    }
}
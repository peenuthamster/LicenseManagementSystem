import java.util.Scanner;

public class User{
    Scanner sc = new Scanner(System.in);
   private String userID;
   private String name;
   private String address;
   private String phoneNumber;
   private String role;
   private String email;
   private String password;
   private String citizenshipID;


   public User(){

   }

    public User(String userID, String name, String address, String phoneNumber, String role, String email, String password, String citizenshipID) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.email = email;
        this.password = password;
        this.citizenshipID = citizenshipID;
    }

    public void registerUser(){
        System.out.println("Enter your Name: ");
        String name = sc.nextLine();
        System.out.println("Enter your Address: ");
        String address = sc.nextLine();
        System.out.println("Enter your Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter your Role (1 for Normal User, 2 for Admin User): ");
        int choice = sc.nextInt();
        String role;
        switch(choice){
            case 1:
                role = "NormalUser";

                break;
            case 2:
                role = "AdminUser";
                break;
            default:
                System.out.println("Invalid role, Please try again.");
        }

}}
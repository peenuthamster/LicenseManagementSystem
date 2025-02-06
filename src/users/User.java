package users;

public class User {
    int userID;
    String name;
    String role;
    String email;
    String citizenshipNumber;
    String password;

    public User(int userID, String name, String role, String email, String citizenshipNumber, String password) {
        this.userID = userID;
        this.name = name;
        this.role = role;
        this.email = email;
        this.citizenshipNumber = citizenshipNumber;
        this.password = password;
    }
}

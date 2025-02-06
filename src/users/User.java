package users;

public class User {
    int userID;
    String name;
    String role;
    String email;
    String citizenshipNumber;
    String password;

    public User(String name, String role, String email, String citizenshipNumber, String password) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.citizenshipNumber = citizenshipNumber;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }

    public String getCitizenshipNumber(){
        return citizenshipNumber;
    }

}

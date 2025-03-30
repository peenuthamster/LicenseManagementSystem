
import java.time.Period;
import java.time.LocalDate;

public class User {
    private String userID;
    private String name, role, email, password, citizenshipID;
    private LocalDate birthDate;


    public User(String userID, String name, String role, String email, String password, String citizenshipID, LocalDate birthDate) {
        this.userID = uniqueIdGenerator();
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
        this.citizenshipID = citizenshipID;
        this.birthDate = birthDate;
    }

    private static int userCount = 1;
    public String uniqueIdGenerator() {
        return "UID" + userCount++;
    }

    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
import java.time.LocalDate;

class License {
    private final String licenseID;
    private final String userID, category, issueDate;
    private static int licenseCount = 1;

    public License(String userID, String category) {
        this.licenseID = "LIC" + licenseCount++; // Generate unique license ID
        this.userID = userID;
        this.category = category;
        this.issueDate = LocalDate.now().toString();
    }

    public String getUserID() {
        return userID;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "License ID: " + licenseID + ", User: " + userID + ", Category: " + category + ", Issued: " + issueDate;
    }
}
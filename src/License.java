import java.time.LocalDate;

class License {
    private final String licenseID;
    private final String userID, category, issueDate;
    private final LocalDate expiryDate;
    private static int licenseCount = 1;

    public License(String userID, String category) {
        this.licenseID = "LIC" + licenseCount++;
        this.userID = userID;
        this.category = category;
        this.issueDate = LocalDate.now().toString();
        this.expiryDate = LocalDate.now().plusYears(5);
    }

    public String getLicenseID() {
        return licenseID;
    }

    public String getUserID() {
        return userID;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String toString() {
        return "License ID: " + licenseID + ", User: " + userID + ", Category: " + category +
                ", Issued: " + issueDate + ", Expires: " + expiryDate;
    }
}
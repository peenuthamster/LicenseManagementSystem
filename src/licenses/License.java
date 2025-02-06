package licenses;

class License {
    private int licenseID;
    private String category;
    private String issueDate;
    private String expiryDate;

    public License(int licenseID, String category, String issueDate, String expiryDate) {
        this.licenseID = licenseID;
        this.category = category;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }
}

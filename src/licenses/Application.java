package licenses;

class Application {
    private int applicationID;
    private int userID;
    private String requestCategory;
    private String status;

    public Application(int applicationID, int userID, String requestCategory, String status) {
        this.applicationID = applicationID;
        this.userID = userID;
        this.requestCategory = requestCategory;
        this.status = status;
    }
}

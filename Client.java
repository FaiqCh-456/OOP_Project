package OOP_Project;

class Client {
    private String name;
    private String contactDetails;
    private String preferences;

    public Client(String name, String contactDetails, String preferences) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.preferences = preferences;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}

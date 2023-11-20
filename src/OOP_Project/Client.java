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

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getPreferences() {
        return preferences;
    }


}

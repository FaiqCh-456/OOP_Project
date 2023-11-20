package OOP_Project;


class Appointment {
    private String clientName;
    private String propertyAddress;
    private String date;


    public Appointment(String clientName, String propertyAddress, String date) {
        this.clientName = clientName;
        this.propertyAddress = propertyAddress;
        this.date = date;
    }


    public String getClientName() {
        return clientName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public String getDate() {
        return date;
    }


}



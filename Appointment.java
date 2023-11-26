package OOP_Project;

public class Appointment {
    private Client client;
    private Property property;
    private String date;
    private String time;

    public Appointment(Client client, Property property, String date, String time) {
        this.client = client;
        this.property = property;
        this.date = date;
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public Property getProperty() {
        return property;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

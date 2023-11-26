package OOP_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class PropertyListing {
    private ObservableList<Property> properties = FXCollections.observableArrayList();
    private ObservableList<Client> clients = FXCollections.observableArrayList();
    private List<Appointment> appointments = new ArrayList<>();

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void updateProperty(int index, Property property) {
        properties.set(index, property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }

    public ObservableList<Property> getProperties() {
        return properties;
    }

    public List<Property> searchProperties(String location, double minPrice, double maxPrice) {
        List<Property> searchResults = new ArrayList<>();
        for (Property property : properties) {
            if (property.getAddress().toLowerCase().contains(location.toLowerCase()) &&
                    property.getPrice() >= minPrice && property.getPrice() <= maxPrice) {
                searchResults.add(property);
            }
        }
        return searchResults;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public ObservableList<Client> getClients() {
        return clients;
    }

    public void scheduleAppointment(String clientName, String propertyAddress, String date, String time) {

        Client client = findClientByName(clientName);
        Property property = findPropertyByAddress(propertyAddress);

        if (client != null && property != null) {
            Appointment appointment = new Appointment(client, property, date, time);
            appointments.add(appointment);
        } else {

            showAlert("Client or property not found. Please check the entered details.");
        }
    }


    private Client findClientByName(String clientName) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(clientName)) {
                return client;
            }
        }
        return null;
    }


    private Property findPropertyByAddress(String propertyAddress) {
        for (Property property : properties) {
            if (property.getAddress().equalsIgnoreCase(propertyAddress)) {
                return property;
            }
        }
        return null;
    }



    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

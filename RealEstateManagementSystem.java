package OOP_Project;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.List;
import java.util.Optional;

public class RealEstateManagementSystem extends Application {
    private PropertyListing propertyListing = new PropertyListing();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Real Estate Management System");

        GridPane grid = createGrid();
        MenuBar menuBar = createMenuBar();
        grid.add(menuBar, 0, 0, 5, 1);

        Scene scene = new Scene(grid, 800, 600);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        return grid;
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu propertyMenu = new Menu("Property");
        MenuItem addPropertyItem = createMenuItem("Add Property", e -> handleAddProperty());
        MenuItem updatePropertyItem = createMenuItem("Update Property", e -> handleUpdateProperty());
        MenuItem removePropertyItem = createMenuItem("Remove Property", e -> handleRemoveProperty());
        propertyMenu.getItems().addAll(addPropertyItem, updatePropertyItem, removePropertyItem);

        Menu clientMenu = new Menu("Client");
        MenuItem addClientItem = createMenuItem("Add Client", e -> handleAddClient());
        clientMenu.getItems().add(addClientItem);

        Menu searchMenu = new Menu("Search");
        MenuItem searchPropertyItem = createMenuItem("Search Properties", e -> handleSearchProperties());
        searchMenu.getItems().add(searchPropertyItem);

        Menu appointmentMenu = new Menu("Appointments");
        MenuItem scheduleAppointmentItem = createMenuItem("Schedule Appointment", e -> handleScheduleAppointment());
        appointmentMenu.getItems().add(scheduleAppointmentItem);

        menuBar.getMenus().addAll(propertyMenu, clientMenu, searchMenu, appointmentMenu);

        return menuBar;
    }

    private MenuItem createMenuItem(String label, EventHandler<ActionEvent> handler) {
        MenuItem menuItem = new MenuItem(label);
        menuItem.setOnAction(handler);
        return menuItem;
    }



    private void handleAddProperty() {
        Dialog<String> dialog = createInputDialog("Add Property", "Enter property details (address, price, bedrooms, bathrooms):");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(propertyDetails -> {
            String[] details = propertyDetails.split(",");
            try {
                String address = details[0].trim();
                double price = Double.parseDouble(details[1].trim());
                int bedrooms = Integer.parseInt(details[2].trim());
                int bathrooms = Integer.parseInt(details[3].trim());

                Property newProperty = new Property(address, price, bedrooms, bathrooms);
                propertyListing.addProperty(newProperty);

                showAlert("Property added successfully!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                showAlert("Invalid input. Please enter valid values.");
            }
        });
    }

    private void handleUpdateProperty() {

        Dialog<String> dialog = createInputDialog("Update Property", "Enter updated property details (index, address, price, bedrooms, bathrooms):");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(propertyDetails -> {

            String[] details = propertyDetails.split(",");
            try {
                int index = Integer.parseInt(details[0].trim());
                String address = details[1].trim();
                double price = Double.parseDouble(details[2].trim());
                int bedrooms = Integer.parseInt(details[3].trim());
                int bathrooms = Integer.parseInt(details[4].trim());

                Property updatedProperty = new Property(address, price, bedrooms, bathrooms);
                propertyListing.updateProperty(index, updatedProperty);

                showAlert("Property updated successfully!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                showAlert("Invalid input. Please enter valid values.");
            }
        });
    }


    private void handleRemoveProperty() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Remove Property");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter the index of the property to remove:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(indexStr -> {
            try {
                int index = Integer.parseInt(indexStr.trim());

                if (index >= 0 && index < propertyListing.getProperties().size()) {
                    Property propertyToRemove = propertyListing.getProperties().get(index);
                    propertyListing.removeProperty(propertyToRemove);
                    showAlert("Property removed successfully!");
                } else {
                    showAlert("Invalid index. Please enter a valid index.");
                }
            } catch (NumberFormatException e) {
                showAlert("Invalid input. Please enter a valid numerical index.");
            }
        });
    }

    private void handleAddClient() {

        Dialog<String> dialog = createInputDialog("Add Client", "Enter client details (name, contact details, preferences):");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(clientDetails -> {

            String[] details = clientDetails.split(",");
            try {
                String name = details[0].trim();
                String contactDetails = details[1].trim();
                String preferences = details[2].trim();

                Client newClient = new Client(name, contactDetails, preferences);
                propertyListing.addClient(newClient);

                showAlert("Client added successfully!");
            } catch (ArrayIndexOutOfBoundsException e) {
                showAlert("Invalid input. Please enter all required details.");
            }
        });
    }


    private void handleSearchProperties() {

        Dialog<String> dialog = createInputDialog("Search Properties", "Enter search criteria (location, min price, max price):");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(searchCriteria -> {

            String[] criteria = searchCriteria.split(",");
            try {
                String location = criteria[0].trim();
                double minPrice = Double.parseDouble(criteria[1].trim());
                double maxPrice = Double.parseDouble(criteria[2].trim());

                List<Property> searchResults = propertyListing.searchProperties(location, minPrice, maxPrice);


                displaySearchResults(searchResults);

                showAlert("Search completed!");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                showAlert("Invalid input. Please enter valid values.");
            }
        });
    }
    private void displaySearchResults(List<Property> searchResults) {

        TableView<Property> searchResultsTable = new TableView<>();
        TableColumn<Property, String> searchAddressColumn = new TableColumn<>("Address");
        searchAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        TableColumn<Property, Double> searchPriceColumn = new TableColumn<>("Price");
        searchPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        searchResultsTable.getColumns().addAll(searchAddressColumn, searchPriceColumn);


        searchResultsTable.setItems(FXCollections.observableArrayList(searchResults));


        Stage resultsStage = new Stage();
        resultsStage.setTitle("Search Results");


        Scene resultsScene = new Scene(new StackPane(searchResultsTable), 400, 300);
        resultsStage.setScene(resultsScene);


        resultsStage.show();
    }


    private void handleScheduleAppointment() {

        Dialog<String> dialog = createInputDialog("Schedule Appointment", "Enter appointment details (client name, property address, date, time):");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(appointmentDetails -> {

            String[] details = appointmentDetails.split(",");
            try {
                String clientName = details[0].trim();
                String propertyAddress = details[1].trim();
                String date = details[2].trim();
                String time = details[3].trim();

                propertyListing.scheduleAppointment(clientName, propertyAddress, date, time);

                showAlert("Appointment scheduled successfully!");
            } catch (ArrayIndexOutOfBoundsException e) {
                showAlert("Invalid input. Please enter all required details.");
            }
        });
    }


    private Dialog<String> createInputDialog(String title, String content) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        return dialog;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}

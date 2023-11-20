package OOP_Project;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class RealEstateApp {
    private static PropertyListing<Property> propertyListing = new PropertyListing<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static final String PROPERTY_FILE = "properties.txt";
    private static final String CLIENT_FILE = "clients.txt";
    private static final String APPOINTMENT_FILE = "appointments.txt";

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Add Property");
            System.out.println("2. Update Property");
            System.out.println("3. Remove Property");
            System.out.println("4. Add Client");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. Display Properties");
            System.out.println("7. Search Properties");
            System.out.println("8. Display Clients");
            System.out.println("9. Display Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addProperty();
                        break;

                    case 2:
                        updateProperty();
                        break;

                    case 3:
                        removeProperty();
                        break;

                    case 4:
                        addClient();
                        break;

                    case 5:
                        scheduleAppointment();
                        break;

                    case 6:
                        propertyListing.displayProperties();
                        break;

                    case 7:
                        searchProperties();
                        break;

                    case 8:
                        displayClients();
                        break;

                    case 9:
                        displayAppointments();
                        break;

                    case 0:
                        saveData();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void addProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter property address: ");
        String address = scanner.next();
        System.out.print("Enter property price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter number of bedrooms: ");
        int bedrooms = scanner.nextInt();
        System.out.print("Enter number of bathrooms: ");
        int bathrooms = scanner.nextInt();

        Property property = new Property(address, price, bedrooms, bathrooms);
        propertyListing.addProperty(property);

        System.out.println("Property added successfully.");
    }

    private static void updateProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the property to update: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < propertyListing.getProperties().size()) {
            System.out.print("Enter updated property address: ");
            String updatedAddress = scanner.next();
            System.out.print("Enter updated property price: ");
            double updatedPrice = scanner.nextDouble();
            System.out.print("Enter updated number of bedrooms: ");
            int updatedBedrooms = scanner.nextInt();
            System.out.print("Enter updated number of bathrooms: ");
            int updatedBathrooms = scanner.nextInt();

            Property updatedProperty = new Property(updatedAddress, updatedPrice, updatedBedrooms, updatedBathrooms);
            propertyListing.updateProperty(index, updatedProperty);

            System.out.println("Property updated successfully.");
        } else {
            System.out.println("Invalid index. Property not found.");
        }
    }

    private static void removeProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the property to remove: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < propertyListing.getProperties().size()) {
            propertyListing.removeProperty(index);
            System.out.println("Property removed successfully.");
        } else {
            System.out.println("Invalid index. Property not found.");
        }
    }

    private static void addClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter client name: ");
        String name = scanner.next();
        System.out.print("Enter client contact details: ");
        String contactDetails = scanner.next();
        System.out.print("Enter client preferences: ");
        String preferences = scanner.next();

        Client client = new Client(name, contactDetails, preferences);
        clients.add(client);

        System.out.println("Client added successfully.");
    }

    private static void scheduleAppointment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter client name: ");
        String clientName = scanner.next();
        System.out.print("Enter property address: ");
        String propertyAddress = scanner.next();
        System.out.print("Enter appointment date: ");
        String date = scanner.next();

        Appointment appointment = new Appointment(clientName, propertyAddress, date);
        appointments.add(appointment);

        System.out.println("Appointment scheduled successfully.");
    }

    private static void searchProperties() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter search criteria (e.g., location, price range): ");
        String searchCriteria = scanner.next();

        for (Property property : propertyListing.getProperties()) {
            // Perform search based on the criteria
            if (property.getAddress().contains(searchCriteria) ||
                    Double.toString(property.getPrice()).contains(searchCriteria)) {
                System.out.println(property.getAddress() + " - $" + property.getPrice());
            }
        }
    }

    private static void displayClients() {
        System.out.println("Clients:");
        for (Client client : clients) {
            System.out.println("Name: " + client.getName() +
                    ", Contact: " + client.getContactDetails() +
                    ", Preferences: " + client.getPreferences());
        }
    }

    private static void displayAppointments() {
        System.out.println("Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println("Client: " + appointment.getClientName() +
                    ", Property: " + appointment.getPropertyAddress() +
                    ", Date: " + appointment.getDate());
        }
    }

    private static void loadData() {
        loadProperties();
        loadClients();
        loadAppointments();
    }

    private static void loadProperties() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String address = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int bedrooms = Integer.parseInt(parts[2].trim());
                    int bathrooms = Integer.parseInt(parts[3].trim());

                    Property property = new Property(address, price, bedrooms, bathrooms);
                    propertyListing.addProperty(property);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading property data: " + e.getMessage());
        }
    }

    private static void loadClients() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String contactDetails = parts[1].trim();
                    String preferences = parts[2].trim();

                    Client client = new Client(name, contactDetails, preferences);
                    clients.add(client);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading client data: " + e.getMessage());
        }
    }

    private static void loadAppointments() {
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String clientName = parts[0].trim();
                    String propertyAddress = parts[1].trim();
                    String date = parts[2].trim();

                    Appointment appointment = new Appointment(clientName, propertyAddress, date);
                    appointments.add(appointment);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading appointment data: " + e.getMessage());
        }
    }

    private static void saveData() {
        saveProperties();
        saveClients();
        saveAppointments();
    }

    private static void saveProperties() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROPERTY_FILE))) {
            for (Property property : propertyListing.getProperties()) {
                writer.write(property.getAddress() + "," + property.getPrice() + "," +
                        property.getBedrooms() + "," + property.getBathrooms());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving property data: " + e.getMessage());
        }
    }

    private static void saveClients() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENT_FILE))) {
            for (Client client : clients) {
                writer.write(client.getName() + "," + client.getContactDetails() + "," + client.getPreferences());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving client data: " + e.getMessage());
        }
    }

    private static void saveAppointments() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENT_FILE))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getClientName() + "," + appointment.getPropertyAddress() + "," + appointment.getDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving appointment data: " + e.getMessage());
        }
    }
}



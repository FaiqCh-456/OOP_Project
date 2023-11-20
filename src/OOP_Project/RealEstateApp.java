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

 
    }

    private static void removeProperty() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the property to remove: ");
        int index = scanner.nextInt();

      

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
      
    }

    private static void displayClients() {
        System.out.println("Clients:");
     
    }

    private static void displayAppointments() {
        System.out.println("Appointments:");
       
    }

 
   
    }

    private static void loadClients() {
     
    }

    private static void loadAppointments() {
     
    }

    private static void saveData() {
        saveProperties();
        saveClients();
        saveAppointments();
    }

    private static void saveProperties() {
    
    }

    private static void saveClients() {
      
    }

    private static void saveAppointments() {
    
}



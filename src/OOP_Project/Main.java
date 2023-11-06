package OOP_Project;

public class Main {

        public static void main(String[] args) {
            Passenger passenger = new Passenger(12,15);
            Vehicle vehicle =  new Vehicle(12,90,Status.AVAILABLE);
            Vehicle vehicle1 = new Vehicle(12,30,Status.RESERVED);
            Vehicle vehicle2 = new Vehicle(12,80,Status.AVAILABLE);
            UberManagement.addVehicle(vehicle);
            UberManagement.addVehicle(vehicle1);
            UberManagement.addVehicle(vehicle2);

            System.out.println(UberManagement.nearest(passenger));

            System.out.println(UberManagement.vehicles);



    }
}

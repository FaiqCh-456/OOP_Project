package OOP_Project;
import java.util.ArrayList;
public class UberManagement {


    final static double maxDistance = 1000;
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public static String nearest(Passenger p) {
        Vehicle v = null;
        double min;
        min = maxDistance;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.status.equals(Status.AVAILABLE) && (distance(p, vehicle) < min)) {
                min = distance(p, vehicle);
                v = vehicle;
            }
        }
        if (v != null)
            return v.toString() + ", Distance = " + min + ", Fare = " + min * 100 + "Rs";
        else return "No ride available";
    }

    public static double distance(Passenger p, Vehicle v) {
        return (Math.sqrt(((v.x - p.x) * (v.x - p.x)) + ((v.y - p.y) * (v.y - p.y))));


    }
}

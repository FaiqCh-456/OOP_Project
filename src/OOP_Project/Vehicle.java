package OOP_Project;

public class Vehicle {


    int x;
    int y;
    int id;

    Status status;
    static int counter = 1;


    public Vehicle(int x, int y,Status status) {
        this.id = counter++;
        this.x = x;
        this.y = y;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id + '}';
}
}



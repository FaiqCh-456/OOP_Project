package OOP_Project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Property implements Serializable {
    private SimpleStringProperty address;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty bedrooms;
    private SimpleIntegerProperty bathrooms;

    public Property(String address, double price, int bedrooms, int bathrooms) {
        this.address = new SimpleStringProperty(address);
        this.price = new SimpleDoubleProperty(price);
        this.bedrooms = new SimpleIntegerProperty(bedrooms);
        this.bathrooms = new SimpleIntegerProperty(bathrooms);
    }



    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getBedrooms() {
        return bedrooms.get();
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms.set(bedrooms);
    }

    public int getBathrooms() {
        return bathrooms.get();
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms.set(bathrooms);
    }


    public SimpleStringProperty addressProperty() {
        return address;
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public SimpleIntegerProperty bedroomsProperty() {
        return bedrooms;
    }

    public SimpleIntegerProperty bathroomsProperty() {
        return bathrooms;
    }
}

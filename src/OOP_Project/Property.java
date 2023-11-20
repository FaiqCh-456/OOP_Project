package OOP_Project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Property {
    private String address;
    private double price;
    private int bedrooms;
    private int bathrooms;


    public Property(String address, double price, int bedrooms, int bathrooms) {
        this.address = address;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }


    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}





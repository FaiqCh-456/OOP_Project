package OOP_Project;

import java.util.ArrayList;

class PropertyListing<T extends Property> {
    private ArrayList<T> properties = new ArrayList<>();


    public void addProperty(T property) {
        properties.add(property);
    }


    public void updateProperty(int index, T updatedProperty) {
        properties.set(index, updatedProperty);
    }


    public void removeProperty(int index) {
        properties.remove(index);
    }


    public void displayProperties() {
        for (T property : properties) {
            System.out.println(property.getAddress() + " - Rs" + property.getPrice());
        }
    }


    public ArrayList<T> getProperties() {
        return properties;
    }


}

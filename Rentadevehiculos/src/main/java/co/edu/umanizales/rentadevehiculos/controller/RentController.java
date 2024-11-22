package co.edu.umanizales.rentadevehiculos.controller;

package co.edu.rentcar.model;

public class Vehicle {
    private String plate;
    private VehicleType type;
    private String color;
    private boolean available;

    public Vehicle(String plate, VehicleType type, String color, boolean available) {
        this.plate = plate;
        this.type = type;
        this.color = color;
        this.available = available;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
}
}


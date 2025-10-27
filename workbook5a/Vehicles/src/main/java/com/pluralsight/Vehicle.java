package com.pluralsight;

public class Vehicle {
    String color;
    int numberOfPassengers;
    int cargoCapacity;
    int fuelCapacity;

    // *** Getters ***

    public String getColor() {
        return color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    // *** Setters ***

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    // *** Other ***
    @Override
    public String toString() {
        return String.format("""
                Color: %s
                Number Of Passengers: %d
                Cargo Capacity: %d
                Fuel Capacity: %d""", color, numberOfPassengers, cargoCapacity, fuelCapacity);
    }
}

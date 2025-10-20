package com.hoteloperations;

public class Room {
    private int numBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numBeds, double price) {
        this.numBeds = numBeds;
        this.price = price;
        isOccupied = false;
        isDirty = false;
    }

    public int getNumberOfBeds() {
        return numBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }
}

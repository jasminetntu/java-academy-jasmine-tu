package com.hoteloperations;

public class Room {
    private int numBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // *** Constructors ***

    public Room(int numBeds, double price) {
        this.numBeds = numBeds;
        this.price = price;
        isOccupied = false;
        isDirty = false;
    }

    // *** Getters ***

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

    // *** Setters ***
    public void checkIn() {
        isOccupied = true;
        isDirty = true;
    }

    public void checkOut() {
        isOccupied = false;
    }

    public void cleanRoom() {
        isDirty = false;
    }
}

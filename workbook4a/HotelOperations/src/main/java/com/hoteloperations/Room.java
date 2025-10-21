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
        if (isOccupied) {
            System.out.println("Room already occupied.");
        }
        else if (isDirty) {
            System.out.println("Unable to check in. Room is still dirty.");
        }
        else {
            isOccupied = true;
            isDirty = true;
        }
    }

    public void checkOut() {
        if (!isOccupied) {
            System.out.println("Unable to check out. Room has not yet been checked in.");
        }
        else {
            isOccupied = false;
        }
    }

    public void cleanRoom() {
        if (isOccupied) {
            System.out.println("Room is still occupied.");
        }
        else if (!isDirty) {
            System.out.println("Room is already clean.");
        }
        else {
            isDirty = false;
        }
    }
}

package com.hoteloperations;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // *** Constructors ***
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this(name, numberOfSuites, numberOfRooms);
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // *** Getters ***
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // *** Other ***
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) { //suite
            return getAvailableSuites() >= numberOfRooms;
        }
        else { //basic room
            return getAvailableBasicRooms() >= numberOfRooms;
        }
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableBasicRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
}

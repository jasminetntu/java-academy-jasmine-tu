package com.hoteloperations;

import java.time.LocalDate;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    boolean isWeekend;

    // *** Constructors ***
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        setRoomType(roomType);
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // *** Getters ***

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public double getReservationTotal() {
        double incPerNight = 0;

        if (isWeekend) {
            incPerNight = 0.10 * price;
        }

        return (price + incPerNight) * numberOfNights;
    }

    // *** Setters ***

    public void setRoomType(String roomType) {
        this.roomType = roomType;

        if (roomType.equalsIgnoreCase("king")) {
            this.price = 139;
        }
        else if (roomType.equalsIgnoreCase("double")) {
            this.price = 124;
        }
        else {
            this.roomType = "Double";
            this.price = 124;
            System.out.println("Not a valid room type. Defaulted to double.");
        }
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}

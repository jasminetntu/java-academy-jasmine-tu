package com.example.property;

public class Property {
    private int id;
    private String type;     // "HOUSE" or "APARTMENT"
    private String address;
    private String city;
    private String postalCode;
    private int bedrooms;
    private int bathrooms;
    private int squareMeters;
    private double monthlyRent;
    private boolean available;
    private String notes;

    // Constructor without id (for new properties not yet in DB)
    public Property(String type, String address, String city, String postalCode,
                    int bedrooms, int bathrooms, int squareMeters,
                    double monthlyRent, boolean available, String notes) {
        this.type = type;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squareMeters = squareMeters;
        this.monthlyRent = monthlyRent;
        this.available = available;
        this.notes = notes;
    }

    // Constructor with id (for rows loaded from DB)
    public Property(int id, String type, String address, String city, String postalCode,
                    int bedrooms, int bathrooms, int squareMeters,
                    double monthlyRent, boolean available, String notes) {
        this(type, address, city, postalCode, bedrooms, bathrooms, squareMeters, monthlyRent, available, notes);
        this.id = id;
    }

    // *** Getters ***
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getSquareMeters() {
        return squareMeters;
    }
    public double getMonthlyRent() {
        return monthlyRent;
    }
    public boolean isAvailable() {
        return available;
    }
    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        String propertyDetails = String.format("%d br, %d bath, %d m²", bedrooms, bathrooms, squareMeters);
        return String.format(
                "[%d] %-9s | %-25s | %-10s %-12s | %-20s | €%.2f | %-15s | %s",
                id,
                type,
                address,
                postalCode,
                city,
                propertyDetails,
                monthlyRent,
                available ? "AVAILABLE" : "NOT AVAILABLE",
                (notes == null ? "" : notes)
        );
    }

}
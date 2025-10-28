package com.pluralsight;

public class Asset {
    private String description;
    private String dateAcquired;
    private double originalCost;

    // *** Constructors ***
    public Asset() {
        this.description = "Unknown";
        this.dateAcquired = "Unknown";
        this.originalCost = 0;
    }

    public Asset(String description, String dateAcquired, double originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    // *** Getters ***

    public String getDescription() {
        return description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public double getValue() {
        return originalCost;
    }

    // *** Setters ***
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }
}

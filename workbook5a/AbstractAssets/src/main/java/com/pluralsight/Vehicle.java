package com.pluralsight;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    // *** Constructors ***

    public Vehicle() {
        super();
        this.makeModel = "Unknown";
        this.year = 0;
        this.odometer = 0;
    }

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // *** Getters ***
    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    @Override
    public double getValue() {
        double value = super.getOriginalCost();
        int yearAcquired = Integer.parseInt(super.getDateAcquired().substring(6));
        int yearsOwned = Math.abs(year - yearAcquired);

        if (yearsOwned > 10) { // over 10
            value = 1000;
        }
        else if (yearsOwned > 6) { // 7-10
            value -= 0.08 * value * yearsOwned;
        }
        else if (yearsOwned > 3) { //4-6
            value -= 0.06 * value * yearsOwned;
        }
        else if (yearsOwned >= 0) { //0-3
            value -= 0.03 * value * yearsOwned;
        }

        if (!makeModel.toLowerCase().contains("honda") && !makeModel.toLowerCase().contains("toyota")
                && odometer > 100000) {
            value -= value * 0.25;
        }

        return value;
    }

    // *** Setters ***
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}

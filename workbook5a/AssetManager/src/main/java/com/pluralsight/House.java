package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition; //1 = excellent, 2 = good, 3 = fair, 4 = poor
    private int squareFoot;
    private int lotSize;

    // *** Constructors ***

    public House() {
        super();
        this.address = "Unknown";
        this.condition = 0;
        this.squareFoot = 0;
        this.lotSize = 0;
    }

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // *** Getters ***
    public String getAddress() {
        return address;
    }

    public int getCondition() {
        return condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    @Override
    public double getValue() {
        double value = 0;

        if (condition == 1) { //excellent
            value += 180 * squareFoot;
        }
        else if (condition == 2) { //good
            value += 130 * squareFoot;
        }
        else if (condition == 3) { //fair
            value += 90 * squareFoot;
        }
        else if (condition == 4) { //poor
            value += 80 * squareFoot;
        }

        value += 0.25 * lotSize; //account for lot size

        return value;
    }

    // *** Setters ***

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}

package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(int yearBuilt, int squareFeet, int bedrooms) {
        super("Unnamed", 0);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        return squareFeet;
    }
}

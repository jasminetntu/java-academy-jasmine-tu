package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(double weight) {
        super("Unnamed", 0);
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return weight;
    }
}

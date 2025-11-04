package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    // *** Constructors ***

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        assets = new ArrayList<>();
    }

    // *** Other ***
    public void add(Valuable asset) {
        assets.add(asset);
    }

    public double getValue() {
        double total = 0;
        for (Valuable asset : assets) {
            total += asset.getValue();
        }

        return total;
    }

    public Valuable getMostValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable mostValuable = assets.get(0);
        double maxValue = assets.get(0).getValue();

        for (Valuable asset : assets) {
            if (asset.getValue() > maxValue) {
                mostValuable = asset;
                maxValue = asset.getValue();
            }
        }

        return mostValuable;
    }

    public Valuable getLeastValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable leastValuable = assets.get(0);
        double minValue = assets.get(0).getValue();

        for (Valuable asset : assets) {
            if (asset.getValue() < minValue) {
                leastValuable = asset;
                minValue = asset.getValue();
            }
        }

        return leastValuable;
    }


}

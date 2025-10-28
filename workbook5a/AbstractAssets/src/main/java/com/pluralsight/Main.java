package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(new House("My home", "01/01/2010", 300000, "1234 My Street, San Jose CA 12345",
                2, 3500, 800));
        myAssets.add(new House("My vacation house", "01/01/2015", 700000, "1234 My Street, Hawaii CA 12345",
                1, 5000, 1000));
        myAssets.add(new Vehicle("My lexus", "01/01/2023", 25000, "Lexus ES 300h", 2003, 110000));
        myAssets.add(new Vehicle("My honda", "01/01/2025", 30000, "Honda Civic", 2025, 2000));

        for (Asset a : myAssets) {
            System.out.println(a.getDescription() +
                    "\nDate: " + a.getDateAcquired() +
                    "\nOriginal: $" + a.getOriginalCost() +
                    "\nCurrent: $" + a.getValue());

            if (a instanceof House) {
                House temp = (House) a;
                System.out.println("Address: " + temp.getAddress() + "\n");
            }
            else {
                Vehicle temp = (Vehicle) a;
                System.out.println("Make Model: " + temp.getMakeModel() + "\n");
            }
        }
    }
}

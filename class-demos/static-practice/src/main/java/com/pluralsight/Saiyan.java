package com.pluralsight;

import java.util.ArrayList;

public class Saiyan {
    //instance variables unique to EACH saiyan
    private String name;
    private int powerLevel;

    //static variables shared by ALL saiyans
    private static int totalSaiyans = 0;
    private static ArrayList<Saiyan> allSaiyans = new ArrayList<>();

    // *** Constructors ***
    public Saiyan(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
        totalSaiyans++;
        allSaiyans.add(this);
    }

    // *** Getters ***

    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public static int getTotalSaiyans() {
        return totalSaiyans;
    }

    // *** Setters ***

    public void setPowerLevel(int powerLevel) {
        if (powerLevel > 0) {
            this.powerLevel = powerLevel;
            System.out.println(this.name + "'s power level updated to " + powerLevel + ".");
        }
        else {
            System.out.println("Power level cannot be negative.");
        }
    }

    // *** Other ***
    public static void printTotalSaiyans() {
        System.out.println("Total Saiyan(s): " + totalSaiyans);
    }

    public static void showAllSaiyanStats() {
        for (Saiyan s : allSaiyans) {
            s.showStats();
        }
    }

    public void showStats() {
        System.out.printf("---\nName: %s\nPower Level: %d\n---\n", name, powerLevel);
    }
}

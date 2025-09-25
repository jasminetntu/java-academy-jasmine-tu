package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        final double BASIC_CAR_RENTAL = 29.99;
        final double UNDERAGE_SURCHARGE = 0.30;

        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Welcome to the Rental Car Calculator! ***");

        //get inputs
        System.out.print("\nWhat date are you picking up? (mm/dd/yyyy): ");
        String pickupDate = scnr.nextLine();
        System.out.print("How many days are you renting?: ");
        int numDays = scnr.nextInt();

        System.out.print("\nWould you like an electronic toll tag at $3.95/day? (true/false): ");
        boolean hasElecToll = scnr.nextBoolean();
        System.out.print("Would you like a GPS at $2.95/day? (true/false): ");
        boolean hasGPS = scnr.nextBoolean();
        System.out.print("Would you like roadside assistance at $3.95/day? (true/false): ");
        boolean hasRoadAssist = scnr.nextBoolean();

        System.out.print("\nHow old are you?: ");
        int age = scnr.nextInt();

        //calculate & display
        double basicCarRentalCost = BASIC_CAR_RENTAL * numDays;
        double optionsCost = calcOptionsCost(numDays, hasElecToll, hasGPS, hasRoadAssist);
        double underageSurchargeCost = calcUnderageSurcharge(age, BASIC_CAR_RENTAL, UNDERAGE_SURCHARGE, numDays);

        printTotalCost(numDays, pickupDate, basicCarRentalCost, optionsCost, underageSurchargeCost);

        scnr.close();
    }

    /**
     * Calculate the cumulative cost of all selected options.
     * @param numDays int
     * @param hasElecToll boolean
     * @param hasGPS boolean
     * @param hasRoadAssist boolean
     * @return a double containing total cost of options
     */
    public static double calcOptionsCost(int numDays, boolean hasElecToll, boolean hasGPS, boolean hasRoadAssist) {
        double optionsCost = 0;

        if (hasElecToll) {
            optionsCost += 3.95;
        }
        if (hasGPS) {
            optionsCost += 2.95;
        }
        if (hasRoadAssist) {
            optionsCost += 3.95;
        }

        optionsCost *= numDays;

        return optionsCost;
    }

    /**
     * Calculates the cumulative cost of the underage surcharge.
     * Surcharge = 30% of basic rental price -> Multiply by number of days.
     * @param age int
     * @param basicRental double
     * @param underageSurcharge double
     * @param numDays int
     * @return total cost of underage surcharge
     */
    public static double calcUnderageSurcharge(int age, double basicRental, double underageSurcharge, int numDays) {
        double underargeSurchageCost = 0;
        if (age < 25) {
            underargeSurchageCost = basicRental * underageSurcharge * numDays;
        }
        return underargeSurchageCost;
    }

    /**
     * Add up the total cost and print receipt of costs in the following format:
     * For x day(s), picking up on mm/dd/yyyy...
     * Basic car rental price: $xx.xx
     * Additional options price: $xx.xx
     * Underage driver surcharge (<25 y/o): $xx.xx
     * Total cost: $xx.xx
     * @param numDays int
     * @param pickupDate String
     * @param basicCarRentalCost double
     * @param optionsCost double
     * @param underageSurchargeCost double
     */
    public static void printTotalCost(int numDays, String pickupDate, double basicCarRentalCost, double optionsCost, double underageSurchargeCost) {
        double totalCost = basicCarRentalCost + optionsCost + underageSurchargeCost;

        System.out.print("\nFor " + numDays + " day");
        if (numDays > 1) {
            System.out.print("s");
        }
        System.out.println(", picking up on " + pickupDate + "...");

        System.out.printf("Basic car rental price: $%.2f\n", basicCarRentalCost);
        System.out.printf("Additional options price: $%.2f\n", optionsCost);
        System.out.printf("Underage driver surcharge (<25 y/o): $%.2f\n", underageSurchargeCost);
        System.out.printf("Total cost: $%.2f\n", totalCost);
    }
}
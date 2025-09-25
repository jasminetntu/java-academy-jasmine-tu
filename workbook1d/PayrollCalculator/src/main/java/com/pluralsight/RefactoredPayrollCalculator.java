package com.pluralsight;

import java.util.Scanner;

public class RefactoredPayrollCalculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to your Payroll Calculator.\n");

        //get inputs
        System.out.print("Enter your first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Enter the number of hours you worked: ");
        double numHours = scnr.nextDouble();
        System.out.print("Enter your hourly pay rate: ");
        double payRate = scnr.nextDouble();

        //calculate gross
        double grossPay = calcGrossPay(numHours, payRate);

        //print name & gross pay
        printInfo(firstName, lastName, grossPay);

        scnr.close();
    }

    /**
     * Calculate gross pay based on hours worked & pay rate.
     * Overtime (> 40 hours) is 1.5x the pay.
     * @param numHours number of hours worked
     * @param payRate hourly pay rate
     * @return the gross pay
     */
    public static double calcGrossPay(double numHours, double payRate) {
        double grossPay;

        if (numHours > 40) { //overtime
            double numOvertime = numHours - 40;
            grossPay = payRate * (40 + (1.5 * numOvertime));
        } else { //no overtime
            grossPay = payRate * numHours;
        }

        return grossPay;
    }

    /**
     * Prints information in following format:
     * Employee Name: First Last
     * Gross Pay: $xx.xx
     * @param firstName String
     * @param lastName String
     * @param grossPay double
     */
    public static void printInfo(String firstName, String lastName, double grossPay) {
        System.out.printf("\nEmployee Name: " + firstName + " " + lastName
                + "\nGross Pay: $%.2f", grossPay);
    }
}

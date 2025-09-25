package com.pluralsight;

import java.util.Scanner;

//exercise 4
public class PayrollCalculator {
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

        //calculate gross pay & overtime if applicable
        double grossPay;
        if (numHours > 40) { //overtime
            double numOvertime = numHours - 40;
            grossPay = payRate * (40 + (1.5 * numOvertime));
        } else { //no overtime
            grossPay = payRate * numHours;
        }

        //print name & gross pay
        System.out.printf("\nEmployee Name: " + firstName + " " + lastName
                + "\nGross Pay: $%.2f", grossPay);

        scnr.close();
    }
}
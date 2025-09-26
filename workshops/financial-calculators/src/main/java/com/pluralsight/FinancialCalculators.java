/**
 * Financial Calculators
 * Workshop 1w
 * 9/26/2025
 * @author Jasmine Tu
 */
package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        FinancialCalculators finCalc = new FinancialCalculators();

        System.out.println("*** Welcome to our Financial Calculators! ***");
        String choice = "";

        while (!choice.equalsIgnoreCase("x")) {
            finCalc.printMenu();
            choice = scnr.nextLine();

            if (choice.equals("1")) { //mortgage calc
                finCalc.mortgageCalculator(scnr);
            }
            else if (choice.equals("2")) { //cd calc
//                finCalc.cdCalculator();
            }
            else if (choice.equals("3")) { //annuity calc
//                finCalc.annuityCalculator();
            }
            else if (!choice.equalsIgnoreCase("x")) { //invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
            //if 'x', then do nothing -> exits loop
        }

        //only runs when user exits loop with 'x'
        System.out.println("""
                \nThank you for using our Financial Calculators.
                *** Goodbye! ***""");

        scnr.close();
    }

    /**
     * Prints the menu selection.
     */
    public void printMenu() {
        System.out.print("""
                \n---------------------------------------------------------------------
                What calculator would you like to use?
                    1. Mortgage Calculator - Find Monthly Payment & Interest
                    2. CD Calculator - Find Future Value of Your CD
                    3. Annuity Calculator - Find Present Value of an Ordinary Annuity
                    X. Exit
                Enter your choice (1, 2, 3, or X):\s""");
    }

    /**
     * Calculates and prints monthly payment & total interest of a mortgage.
     * Takes principal, annual interest rate (decimal), and length of loan (yrs) as inputs.
     * Using the compound interest formula: M = P × (i * (1 + i )^n / ( (1 + i)^n ) - 1)
     * where P = principal, i = monthly interest rate, n = number of monthly payments
     *
     * Prints information in the following format:
     * A $x.xx loan at x% interest for x years
     * would have a $x.xx/mo payment with a total interest of $x.xx.
     *
     * @param scnr Scanner object
     */
    public void mortgageCalculator(Scanner scnr) {
        //System.out.println("Test: Mortgage Calculator");

        //get inputs
        System.out.print("\nEnter principal (loan value): ");
        double principal = scnr.nextDouble();
        System.out.print("Enter annual interest rate (in decimal form; ex: 5% -> 0.05): ");
        double annualInterestRate = scnr.nextDouble();
        System.out.print("Enter length of loan (in years): ");
        int numYears = scnr.nextInt();
        scnr.nextLine(); //consume leftover CRLF

        //calculate monthly values
        int numMonths = numYears * 12;
        double monthlyInterestRate = annualInterestRate / 12;

        //calculate monthly payment
        double monthlyPayment = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numMonths)
                / (Math.pow(1 + monthlyInterestRate, numMonths) - 1));

        //calculate total interest
        double totalInterest = (monthlyPayment * numMonths) - principal;

        //print result
        System.out.printf("\nA $%.2f loan ", principal);
        System.out.print("at " + (annualInterestRate * 100) + "% annual interest for " + numYears + " years");
        System.out.printf("\nwould have a $%.2f/mo payment with a total interest of $%.2f.\n",
                monthlyPayment, totalInterest);
    }

    public void cdCalculator() {
        //System.out.println("Test: CD Calculator");
    }

    public void annuityCalculator() {
        //System.out.println("Test: Annuity Calculator");
    }
}
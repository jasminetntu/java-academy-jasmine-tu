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
                finCalc.mortgageCalculator();
            }
            else if (choice.equals("2")) { //cd calc
                finCalc.cdCalculator();
            }
            else if (choice.equals("3")) { //annuity calc
                finCalc.annuityCalculator();
            }
            else if (!choice.equalsIgnoreCase("x")) { //invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
            //if 'x', then do nothing
        }

        //only runs when user exits loop with 'x'
        System.out.println("\nThank you for using our Financial Calculators.\nGoodbye!");

        scnr.close();
    }

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

    public void mortgageCalculator() {
        System.out.println("Test: Mortgage Calculator");
    }

    public void cdCalculator() {
        System.out.println("Test: CD Calculator");
    }

    public void annuityCalculator() {
        System.out.println("Test: Annuity Calculator");
    }
}
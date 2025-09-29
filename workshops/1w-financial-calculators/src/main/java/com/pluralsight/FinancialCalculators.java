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
                finCalc.cdCalculator(scnr);
            }
            else if (choice.equals("3")) { //annuity calc
                finCalc.annuityCalculator(scnr);
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
                    2. CD Calculator - Find Future Value of Your CD's One-Time Deposit
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
     * A $x.xx loan at x.xxxx% interest for x years
     * would have a $x.xx/mo payment with a total interest of $x.xx.
     *
     * @param scnr Scanner object
     */
    public void mortgageCalculator(Scanner scnr) {
        System.out.println("\n*** Mortgage Calculator ***");

        //get inputs
        System.out.print("Enter principal (loan value, w/o symbols): ");
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
        System.out.printf("\nA $%.2f loan at %.4f", principal, annualInterestRate * 100);
        System.out.println("% annual interest for " + numYears + " years");
        System.out.printf("would have a $%.2f/mo payment with a total interest of $%.2f.\n",
                monthlyPayment, totalInterest);
    }

    /**
     * Calculates and prints future value & total interest of a CD given a one-time deposit.
     * Takes principal/deposit, annual interest rate (decimal), and length of cd (yrs) as inputs.
     * Using the formula: FV = P × (1 + (r / 365) )^(365 × t)
     * where P = principal/deposit, r = annual interest rate, t = number of years
     *
     * Prints information in the following format:
     * If you deposit $x.xx in a CD that earns x.xxxx% annual interest and matures in x years,
     * your CD's ending balance will be $x.xx, and you would have earned $x.xx in interest.
     *
     * @param scnr Scanner object
     */
    public void cdCalculator(Scanner scnr) {
        System.out.println("\n*** CD Future Value Calculator ***");

        //get inputs
        System.out.print("Enter principal/initial deposit (w/o symbols): ");
        double principal = scnr.nextDouble();
        System.out.print("Enter annual interest rate (in decimal form; ex: 5% -> 0.05): ");
        double annualInterestRate = scnr.nextDouble();
        System.out.print("Enter number of years that CD will mature: ");
        int numYears = scnr.nextInt();
        scnr.nextLine(); //consume leftover CRLF

        //calculate future value and total interest
        double futureValue = principal *
                Math.pow(1 + (annualInterestRate / 365), 365 * numYears);
        double totalInterest = futureValue - principal;

        //print information
        System.out.printf("\nIf you deposit $%.2f in a CD that earns %.4f", principal, annualInterestRate * 100);
        System.out.println("% annual interest and matures in " + numYears + " years,");
        System.out.printf("your CD's ending balance will be $%.2f, and you would have earned $%.2f in interest.\n",
                futureValue, totalInterest);
    }

    /**
     * Calculates and prints present value of an ordinary annuity.
     * Takes monthly payout, annual interest rate (decimal), and number os years to pay out.
     * Using the formula: PV = C * [( 1 - (1 + r/n)^(-nt) ) / (r/n)]
     * where C = cash flow (monthly payouts), r = annual interest rate, t = number of years to pay out, n = 12 (months in year)
     *
     * Prints information in the following format:
     * To fund an annuity that pays $x.xx monthly for x years and earns an expected x.xxxx% interest,
     * you would need to invest $x.xx today.
     *
     * @param scnr Scanner object
     */
    public void annuityCalculator(Scanner scnr) {
        System.out.println("\n*** Ordinary Annuity Present Value Calculator ***");

        //get inputs
        System.out.print("Enter monthly payout (w/o symbols): ");
        double monthlyPayout = scnr.nextDouble();
        System.out.print("Enter expected annual interest rate (in decimal form; ex: 5% -> 0.05): ");
        double annualInterestRate = scnr.nextDouble();
        System.out.print("Enter number of years to pay out" +
                "\n(aka how long you want to receive monthly payments): ");
        int numYears = scnr.nextInt();
        scnr.nextLine(); //consume leftover CRLF

        //calculate present value
        double presentValue = monthlyPayout * (
                (1 - Math.pow(1 + annualInterestRate / 12, -12 * numYears))
                / (annualInterestRate / 12));

        //print information
        System.out.printf("\nTo fund an annuity that pays $%.2f monthly for " + numYears + " years "
                + "and earns an expected %.4f", monthlyPayout, annualInterestRate * 100);
        System.out.println("% interest,");
        System.out.printf("you would need to invest $%.2f today.\n", presentValue);
    }
}
package com.pluralsight;

public class CompareNumbers {
    public static void main(String[] args) {
        System.out.println("*** Testing ***");
        System.out.println("isEven(2): " + isEven(2)
                    + "\nisEven(5): " + isEven(5));
        System.out.println("\nisPositive(2.5): " + isPositive(2.5)
                + "\nisPositive(-1.2): " + isPositive(-1.2)
                + "\nisPositive(0): " + isPositive(0));
    }

    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPositive(double num) {
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }
}

package com.pluralsight;

import java.util.Scanner;

public class GradeChecker {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Grade Checker!");

        char letterGrade = ' ';
        boolean isValid = false;

        while (!isValid) {
            System.out.print("\nEnter your exam score (0-100): ");
            double examScore = scnr.nextDouble();

            if (examScore > 100 || examScore < 0) {
                System.out.println("Invalid grade.");
            } else {
                if (examScore >= 90) {
                    letterGrade = 'A';
                } else if (examScore >= 80) {
                    letterGrade = 'B';
                } else if (examScore >= 70) {
                    letterGrade = 'C';
                } else if (examScore >= 60) {
                    letterGrade = 'D';
                } else {
                    letterGrade = 'F';
                }

                isValid = true;
            }
        }

        System.out.println("Your letter grade is " + letterGrade + ".");
    }
}
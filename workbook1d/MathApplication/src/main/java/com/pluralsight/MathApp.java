package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MathApp {
    public static void main(String[] args) {
        //question 1 - salaries, find max
        double bobSalary = 150000.00;
        double garySalary = 100000.50;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is " + highestSalary);

        //question 2 - automotives, find min
        double carPrice = 25500.25;
        double truckPrice = 46000.60;
        double lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("The lowest automotive price is " + lowestPrice);

        //question 3 - area of circle
        double radius = 3.5;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of a circle with radius " + radius + " is " + area + ".");

        //question 4 - sqrt
        double myNum = 5.0;
        System.out.println("The square root of 5 is " + Math.sqrt(myNum));

    }
}
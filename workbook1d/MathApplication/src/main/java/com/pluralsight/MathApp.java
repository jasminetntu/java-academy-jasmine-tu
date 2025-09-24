package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MathApp {
    public static void main(String[] args) {
        //question 1 - salaries, find max
        double bobSalary = 150000.00;
        double garySalary = 100000.50;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("1. The highest salary is " + highestSalary);

        //question 2 - automotives, find min
        double carPrice = 25500.25;
        double truckPrice = 46000.60;
        double lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("2. The lowest automotive price is " + lowestPrice);

        //question 3 - area of circle
        double radius = 3.5;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("3. The area of a circle with radius " + radius + " is " + area + ".");

        //question 4 - sqrt
        double myNum = 5.0;
        System.out.println("4. The square root of 5 is " + Math.sqrt(myNum));

        //question 5 - distance b/w 2 points
        int x1 = 5;
        int y1 = 10;
        int x2 = 85;
        int y2 = 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("5. The distance between (5, 10) and (85, 50) is %.3f.\n", distance);

        //question 6 - abs val
        double negDouble = -3.8;
        System.out.println("6. The absolute value of " + negDouble + " is " + Math.abs(negDouble) + ".");

        //question 7 - random num
        double randomNum = Math.random();
        System.out.println("7. The randomly generated number is... " + randomNum + "!");

        //question 8 - minutes in days
        final int HOUR_IN_DAY = 24, MIN_IN_HOUR = 60, SEC_IN_MIN = 60, MS_IN_SEC = 1000;
        int numDays = 24;
        int numMinutes = numDays * HOUR_IN_DAY * MIN_IN_HOUR;
        int numMs = numMinutes * SEC_IN_MIN * MS_IN_SEC;
        System.out.println("8. In 24 days, there are " + numMinutes + " minutes "
                + "or " + numMs + " milliseconds.");

    }
}
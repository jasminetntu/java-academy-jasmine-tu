package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {
        //variables
        Dice dice = new Dice();
        int roll1 = 0;
        int roll2 = 0;

        int twoCounter = 0;
        int fourCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;
        int sum = 0;

        System.out.println("*** Roll the Dice! ***");

        //roll 2 dice 100 times
        for (int i = 1; i < 101; ++i) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            sum = roll1 + roll2;
            System.out.printf("Roll %d: %d - %d | Sum: %d\n", i, roll1, roll2, sum);

            //increment counter if applicable
            if (sum == 2) {
                twoCounter++;
            }
            else if (sum == 4) {
                fourCounter++;
            }
            else if (sum == 6) {
                sixCounter++;
            }
            else if (sum == 7) {
                sevenCounter++;
            }
        }

        //print counters
        System.out.printf("""
                \n-> Counters for Sums of...
                Two: %d
                Four: %d
                Six: %d
                Seven: %d
                """, twoCounter, fourCounter, sixCounter, sevenCounter);

    }
}
package com.pluralsight;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        int[] testScores = new int[10];
        int sum = 0;

        System.out.println("*** Test Statistics ***");

        //randomly give test scores & print, also find sum
        for (int i = 0; i < testScores.length; ++i) {
            testScores[i] = (int)(Math.random() * 100);
            sum += testScores[i];
            System.out.println((i + 1) + ". " + testScores[i]);
        }

        //calculate ave, high, low
        double aveScore = (double)sum / testScores.length;
        Arrays.sort(testScores);
        int highScore = testScores[testScores.length - 1]; //last elem
        int lowScore = testScores[0]; //first elem

        //bonus: median
        int median = testScores[testScores.length / 2];
        double difference = Math.abs(aveScore - median);

        //print
        System.out.printf("""
                \nAverage: %.1f
                Highest: %d
                Lowest: %d
                Median: %d
                Difference b/w Ave & Med: %.1f
                """, aveScore, highScore, lowScore, median, difference);
    }
}
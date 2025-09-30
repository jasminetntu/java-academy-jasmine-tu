package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        //Home:Visitor|21:9
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** High Score Wins ***\n");

        //get inputs
        System.out.print("Enter game score in following format (TeamName1:TeamName2|Score1:Score2): ");
        String scores = scnr.nextLine().trim();

        //split into array
        String[] arr_scores = scores.replace("|", ":").split(":");
        int score1 = Integer.parseInt(arr_scores[2].trim());
        int score2 = Integer.parseInt(arr_scores[3].trim());

        //determine winner
        String winner = "Tie";
        if (score1 > score2) {
            winner = arr_scores[0].trim(); //team 1
        }
        else if (score1 < score2) {
            //if score 1 < score 2
            winner = arr_scores[1].trim(); //team 2
        }
        //if == then leave as "Tie"

        System.out.println("Winner: " + winner);

        scnr.close();
    }
}
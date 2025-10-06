package com.pluralsight;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        String filePath = "src/main/resources/";
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Bedtime Stories ***");

        //get bedtime story
        BufferedReader bufReader;
        String storyFileName;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("""
                    \nChoose your story:
                        1. goldilocks.txt
                        2. hansel_and_gretel.txt
                        3. mary_had_a_little_lamb.txt
                    Enter the name of a story (exactly like above w/o the number):\s""");
            storyFileName = scnr.nextLine().trim();

            try {
                bufReader = new BufferedReader(new FileReader(filePath + storyFileName));

                printStory(bufReader);

                isValid = true;
                bufReader.close();
            }
            catch (IOException ioe) {
                System.out.println("Story not found! Please try again.");
            }
        }

        System.out.println("\n*** Thank you for reading! ***");
        scnr.close();
    }

    public static void printStory(BufferedReader bufReader) throws IOException {
        String currLine;
        int lineCount = 1;

        System.out.println();
        while ((currLine = bufReader.readLine()) != null) {
            System.out.println(lineCount + ". " + currLine);
            ++lineCount;
        }
    }
}
package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** Famous Quotes ***");

        String[] quotes = initializeQuotes();
        String choice = "";
        int quoteIndex;

        while (!choice.equalsIgnoreCase("x")) {
            printMenu();
            choice = scnr.nextLine();

            switch (choice.toLowerCase()) {
                case "a": //quote from number
                    try {
                        System.out.print("Enter a number between 1-10: ");
                        quoteIndex = scnr.nextInt();

                        System.out.println("\nYour quote:\n" + quotes[quoteIndex - 1]);
                    }
                    catch (Exception e) { //if index out of bounds or non-integer input
                        System.out.println("Invalid choice. Please try again.");
                    }

                    scnr.nextLine(); // consume leftover crlf
                    break;

                case "b": //random quote
                    quoteIndex = (int)(Math.random() * 10);
                    System.out.println("\nRandom quote:\n" + quotes[quoteIndex]);
                    break;

                case "x": //exit
                    System.out.println("\nThank you! Goodbye.");
                    break;

                default: //invalid input (not a, b, x)
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static String[] initializeQuotes() {
        return new String[] { //10 quotes
                "\"I hate men who are afraid of women's strength.\" ― Anaïs Nin",

                "\"Genius has no race. Strength has no gender. Courage has no limit.\" ― Hidden Figures",

                "\"We accept the love we think we deserve.\" ― Stephen Chbosky",

                "\"Be yourself; everyone else is already taken.\" ― Oscar Wilde",

                "\"To be in love is to surpass one's self.\" ― Oscar Wilde",

                """
                "In Vietnamese, the word for missing someone and remembering them is the same: nhớ.
                Sometimes, when you ask me over the phone, 'Có nhớ mẹ không?' I flinch, thinking you meant, 'Do you remember me?'
                I miss you more than I remember you." ― Ocean Vuong""",

                """
                "It's not my responsibility to be beautiful. I'm not alive for that purpose.
                My existence is not about how desirable you find me." ― Warsan Shire""",

                """
                "My mother was the most beautiful woman I ever saw. All I am I owe to my mother.
                I attribute my success in life to the moral, intellectual and physical education I received
                from her." ― George Washington""",

                "\"My mom smiled at me. Her smile kind of hugged me.\" ― R.J. Palacio",

                "\"I need a father. I need a mother. I need some older, wiser being to cry to. " +
                        "I talk to God, but the sky is empty.\" ― Sylvia Plath"
        };
    }

    public static void printMenu() {
        System.out.print("""
                    \n-------------------------------------------
                    What would you like to do?
                        A. Choose a number to view a quote
                        B. View a random quote
                        X. Exit
                    Enter choice (A, B, X):\s""");
    }
}
package com.example.utility;

import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValidType() {
        String type = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("\nType (HOUSE/APARTMENT): ");
            type = scanner.nextLine().trim().toUpperCase();

            if (type.equals("HOUSE") || type.equals("APARTMENT")) {
                valid = true;
            }
            else {
                System.out.println("Invalid type. Must be HOUSE or APARTMENT.");
            }
        }

        return type;
    }

    public int getInteger(String prompt) {
        int input = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("\n" + prompt);
                input = Integer.parseInt(scanner.nextLine());

                if (input <= 0) {
                    System.out.println("Must be a positive integer.");
                }
                else {
                    valid = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must be an integer.");
            }
        }

        return input;
    }

    public double getDouble(String prompt) {
        double input = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("\n" + prompt);
                input = Double.parseDouble(scanner.nextLine());

                if (input <= 0) {
                    System.out.println("Must be a positive number.");
                }
                else {
                    valid = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must be numeric.");
            }
        }

        return input;
    }

    public boolean getBoolean(String prompt) {
        boolean input = false;
        boolean valid = false;

        while (!valid) {
            System.out.print("\n" + prompt);
            String temp = scanner.nextLine().trim().toLowerCase();

            switch (temp) {
                case "true" -> {
                    input = true;
                    valid = true;
                }
                case "false" -> valid = true;
                default -> System.out.println("Must be true or false.");
            }
        }

        return input;
    }

}

package com.pluralsight;

public class Menu {
    public static void main(String[] args) {
        displayMenu();

        displayMenu();
    }

    public static void displayMenu() {
        System.out.println("""
                === MENU ===
                1. Coffee - $3.99
                2. Tea - $2.99
                3. Cookie - $1.99""");
    }
}

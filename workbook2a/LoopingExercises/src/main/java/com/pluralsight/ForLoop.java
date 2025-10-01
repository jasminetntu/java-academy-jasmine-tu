package com.pluralsight;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*** For Loop ***\nStarting countdown...");

        for (int i = 10; i > 0; --i) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }

        System.out.println("Launch!!! 🚀");
    }
}

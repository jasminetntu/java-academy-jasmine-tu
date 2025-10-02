package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        PowerpuffGirl blossom = new PowerpuffGirl("Blossom", "pink");
        PowerpuffGirl bubbles = new PowerpuffGirl("Bubbles", "blue");
        PowerpuffGirl buttercup = new PowerpuffGirl("Buttercup", "green");

        System.out.println(blossom);

        System.out.println("Took 80 damage!");
        blossom.setHealth(20);
        System.out.println(blossom);

        blossom.heal(100);
        System.out.println(blossom);

    }
}
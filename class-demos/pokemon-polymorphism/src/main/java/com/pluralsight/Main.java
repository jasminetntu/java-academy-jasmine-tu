package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pokemon> myPokemon = new ArrayList<>();
        myPokemon.add(new Pikachu("Pika"));
        myPokemon.add(new Treecko("Tree"));
        myPokemon.add(new Espeon("Esp"));

        for (Pokemon p : myPokemon) {
            p.attack();
        }
    }
}

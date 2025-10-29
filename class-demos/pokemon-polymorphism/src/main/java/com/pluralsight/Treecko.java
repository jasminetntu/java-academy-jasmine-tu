package com.pluralsight;

public class Treecko extends Pokemon {
    public Treecko(String name) {
        super(name);
    }

    @Override
    public String attack() {
        System.out.println("Absorb!");

        return "";
    }
}

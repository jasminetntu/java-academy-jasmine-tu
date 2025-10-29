package com.pluralsight;

public class Espeon extends Pokemon {
    public Espeon(String name) {
        super(name);
    }

    @Override
    public String attack() {
        System.out.println("Shadow ball!");

        return "";
    }
}

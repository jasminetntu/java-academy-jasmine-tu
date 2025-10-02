package com.pluralsight;

public class PowerpuffGirl {
    private String name;
    private String outfitColor;
    private int health;
    private int attackDamage;
    private int powerUp;

    // *** Constructors ***
    public PowerpuffGirl() {
        this.name = "";
        this.outfitColor = "";
        this.health = 100;
        this.attackDamage = 10;
        this.powerUp = 10;
    }

    public PowerpuffGirl(String name, String outfitColor) {
        this();
        this.name = name;
        this.outfitColor = outfitColor;
    }

    public PowerpuffGirl(String name, String outfitColor, int attackDamage, int powerUp) {
        this();
        this.name = name;
        this.outfitColor = outfitColor;
        this.attackDamage = attackDamage;
        this.powerUp = powerUp;
    }

    // *** Getters ***
    public String getName() {
        return name;
    }

    public String getOutfitColor() {
        return outfitColor;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getPowerUp() {
        return powerUp;
    }

    // *** Setters ***

    // don't want to change name or color

    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }
        else {
            System.out.println("Come on, this is not possible! Try again.");
        }
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }

    // *** Other ***

    public void heal(int healthToHeal) {
        System.out.println("Drinking potion...");

        health += healthToHeal;
        if (health > 100) {
            health = 100;
            System.out.println(this.name + " is now at full health.");
        }
        else {
            System.out.println(this.name + " is now at " + this.health + " health.");
        }

    }

    @Override
    public String toString() {
        return String.format("""
                %s's Stats:
                    Health: %d
                    Attack Damage: %d
                    Power Up: %d
                """, name, health, attackDamage, powerUp);
    }
}

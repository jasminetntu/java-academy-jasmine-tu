package com.pluralsight;

public abstract class Pokemon {
    private String energytype;
    private String name;

    public Pokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnergytype() {
        return energytype;
    }

    public void setEnergytype(String energytype) {
        this.energytype = energytype;
    }


    public abstract String attack();
}

package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Saiyan s1 = new Saiyan("Remsey", 9000);
        Saiyan s2 = new Saiyan("Goku", 10000);

        s1.showStats();
        s2.showStats();
        Saiyan.printTotalSaiyans();

        s1.setPowerLevel(-1000);
        s1.setPowerLevel(9999);
        s2.setPowerLevel(12201);

        Saiyan.showAllSaiyanStats();
    }
}

package com.pluralsight;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //setup
        Scanner scnr = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        DealershipFileManager dsm = new DealershipFileManager();
        Dealership dealership = dsm.getDealership();

        //enter app
        ui.display();

        //cleanup
        scnr.close();
    }
}

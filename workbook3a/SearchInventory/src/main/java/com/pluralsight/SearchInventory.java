package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scnr = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }

        scnr.close();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(1, "Apple", 1.99));
        inventory.add(new Product(2, "Banana", 0.99));
        inventory.add(new Product(3, "Grapes", 2.99));
        inventory.add(new Product(4, "Cuties", 5.99));
        inventory.add(new Product(5, "24K Golden Labubu", 99.99));

        return inventory;
    }
}
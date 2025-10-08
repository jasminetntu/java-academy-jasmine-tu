package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.net.URL;
import java.util.Collections;

public class SearchInventory {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory();
        Scanner scnr = new Scanner(System.in);

        Collections.sort(inventory, Comparator.comparing(Product::getName));

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d, %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }

        scnr.close();
    }

    public static ArrayList<Product> getInventory() throws IOException {
        ArrayList<Product> inventory = new ArrayList<>();

        URL resource = SearchInventory.class.getClassLoader().getResource("inventory.csv");

        if (resource == null) {
            System.out.println("Error: File not found.");
            return inventory; //returns empty inventory
        }

        File file = new File(resource.getFile());
        String currLine;
        String[] tempArr;

        try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
            while ((currLine = bufReader.readLine()) != null) {
                tempArr = currLine.split("\\|");

                // create new product (id, name, price) -> add to inventory
                inventory.add(new Product(Integer.parseInt(tempArr[0]), tempArr[1], Double.parseDouble(tempArr[2])));
            }
        }

//        5 items for testing
//        inventory.add(new Product(1, "Apple", 1.99));
//        inventory.add(new Product(2, "Banana", 0.99));
//        inventory.add(new Product(3, "Grapes", 2.99));
//        inventory.add(new Product(4, "Cuties", 5.99));
//        inventory.add(new Product(5, "24K Golden Labubu", 99.99));
        return inventory;
    }
}
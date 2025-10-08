package com.pluralsight;

import java.util.*;
import java.io.*;
import java.net.URL;

public class SearchInventory {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("*** Search Inventory Application ***");

        ArrayList<Product> inventory = getInventory();
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        String choice;

        do {
            printMenu();
            choice = scnr.nextLine();

            switch (choice) {
                case "1": //list all products
                    printInventory(inventory);
                    break;
                case "2": //lookup product by id
                    Product productToFind = lookupProductById(scnr, inventory);

                    if (productToFind == null) {
                        System.out.println("Product not found.");
                    }
                    else {
                        System.out.println("Found Product - " + productToFind);
                    }
                    break;
                case "3": //find all products within price range
                    printProductInPriceRange(scnr, inventory);
                    break;
                case "4": //add new product

                    break;
                case "5": //exit
                    System.out.println("\n*** Thank you! ***");
                    break;
                default: //invalid
                    System.out.println("Invalid input. Please try agin.");
            }

        } while (!choice.equals("5"));

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

    public static void printMenu() {
        System.out.print("""
                \n-------------------------------------------------
                What would you like to do?
                    1. List all products
                    2. Lookup a product by its id
                    3. Find all products within a price range
                    4. Add a new product
                    5. Quit the application
                Enter choice (1-5):\s""");
    }

    public static void printInventory(ArrayList<Product> inventory) {
        System.out.println("\n*** Current Inventory ***");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i));
        }
    }

    public static Product lookupProductById(Scanner scnr, ArrayList<Product> inventory) {
        boolean isValid = false;
        int id = -1;

        while (!isValid) { //loops while input = non-integer
            try {
                System.out.print("\nEnter ID of desired product: ");
                id = Integer.parseInt(scnr.nextLine());

                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        //loop through inventory & return product if matching id
        for (Product product : inventory) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null; //return null if not found
    }

    public static void printProductInPriceRange(Scanner scnr, ArrayList<Product> inventory) {
        boolean isValid = false;
        double minPrice = 0;
        double maxPrice = 0;
        int count = 0;

        //loops while input = non-double
        while (!isValid) {
            try {
                System.out.print("\nEnter minimum price: ");
                minPrice = Double.parseDouble(scnr.nextLine());
                System.out.print("Enter maximum price: ");
                maxPrice = Double.parseDouble(scnr.nextLine());

                if (minPrice < 0 || maxPrice < 0) {
                    System.out.println("Invalid input.");
                }
                else {
                    isValid = true;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        //find and print products
        System.out.printf("\n*** Products in Range $%.2f - $%.2f ***\n", minPrice, maxPrice);
        for (Product product : inventory) {
            if (product.getPrice() > minPrice && product.getPrice() < maxPrice) {
                count++;
                System.out.println("(" + count + ") " + product);
            }
        }

        if (count == 0) {
            System.out.println("No products found in price range.");
        }

    }
}
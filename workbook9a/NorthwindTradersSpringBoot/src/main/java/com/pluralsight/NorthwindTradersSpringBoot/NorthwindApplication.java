package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {
    @Autowired
    private ProductDao productDao;

    @Override
    public void run(String[] args) {
        System.out.print("""
                --- Northwind Traders Spring Boot App ---
                    [1] List Products
                    [2] Add Product
                > Enter choice:\s""");
        try (Scanner scnr = new Scanner(System.in)) {
            String choice = scnr.nextLine().trim();

            switch (choice) {
                case "1" -> listProducts(productDao);
                case "2" -> addProduct(productDao, scnr);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void listProducts(ProductDao productDao) {
        System.out.println("\n--- All Products ---");
        for (Product p : productDao.getAll()) {
            System.out.println(p);
        }
    }

    private static void addProduct(ProductDao productDao, Scanner scnr) {
        System.out.println("\n--- Add New Product ---");

        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter product id: ");
                int id = Integer.parseInt(scnr.nextLine());

                valid = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Id must be a number.");
            }
        }

        System.out.print("Enter product name: ");
        String name = scnr.nextLine();

        System.out.print("Enter product category: ");
        String category = scnr.nextLine();

        double price = 0.0;

        valid = false;
        while (!valid) {
            System.out.print("Enter product price: ");
            try {
                price = Double.parseDouble(scnr.nextLine());
                if (price >= 0) {
                    valid = true;
                }
                else {
                    System.out.println("Price cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Must be a number.");
            }
        }

        Product newProduct = new Product(0, name, category, price);
        productDao.add(newProduct);

        System.out.printf("Successfully added product: %s%n", newProduct.getName());
    }

}

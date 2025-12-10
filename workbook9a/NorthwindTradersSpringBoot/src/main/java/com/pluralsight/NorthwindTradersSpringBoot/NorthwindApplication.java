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
        boolean running = true;
        try (Scanner scnr = new Scanner(System.in)) {
            while (running) {
                System.out.print("""
                    
                    -----------------------------------------
                    |   Northwind Traders Spring Boot App   |
                    -----------------------------------------
                        [1] List Products
                        [2] Add Product
                        [3] Delete Product
                        [X] Exit
                    > Enter choice:\s""");

                String choice = scnr.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "1" -> listProducts(productDao);
                    case "2" -> addProduct(productDao, scnr);
                    case "3" -> deleteProduct(productDao, scnr);
                    case "x" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }

    private void listProducts(ProductDao productDao) {
        System.out.println("\n--- All Products ---");
        for (Product p : productDao.getAll()) {
            System.out.println(p);
        }
    }

    private void addProduct(ProductDao productDao, Scanner scnr) {
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

    private void deleteProduct(ProductDao productDao, Scanner scnr) {
        System.out.println("\n--- Delete Product ---");
        System.out.print("Enter product ID: ");

        try {
            int productId = Integer.parseInt(scnr.nextLine());
            productDao.delete(productId);
        }
        catch (NumberFormatException e) {
            System.out.println("ID must be an integer.");
        }

    }

}

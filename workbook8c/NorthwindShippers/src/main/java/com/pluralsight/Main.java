package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.hca.jdbc.UsingDriverManager <username> <password>");
            System.exit(1);
        }
        // get username and password
        String username = args[0];
        String password = args[1];
        ShippersDao shippersDao = new ShippersDao(username, password);

        Main main = new Main();
        main.printAllShippers(shippersDao);

        main.queryAddShipper(scnr, shippersDao);
        main.printAllShippers(shippersDao);

        main.queryUpdateShipper(scnr, shippersDao);
        main.printAllShippers(shippersDao);

        main.queryRemoveShipper(scnr, shippersDao);
        main.printAllShippers(shippersDao);
    }

    // *** HELPERS ***

    private void printAllShippers(ShippersDao shippersDao) {
        List<Shipper> shippers = shippersDao.getAllShippers();

        if (shippers.isEmpty()) {
            System.out.println("\nNo shippers found.");
        }
        else {
            System.out.printf("%n%-5s %-15s %-15s%n", "ID", "Company Name", "Phone");
            System.out.println("----- --------------- ---------------");
            for (Shipper s : shippers) {
                System.out.printf("%-5d %-15s %-15s%n", s.getId(), s.getCompanyName(), s.getPhone());
            }
            System.out.println("----- --------------- ---------------\n");
        }
    }

    private void queryAddShipper(Scanner scnr, ShippersDao shippersDao) {
        System.out.println("*** Adding New Shipper ***");

        System.out.print("Enter company name: ");
        String companyName = scnr.nextLine().trim();
        System.out.print("Enter phone (Format: (000) 000-0000): ");
        String phoneNumber = scnr.nextLine().trim();

        shippersDao.addShipper(companyName, phoneNumber);
    }

    private void queryUpdateShipper(Scanner scnr, ShippersDao shippersDao) {
        System.out.println("*** Updating Shipper ***");

        long id = -1;
        String phoneNumber = "";

        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter ID to shipper to update: ");
                id = Long.parseLong(scnr.nextLine());
                System.out.print("Enter new phone (Format: (000) 000-0000): ");
                phoneNumber = scnr.nextLine().trim();

                if (phoneNumber.isEmpty()) {
                    System.out.println("Phone number cannot be empty.");
                } else {
                    valid = true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("ID must be a whole number.");
            }
        }

        shippersDao.updateShipper(id, phoneNumber);
    }

    private void queryRemoveShipper(Scanner scnr, ShippersDao shippersDao) {
        System.out.println("*** Deleting Shipper ***");

        System.out.print("Enter id of shipper to delete: ");
        // long id = Long.parseLong(scnr.nextLine()); // commented for safety
        long id = 5; // hard code to not remove shippers 1-3

        shippersDao.removeShipper(id);
    }
}

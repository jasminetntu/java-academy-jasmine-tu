package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20];

        //initialize 6 vehicles
        int totVehicles = 6;

        Vehicle vehicle1 = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        Vehicle vehicle2 = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        Vehicle vehicle3 = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        Vehicle vehicle4 = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        Vehicle vehicle5 = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        Vehicle vehicle6 = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        vehicles[0] = vehicle1;
        vehicles[1] = vehicle2;
        vehicles[2] = vehicle3;
        vehicles[3] = vehicle4;
        vehicles[4] = vehicle5;
        vehicles[5] = vehicle6;

        System.out.println("*** Vehicle Inventory ***");

        String choice;
        String makeModel;
        float price;
        String color;

        do {
            printMenu();
            choice = scnr.nextLine().trim();

            switch(choice) {
                case "1":
                    listAllVehicles(vehicles, totVehicles);
                    break;
                case "2":
                    System.out.print("Enter desired make model: ");
                    makeModel = scnr.nextLine().trim();
                    findVehiclesByMakeModel(vehicles, totVehicles, makeModel);
                    break;
                case "3":
                    System.out.print("Enter maximum price: ");
                    try {
                        price = Float.parseFloat(scnr.nextLine().trim());
                        findVehiclesByPrice(vehicles, totVehicles, price);
                    } catch (Exception e) {
                        System.out.println("Not a valid price.");
                    }

                    break;
                case "4":
                    System.out.print("Enter desired color: ");
                    color = scnr.nextLine().trim();
                    findVehiclesByColor(vehicles, totVehicles, color);
                    break;
                case "5":
                    addAVehicle(vehicles, totVehicles, scnr);
                    ++totVehicles;
                    break;
                case "6": //quit
                    System.out.println("Thank you! Goodbye.");
                    break;
                default: //invalid input
                    System.out.println("Invalid choice. Please try agian.");
            }
        } while (!choice.equals("6"));

        scnr.close();
    }

    public static void printMenu() {
        System.out.print("""
                \n-----------------------------
                What do you want to do?
                    1. List all vehicles
                    2. Search by make/model
                    3. Search by price range
                    4. Search by color
                    5. Add a vehicle
                    6. Quit
                Enter your command (1-6):\s""");
    }

    public static void listAllVehicles(Vehicle[] vehicles, int totVehicles) {
        System.out.println("\nVehicle Inventory:");
        for (int i = 0; i < totVehicles; ++i) {
            System.out.println(i + 1 + ". " + vehicles[i].toString());
        }
    }

    public static void findVehiclesByMakeModel(Vehicle[] vehicles, int totVehicles, String makeModelToFind) {
        System.out.println("\n" + makeModelToFind.toUpperCase() + " Inventory:");

        int count = 0;
        for (int i = 0; i < totVehicles; ++i) {
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModelToFind)) {
                ++count;
                System.out.println(count + ". " + vehicles[i].toString());
            }
        }

        if (count == 0) {
            System.out.println("- No " + makeModelToFind.toUpperCase() + " found.");
        }
    }

    public static void findVehiclesByPrice(Vehicle[] vehicles, int totVehicles, float priceToFind) {
        System.out.printf("\nVehicles Under $%.2f:\n", priceToFind);

        int count = 0;
        for (int i = 0; i < totVehicles; ++i) {
            if (vehicles[i].getPrice() <= priceToFind) {
                ++count;
                System.out.println(count + ". " + vehicles[i].toString());
            }
        }

        if (count == 0) {
            System.out.printf("- No vehicles under $%.2f found.", priceToFind);
        }
    }

    public static void findVehiclesByColor(Vehicle[] vehicles, int totVehicles, String colorToFind) {
        System.out.println("\n" + colorToFind.toUpperCase() + " Vehicles Inventory:");

        int count = 0;
        for (int i = 0; i < totVehicles; ++i) {
            if (vehicles[i].getColor().equalsIgnoreCase(colorToFind)) {
                ++count;
                System.out.println(count + ". " + vehicles[i].toString());
            }
        }

        if (count == 0) {
            System.out.println("- No " + colorToFind.toUpperCase() + " vehicles found.");
        }
    }

    public static void addAVehicle(Vehicle[] vehicles, int currIndex, Scanner scnr) {
        System.out.print("\nPlease provide the following:\nVehicle Id: ");
        long vehicleId = scnr.nextLong();
        scnr.nextLine(); //eat crlf
        System.out.print("Make Model: ");
        String makeModel = scnr.nextLine();
        System.out.print("Color: ");
        String color = scnr.nextLine();
        System.out.print("Odometer Reading: ");
        int odometerReading = scnr.nextInt();
        System.out.print("Price: ");
        float price = scnr.nextFloat();
        scnr.nextLine(); //eat crlf

        vehicles[currIndex] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
    }
}
package com.pluralsight;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NewPayrollCalculator {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        System.out.println("*** Payroll Calculator ***");

        //get file to process
        BufferedReader bufReader = getFileToProcess(scnr);
        bufReader.readLine(); //skip header line

        //get file to create
        String fileToCreate = getNameOfFileToCreate(scnr);
        BufferedWriter bufWriter =  new BufferedWriter(new FileWriter("data/"+ fileToCreate));
        boolean isCSV = fileToCreate.endsWith(".csv");

        //write to file
        writeToFile(bufReader, bufWriter, isCSV);

        System.out.println("\n*** " + fileToCreate + " has been created & holds information ***");

        scnr.close();
        bufReader.close();
        bufWriter.close();
    }

    public static BufferedReader getFileToProcess(Scanner scnr) throws IOException {
        BufferedReader bufReader = null;
        String fileToProcess;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("\nEnter the name of the file employee file to process: ");
            fileToProcess = scnr.nextLine().trim();

            URL resource = NewPayrollCalculator.class.getClassLoader().getResource(fileToProcess);

            if (resource == null) {
                System.out.println("File not found. Please try again.");
            }
            else {
                File file = new File(resource.getFile());
                bufReader = new BufferedReader(new FileReader(file));

                isValid = true;
            }
        }

        return bufReader;
    }

    public static String getNameOfFileToCreate(Scanner scnr) {
        boolean isValid = false;
        String fileToCreate = "";

        while (!isValid) {
            System.out.print("\nEnter the name of the payroll file to create (.csv or .json): ");
            fileToCreate = scnr.nextLine().trim();

            //if file name is invalid
            if (fileToCreate.contains(" ") || (!fileToCreate.endsWith(".csv") && !fileToCreate.endsWith(".json"))) {
                System.out.println("File name is invalid. Don't include spaces, and only create .csv or .json.");
            }
            else { //if file name is valid
                isValid = true;
            }
        }

        return fileToCreate;
    }

    public static void writeToFile(BufferedReader bufReader, BufferedWriter bufWriter, boolean isCSV) throws IOException {
        String currLine;
        String[] tokens;
        Employee tempEmployee;

        //special first line of files
        if (isCSV) {
            bufWriter.write("id|name|gross pay");
        }
        else {
            bufWriter.write("[");
        }

        //read file -> print to screen and write to file
        boolean isFirstJsonObj = true;

        while ((currLine = bufReader.readLine()) != null) {
            tokens = currLine.trim().split("\\|");

            //id, name, hours worked, pay rate
            tempEmployee = new Employee(Integer.parseInt(tokens[0]), tokens[1],
                    Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            // part 1 - print to screen
            // System.out.println(tempEmployee);

            //part 2 - write to file
            if (isCSV) { //csv file
                bufWriter.write("\n" + tempEmployee.toCsvString());
            }
            else if (isFirstJsonObj) { //first json obj of json file
                bufWriter.write("\n" + tempEmployee.toJsonString());
                isFirstJsonObj = false;
            }
            else { //regular lines of json file
                bufWriter.write(",\n" + tempEmployee.toJsonString());
            }
        }

        //special last line of json file
        if (!isCSV) {
            bufWriter.write("\n]");
        }
    }
}
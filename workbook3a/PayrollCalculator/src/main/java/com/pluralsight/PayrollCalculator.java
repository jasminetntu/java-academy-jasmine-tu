package com.pluralsight;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
        bufReader.readLine(); // skip category line

        String currLine;
        String[] tokens;
        Employee tempEmployee;
        while ((currLine = bufReader.readLine()) != null) {
            tokens = currLine.trim().split("\\|");

            tempEmployee = new Employee(Integer.parseInt(tokens[0]), tokens[1],
                    Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    //id, name, hours worked, pay rate

            System.out.println(tempEmployee);
        }

        bufReader.close();
    }
}
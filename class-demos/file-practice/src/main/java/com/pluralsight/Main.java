package com.pluralsight;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Why do we have URI?

        //URI Unique Resource Indentifier
        // URL Online Adress to file a place
        // URL for a file location
        // URI = FILE LOCATION

        // I`m going to do something with this file
        File mySourceFile = new File("c:\\demo\\student.txt");

        if(mySourceFile.createNewFile())
        {
            System.out.println("File created: " + mySourceFile.getName());


        } else {
            System.out.println("File already exists.");

        }

        try {
            FileWriter myWriter = new FileWriter(mySourceFile.getName());
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
package com.pluralsight;

import com.pluralsight.streams.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        // add 10 people
        people.add(new Person("Alice", "Nguyen", 20));
        people.add(new Person("Brian", "Smith", 22));
        people.add(new Person("Catherine", "Tran", 19));
        people.add(new Person("David", "Smith", 25));
        people.add(new Person("Emma", "Johnson", 21));
        people.add(new Person("Emma", "Kim", 23));
        people.add(new Person("Grace", "Tran", 20));
        people.add(new Person("Henry", "Tran", 24));
        people.add(new Person("Isabella", "Lopez", 22));
        people.add(new Person("Emma", "Brown", 26));

        //Prompt the user for a name to search (first or last).
        //Using a for loop, create a new List of people whose name was a match, display
        //the names of the people in that list
        //Step 3
        //Calculate the average age of all people in the original list and display it.
        //Display the age of the oldest person in the list.
        //Display the age of the youngest person in the list.

        // get name to search
        System.out.print("Enter the FIRST NAME to search (or enter to skip): ");
        String firstName = scnr.nextLine().trim();
        System.out.print("Enter the LAST NAME to search (or enter to skip):");
        String lastName = scnr.nextLine().trim();

        // print matching names w/ loop
        List<Person> matchingNames = new ArrayList<>();

        for (Person p : people) {
            boolean firstMatch = firstName.isEmpty() || p.getFirstName().equalsIgnoreCase(firstName);
            boolean lastMatch = lastName.isEmpty() || p.getLastName().equalsIgnoreCase(lastName);

            if (firstMatch && lastMatch) {
                matchingNames.add(p);
            }
        }

        for (Person p : matchingNames) {
            System.out.println(p);
        }

        // print ave, max, min ages
        double sum = 0;
        int max = people.get(0).getAge();
        int min = people.get(0).getAge();
        for (Person p : people) {
            sum += p.getAge();
            if (p.getAge() > max) {
                max = p.getAge();
            }
            if (p.getAge() < min) {
                min = p.getAge();
            }
        }
        System.out.println("\nAverage age: " + (sum / people.size()) +
                "\nMax age: " + max +
                "\nMin age: " + min);



    }
}

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

        // print matching names w/ streams
        people.stream()
                .filter(p -> firstName.isEmpty() || p.getFirstName().equalsIgnoreCase(firstName))
                .filter(p -> lastName.isEmpty() || p.getLastName().equalsIgnoreCase(lastName))
                .forEach(System.out::println);


        // print ave, max, min ages
        double sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();

        double minAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);

        double maxAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);


        System.out.println("Average age: " + (sum / people.size()) +
                "\nMax age: " + maxAge +
                "\nMin age: " + minAge);

    }
}

package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<Person>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "Westly", 31) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Auston", 16) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );

        //same last name
        myFamily.add( new Person("Lisa", "Nguyen", 20) );
        myFamily.add( new Person("Bella", "Nguyen", 51) );
        myFamily.add( new Person("Jack", "Nguyen", 12) );

        //same last and first
        myFamily.add( new Person("Jasmine", "Tu", 20) );
        myFamily.add( new Person("Jasmine", "Tu", 35) );
        myFamily.add( new Person("Jasmine", "Tu", 9) );


        System.out.println("--- UNSORTED LIST ---");
        for (Person p : myFamily) {
            System.out.println(p);
        }

        //doesn't work without the compareTo method since it doesn't know what to compare
        Collections.sort(myFamily);

        System.out.println("\n--- SORTED LIST ---");
        for (Person p : myFamily) {
            System.out.println(p);
        }
    }
}

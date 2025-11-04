package com.pluralsight;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " - " + age;
    }

    @Override
    public int compareTo(Person p) {
        int last = this.lastName.compareTo(p.lastName);
        int first = this.firstName.compareTo(p.firstName);

        if (last != 0) {
            return last;
        }
        else if (first != 0) {
            return first;
        }
        else {
            return this.age - p.age;
        }
    }
}

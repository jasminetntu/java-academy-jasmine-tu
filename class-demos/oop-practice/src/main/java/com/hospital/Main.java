package com.hospital;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Hoang", "Student");
        Doctor d1 = new Doctor();
        Surgeon s1 = new Surgeon();

        d1.operate();
        s1.operate();
    }
}

package com.hospital;

import com.moneyproblems.Menu;

public class Main {
    public static void Main(String[] args) {
         Person p1 = new Person();
         p1.name = "Hoang";
         p1.jobTitle = "Student";
         System.out.println("Hi, my name is " + p1.name);

        Doctor d1 = new Doctor();
        d1.operate();

        HeartSurgeon h1 = new HeartSurgeon();
        h1.operate();

        Menu.Operate(); // How can a menu Operate? That doesnt make sence..
    }
}

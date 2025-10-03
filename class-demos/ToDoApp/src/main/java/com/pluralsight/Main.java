package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("*** To-Do App ***");

        // Step 1: create an array that can hold 3 tasks
        Task[] tasks = new Task[10];
        int numTasks = 3;

        // Step 2: add new Task objects
        tasks[0] = new Task("Workshop 2w");
        tasks[1] = new Task("Prepare stuff for club meetings.");
        tasks[2] = new Task("Powerpuff girls exercise");

        // Step 3: mark one task as completed
        tasks[0].markCompleted();

        // Step 4: loop through the array and print each task
        printAllTasks(tasks, numTasks);

        System.out.print("\nWhat is a task you need to do?: ");
        tasks[numTasks] = new Task(scnr.nextLine());
        numTasks++;

        printAllTasks(tasks, numTasks);
    }

    public static void printAllTasks(Task[] tasks, int numTasks) {
        System.out.println("\nCurrent tasks:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println(tasks[i]);
        }
    }
}
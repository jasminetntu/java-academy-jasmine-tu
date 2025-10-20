package com.hospital;

public class Person {
    private String name;
    private String jobTitle;

    public Person() {
        this.name = "Unknown";
        this.jobTitle = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String jobTitle) {
        this(name);
        this.jobTitle = jobTitle;
    }

    // *** GETTERS ***

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    // *** SETTERS ***
    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        if (jobTitle.equalsIgnoreCase("student")) {
            System.out.println("Keep in mind a student is not allowed to operate.");
        }
        this.jobTitle = jobTitle;
    }



}

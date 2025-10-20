package com.hospital;

public class Person {
    public String name;
    public String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if(jobTitle.equalsIgnoreCase("Student")) {
            System.out.println("Keep in mine a student is not allowed to operate.");
        }
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

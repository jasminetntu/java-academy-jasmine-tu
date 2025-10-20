package com.hospital.departments;

public class Department {
    private String name;
    private String headOfDepartment;

    public Department(String name, String headOfDepartment) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
    }

    public String getInfo() {
        return name + " (Head: " + headOfDepartment + ")";
    }
}
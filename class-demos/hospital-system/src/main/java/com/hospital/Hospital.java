package com.hospital;

import java.util.List;
import com.hospital.departments.Department;


public class Hospital {
    String name;
    String location;
    List<Department> departments;

    public Hospital(String name, String location, List<Department> departments) {
        this.name = name;
        this.location = location;
        this.departments = departments;
    }

    public void printDepartments() {
        System.out.println("Hospital: " + name);
        System.out.println("Departments:");
        for (Department d : departments) {
            System.out.println("- " + d.getInfo());
        }
    }
}

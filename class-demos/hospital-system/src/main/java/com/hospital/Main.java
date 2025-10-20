package com.hospital;

import java.util.Arrays;
import com.hospital.departments.Department;
import com.hospital.staff.Doctor;
import com.hospital.staff.Nurse;

public class Main {
    public static void main(String[] args) {
        Department cardiology = new Department("Cardiology", "Dr. Smith");
        Department neurology = new Department("Neurology", "Dr. Jones");

        Hospital hospital = new Hospital(
                "St. Mary's Medical Center",
                "Downtown",
                Arrays.asList(cardiology, neurology)
        );

        hospital.printDepartments();

        Doctor doctor1 = new Doctor("Smith", "Cardiology");
        Doctor doctor2 = new Doctor("Jones", "Neurology");

        doctor1.introduce();
        doctor2.introduce();

        doctor1.work();
        doctor2.work();

        Nurse nurse1 = new Nurse("James");
        Nurse nurse2 = new Nurse("Jenny");

        nurse1.work();
        nurse2.work();
    }
}
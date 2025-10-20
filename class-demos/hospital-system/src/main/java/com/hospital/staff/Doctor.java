package com.hospital.staff;

public class Doctor extends StaffMember {
    private String specialization;

    public Doctor(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    public void introduce() {
        System.out.println("Dr. " + name + " - Specialization: " + specialization);
    }

    @Override
    public void work() {
        System.out.println(name + " is diagnosing patients...");
    }
}
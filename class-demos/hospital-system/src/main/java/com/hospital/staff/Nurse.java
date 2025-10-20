package com.hospital.staff;

public class Nurse extends StaffMember {
    public Nurse(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + " is preparing medication...");
    }
}

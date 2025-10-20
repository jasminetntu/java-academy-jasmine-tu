package com.hospital.staff;

public class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + " is working...");
    }
}
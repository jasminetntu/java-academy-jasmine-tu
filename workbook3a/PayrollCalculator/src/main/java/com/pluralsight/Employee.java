package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    // *** Constructors ***
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // *** Getters ***
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    // *** Setters ***
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // *** Other ***
    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    // *** To String Methods ***
    @Override
    public String toString() {
        return String.format("""
                    --------------------
                    Employee %d
                    Name: %s
                    Hours worked: %.2f
                    Pay rate: $%.2f
                    Gross pay: $%.2f""", employeeId, name, hoursWorked, payRate, getGrossPay());
    }

    public String toCsvString() {
        return String.format("%d|%s|%.2f", employeeId, name, getGrossPay());
    }

    public String toJsonString() {
        return String.format("\t{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f}",
                employeeId, name, getGrossPay());
    }
}

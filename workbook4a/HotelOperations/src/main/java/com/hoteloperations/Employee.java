package com.hoteloperations;

import java.time.LocalTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalTime startTime;

    // *** Constructors ***

    public Employee(String employeeId, String name, double payRate, String department, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.payRate = payRate;
        this.department = department;
        this.hoursWorked = hoursWorked;
    }

    // *** Getters ***

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        return (getRegularHours() + (getOvertimeHours() * 1.5)) * payRate;
    }

    public double getRegularHours() {
        if (hoursWorked < 40) {
            return hoursWorked;
        }
        else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        return hoursWorked - 40;
    }

    // *** Setters ***

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void punchIn(double time) {
        this.startTime = LocalTime.of((int) time, (int) (time * 100) % 100);
    }

    public void punchIn() {
        this.startTime = LocalTime.now();
    }

    public void punchOut(double time) {
        this.hoursWorked = time - (startTime.getHour() + startTime.getMinute() / 100.0); //end - start as double
    }

    public void punchOut() {
        this.hoursWorked = (LocalTime.now().getHour() + LocalTime.now().getMinute() / 100.0) //end time as double
                - (startTime.getHour() + startTime.getMinute() / 100.0); //start time as double
    }
}

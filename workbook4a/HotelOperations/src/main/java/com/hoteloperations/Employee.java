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


    public Employee(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = "Unknown";
        this.payRate = 0;
        this.hoursWorked = 0;
        this.startTime = null;
    }

    public Employee(String employeeId, String name, String department, double payRate) {
        this(employeeId, name);
        this.department = department;
        this.payRate = payRate;
    }

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this(employeeId, name, department, payRate);
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

    public LocalTime getStartTime() {
        return startTime;
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
        if (time < 0 || time >= 24) {
            System.out.println("Invalid time.");
        }
        else {
            this.startTime = LocalTime.of((int) time, (int) (time % 1 * 60));
        }
    }

    public void punchIn() {
        this.startTime = LocalTime.now();
    }

    public void punchOut(double time) {
        if (startTime == null) {
            System.out.println("Cannot punch out when employee has not punched in yet.");
        }
        else {
            double startTimeInDecimal = startTime.getHour() + (startTime.getMinute() / 60.0);

            if (time < startTimeInDecimal || time >= 24) {
                System.out.println("Invalid time. Must be after start time.");
            } else {
                this.hoursWorked = time - startTimeInDecimal;
            }
        }
    }

    public void punchOut() {
        this.hoursWorked = (LocalTime.now().getHour() + LocalTime.now().getMinute() / 100.0) //end time as double
                - (startTime.getHour() + startTime.getMinute() / 100.0); //start time as double
    }
}

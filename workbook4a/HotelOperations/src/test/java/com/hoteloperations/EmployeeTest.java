package com.hoteloperations;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    // *** punchIn()
    @Test
    void punchIn_ValidTime_SuccessfulPunchIn() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = 8.5; //8:30 AM
        LocalTime expectedValue = LocalTime.of(8, 30);

        //act
        employee.punchIn(testStartTime);

        //assert
        assertEquals(expectedValue, employee.getStartTime());
    }

    @Test
    void punchIn_NegativeTime_FailPunchIn() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = -1.5;

        //act
        employee.punchIn(testStartTime);

        //assert
        //todo: what would you do if you had a print?
    }

    @Test
    void punchIn_TimeGreaterThanOrEqualTo24_FailPunchIn() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = 24;

        //act
        employee.punchIn(testStartTime);

        //assert
        //todo: what would you do if you had a print?
    }

    // *** punchOut()
    @Test
    void punchOut_ValidTime_SuccessfulPunchOut() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = 8.5; //8:30 AM
        double testEndTime = 16.5; //4:30 PM
        double expectedValue = testEndTime - testStartTime;
        employee.punchIn(testStartTime);

        //act
        employee.punchOut(testEndTime);

        //assert
        assertEquals(expectedValue, employee.getHoursWorked());
    }

    @Test
    void punchOut_NegativeTime_FailPunchOut() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = 8.5; //8:30 AM
        double testEndTime = -1.5;
        employee.punchIn(testStartTime);

        //act
        employee.punchOut(testEndTime);

        //assert
        //todo: what would you do if you had a print?
    }

    @Test
    void punchOut_TimeGreaterThanOrEqualTo24_FailPunchOut() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testStartTime = 8.5; //8:30 AM
        double testEndTime = 24;
        employee.punchIn(testStartTime);

        //act
        employee.punchOut(testEndTime);

        //assert
        //todo: what would you do if you had a print?
    }

    @Test
    void punchOut_NotYetPunchedIn_FailPunchOut() {
        //arrange
        Employee employee = new Employee("123456789", "John Doe", "Software", 50.0);
        double testEndTime = 16.5; //4:30 PM

        //act
        employee.punchOut(testEndTime);

        //assert
        //todo: what would you do if you had a print?
    }
}
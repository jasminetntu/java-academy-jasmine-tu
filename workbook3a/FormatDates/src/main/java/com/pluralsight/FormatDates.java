package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        DateTimeFormatter formatter;

        //get current date & time
        LocalDate currDate = LocalDate.now();
        LocalTime currTime = LocalTime.now();

        //display in 4 ways
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(formatter.format(currDate));




        //09/05/2021
        //2021-09-05
        //September 5, 2021
        //Sunday, Sep 5, 2021 10:02 ß display in GMT time
        //CHALLENGE
        //5:02 on 05-Sep-2021 ß display in your local time zone
    }
}
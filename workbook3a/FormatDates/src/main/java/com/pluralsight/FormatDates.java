package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        DateTimeFormatter formatter;

        //get current date & time
        LocalDate currDate = LocalDate.now();
        LocalDateTime currDateAndTime = LocalDateTime.now();

        //display in 4 ways
        //09/05/2021
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(formatter.format(currDate));

        //2021-09-05
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter.format(currDate));

        //September 5, 2021
        formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(formatter.format(currDate));

        //Sunday, Sep 5, 2021 10:02 (GMT)
        formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(formatter.format(currDateAndTime));

        //5:02 on 05-Sep-2021 (PDT/PST)
        //get time zone
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime = currDateAndTime.atZone(zoneId);

        formatter = DateTimeFormatter.ofPattern("h:mm a zzz, dd-MMM-yyyy");
        System.out.println(formatter.format(zonedDateTime));
    }
}
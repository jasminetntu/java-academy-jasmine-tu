package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;

public class NameFormatter {

    //constructor is private so instance cannot be created
    private NameFormatter() {}

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        //format: LastName, Prefix FirstName MiddleName, Suffix
        return String.format("%s, %s %s %s, %s",
                lastName, prefix, firstName, middleName, suffix);
    }

    public static String format(String fullName) {
        //given fullName => Prefix FirstName MiddleName LastName, Suffix
        String prefix = "", firstName = "", middleName = "", lastName = "", suffix = "";

        //split full name and store in arraylist
        ArrayList<String> splitNames = new ArrayList<>(
                Arrays.asList(fullName.replace(",", "").split(" "))
        );

        //extract prefix (if exists)
        if (splitNames.get(0).contains(".")) {
            prefix = splitNames.remove(0);
        }

        //extract suffix (if exists)
        if (fullName.contains(",")) {
            suffix = splitNames.remove(splitNames.size() - 1);
        }

        //extract first name
        firstName = splitNames.remove(0);

        //extract last name
        lastName = splitNames.remove(splitNames.size() - 1);

        //extract middle name (if exists)
        if (!splitNames.isEmpty()) {
            middleName = splitNames.get(0);
        }

        //build formatted string
        StringBuilder sb = new StringBuilder();

        sb.append(lastName).append(",");
        if (!prefix.isEmpty()) {
            sb.append(" ").append(prefix);
        }
        sb.append(" ").append(firstName);
        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }
        if (!suffix.isEmpty()) {
            sb.append(", ").append(suffix);
        }

        return sb.toString();
    }
}

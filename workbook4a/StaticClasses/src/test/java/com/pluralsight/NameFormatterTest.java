package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void format_GivenFirstAndLast_ReturnCorrectFormat() {
        //arrange
        String firstName = "Mel";
        String lastName = "Johnson";
        String expected = "Johnson, Mel";

        //act
        String result = NameFormatter.format(firstName, lastName);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenAllParams_ReturnCorrectFormat() {
        //arrange
        String prefix = "Dr.";
        String firstName = "Mel";
        String middleName = "B";
        String lastName = "Johnson";
        String suffix = "PhD";
        String expected = "Johnson, Dr. Mel B, PhD";

        //act
        String result = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenFullNameWithMiddle_ReturnCorrectFormat() {
        //arrange
        String fullName = "Mel B Johnson";
        String expected = "Johnson, Mel B";

        //act
        String result = NameFormatter.format(fullName);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenFullNameWithPrefix_ReturnCorrectFormat() {
        //arrange
        String fullName = "Dr. Mel Johnson";
        String expected = "Johnson, Dr. Mel";

        //act
        String result = NameFormatter.format(fullName);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenFullNameWithSuffix_ReturnCorrectFormat() {
        //arrange
        String fullName = "Mel Johnson, PhD";
        String expected = "Johnson, Mel, PhD";

        //act
        String result = NameFormatter.format(fullName);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenFullNameWithOnlyFirstLast_ReturnCorrectFormat() {
        //arrange
        String fullName = "Mel Johnson";
        String expected = "Johnson, Mel";

        //act
        String result = NameFormatter.format(fullName);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void format_GivenFullName_ReturnCorrectFormat() {
        //arrange
        String fullName = "Dr. Mel B Johnson, PhD";
        String expected = "Johnson, Dr. Mel B, PhD";

        //act
        String result = NameFormatter.format(fullName);

        //assert
        assertEquals(expected, result);
    }
}
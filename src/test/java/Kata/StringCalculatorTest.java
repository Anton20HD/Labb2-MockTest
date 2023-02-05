package Kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

        StringCalculator stringCalculator = new StringCalculator();




    @Test
    void TestingEmptyStringReturnZero() {    // Test fails
        assertEquals(0, stringCalculator.add(""));

    }
    @Test
    void AddWithOneNumberReturnsNumber() {
        assertEquals(1, stringCalculator.add("1"));

    }
    @Test
    void TestingTheSumOfTwoNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));

    }
    @Test
    void TestingTheSumOfMultipleAmountOfNumbers() {
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));

    }
    @Test
    void TestingDelimiterToCheckTheSum() {
        assertEquals(3,stringCalculator.add("//;\n1;2"));

    }
    @Test
    void TestingNegativeNumbersMethodException() {
        try {
            stringCalculator.add("-3");
        }   catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-3]", e.getMessage());
        }

    }
    @Test
    void TestingNumberBiggerThan1000() {
        assertEquals(2, stringCalculator.add("2,1001"));

    }
    @Test
    void TestingCustomDelimiter() {
        assertEquals(6,stringCalculator.add("//[***]\n1***2***3"));

    }
    @Test
    void TestingMultipleDelimiters() {
        assertEquals(6,stringCalculator.add("//[*][%]\n1*2%3"));


    }
    @Test
    void TestingMultipleDelimitersWithlongerThanOneCharacter() {
            assertEquals(6,stringCalculator.add("//[****][%%%%]\n1****2%%%%3"));

    }
}


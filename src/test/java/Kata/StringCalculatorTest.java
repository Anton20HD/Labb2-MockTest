package Kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

        StringCalculator stringCalculator = new StringCalculator();



    @Test
    void EmptyStringReturnZero() {    // Test fails
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
}


package Kata;

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
}
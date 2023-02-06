package Kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {

            return 0;
        }
        String delimiter = addDelimiter(numbers);
        numbers = removeDelimiter(numbers);
        String[] numberArr = splitNumber(numbers, delimiter);
        handleNegativeNumbersException(numberArr);


        return sum(numberArr);
    }


    public String[] splitNumber(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    public String addDelimiter(String numbers) {
        String delimiter = "[,\n]";
        if (CustomDelimiterBeingUsed(numbers)) {
            int firstNewIndex = numbers.indexOf("\n");
            String customDelimiters = numbers.substring(2, firstNewIndex);
            delimiter = delimiter + "|" + customDelimiters.
                    replace("[", "(").
                    replace("]", ")").
                    replace(")(", ")|(").
                    replace("*", "\\*");

        }
        return delimiter;
    }

    public String removeDelimiter(String numbers) {
        if (CustomDelimiterBeingUsed(numbers)) {
            int firstNewIndex = numbers.indexOf("\n");
            return numbers.substring(firstNewIndex + 1);
        }
        return numbers;
    }


    public List<Integer> addNegativeNumbers(String[] numberArr) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numberArr) {
            int parsedInt = Integer.parseInt(number);
            if (parsedInt < 0) {
                negativeNumbers.add(parsedInt);
            }


        }
        return negativeNumbers;
    }
    public void handleNegativeNumbersException(String[] numberArr) {
        List<Integer> negativeNumbers = addNegativeNumbers(numberArr);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " +negativeNumbers);
        }
    }

    public static boolean CustomDelimiterBeingUsed(String numbers) {
        return numbers.startsWith("//");
    }
    public int sum(String[] numberArr) {
        return Arrays.stream(numberArr)
                .mapToInt(Integer::parseInt)
                .filter(n -> n <= 1000)
                .sum();

    }

}


















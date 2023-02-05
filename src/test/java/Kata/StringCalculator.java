package Kata;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {


    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {

            return 0;
        }
            String[] delimiter = addDelimiter(numbers);
            numbers = removeDelimiter(numbers);
           String[] numberArr = splitNumber(numbers,delimiter);
            handleNegativeNumbersException(numberArr);


            return sum(numberArr);
        }



    public String[] splitNumber(String numbers, String[] delimiter) {
        String regex = "";
        for (String delimit : delimiter) {
            regex += Pattern.quote(delimit) + "|";
        }
        regex = regex.substring(0,regex.length() - 1);
        return numbers.split(regex);
    }

public String[] addDelimiter(String numbers) {
        String delimiter =  "[,\n]";
        if (CustomDelimiterBeingUsed(numbers)) {
            int firstNewIndex = numbers.indexOf("\n");
            String customDelimiters = numbers.substring(2, firstNewIndex);
            if (customDelimiters.startsWith("[") && customDelimiters.endsWith("]")) {
                delimiter = customDelimiters.substring(1, customDelimiters.length() - 1);
            } else {
                delimiter = customDelimiters;
            }

        }
        return delimiter.split("\\]\\[");
    }


    public String removeDelimiter(String numbers) {
        if (CustomDelimiterBeingUsed(numbers)) {
            int firstNewIndex = numbers.indexOf("\n");
            return numbers.substring(firstNewIndex + 1);
        }
        return numbers;
    }


    public List<Integer> addNegativeNumbers(String[] numberArr) {

        return Arrays.stream(numberArr)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .boxed().collect(Collectors.toList());

    }
    private void handleNegativeNumbersException(String[] numberArr) {
        List<Integer> negativeNumbers = addNegativeNumbers(numberArr);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " +negativeNumbers);
        }
    }

    private static boolean CustomDelimiterBeingUsed(String numbers) {
        return numbers.startsWith("//");
    }
    public int sum(String[] numberArr) {
        return Arrays.stream(numberArr)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 1000)
                .sum();

    }

}























//    public int add(String numbers) {
//        if (numbers == null || numbers.isEmpty()) {
//            return 0;
//
//
//        }
//
//        String delimiter = "[,\n]";
//        if (CustomDelimiterBeingUsed(numbers)) {
//            int firstNewIndex = numbers.indexOf("\n");
//            delimiter = numbers.substring(2, firstNewIndex);
//            numbers = numbers.substring(firstNewIndex + 1);
//
//        }
//
//        String[] numberArr = numbers.split(delimiter);
//        return Arrays.stream(numberArr)
//                .mapToInt(Integer::parseInt)
//                .sum();
//    }
//    public void addNegativeNumbers(String numbers)  {
//        String[] numberArr = numbers.split("");
//        int sum = 0;
//        List<Integer> negativeNumbers = new ArrayList<>();
//        for (String number : numberArr) {
//            int parseNumber = Integer.parseInt(number);
//            if (parseNumber < 0) {
//                negativeNumbers.add(parseNumber);
//            } else {
//                sum += parseNumber;
//            }
//        }
//        if (!negativeNumbers.isEmpty()) {
//            throw new IllegalArgumentException("Negatives not allowed: " +negativeNumbers);
//        }
//    }
//
//
//    private static boolean CustomDelimiterBeingUsed(String numbers) {
//        return numbers.startsWith("//");
//    }
//
//}
//

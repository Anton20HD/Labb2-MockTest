package Kata;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;


    }

           String delimiter = "[,\n]";
            if (CustomDelimiterBeingUsed(numbers)) {
                int firstNewIndex = numbers.indexOf("\n");
                delimiter = numbers.substring(2, firstNewIndex);
                numbers = numbers.substring(firstNewIndex + 1);

            }

            String[] numberArr = numbers.split(delimiter);
            int sum = 0;
            for (String number : numberArr) {
                sum += Integer.parseInt(number);


//        String[] numberArr = numbers.split(",");
//        return Arrays.stream(numberArr)
//                .mapToInt(Integer::parseInt)
//                .sum();
            }
            return sum;
        }


    private static boolean CustomDelimiterBeingUsed(String numbers) {
        return numbers.startsWith("//");
    }

}


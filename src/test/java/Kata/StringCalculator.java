package Kata;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;


        }
        String[] numberArr = numbers.split("[,\n]");
        int sum = 0;
        for (var number : numberArr) {
            sum += Integer.parseInt(number);


//        String[] numberArr = numbers.split(",");
//        return Arrays.stream(numberArr)
//                .mapToInt(Integer::parseInt)
//                .sum();
        }
        return sum;
    }

}


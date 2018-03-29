package by.stn.java_exercises.modul_1.ex_19_fixed;

import java.util.ArrayList;
import java.util.List;

public class TextNumbersSumCalculator {
    //входные
    public static int calculate(String text) {
        int numStart;//numStart, замечания прошлого задания, найти все числа и сложить(отделение)
        int numFinish;

        List<Integer> numbers = new ArrayList<>();

        text = text.trim().toLowerCase();
        char[] symbols = text.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (isNumber(symbols[i])) {
                numStart = i;
                //i++;
                while (isNumber(symbols[i])) {
                    if (i == symbols.length - 1) {
                        i++;
                        break;
                    }
                    i++;
                }
                numFinish = i;
                numbers.add(Integer.valueOf(text.substring(numStart, numFinish)));
            }
        }
        return getSum(numbers);
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean isNumber(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    public static void main(String[] args) {
        String text = " what a hell, 123 is going on? I 45 don't  understand 7";
        System.out.println("The sum of numbers this text contains is " + calculate(text));
    }
}
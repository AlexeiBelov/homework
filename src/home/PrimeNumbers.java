package home;

import matrix.Matrix;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            numbers.add(i);
        }
        for (Integer number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.println("");
        int currentVariable = 2;
        int startingIndex = 1;
        for (int i = 0; i < 1000; i++) {
            for (int j = startingIndex; j < numbers.size(); j++) {
                if (numbers.get(j) != null && numbers.get(j) % currentVariable == 0) {
                    numbers.set(j, null);
                }
            }
            startingIndex++;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) != null && numbers.get(j) > currentVariable) {
                    currentVariable = numbers.get(j);
                    System.out.print(currentVariable + ", ");
                    break;


                }
            }
        }
    }
}

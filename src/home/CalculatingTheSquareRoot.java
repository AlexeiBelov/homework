package home;

public class CalculatingTheSquareRoot {
    public static void main(String[] args) {

        int initialNumber = 1;
        int numberToSubtract = 1;
        int result = 0;

        while (initialNumber > numberToSubtract || initialNumber != 0) {

            initialNumber -= numberToSubtract;
            numberToSubtract += 2;
            result++;
        }
        System.out.println(result);
    }
}


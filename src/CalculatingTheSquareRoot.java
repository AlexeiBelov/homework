public class CalculatingTheSquareRoot {
    public static void main(String[] args) {

        int initialNumber = 16;
        int numberToSubtract = 1;
        int result = 0;

        while (initialNumber > numberToSubtract || initialNumber != 0) {

            initialNumber = initialNumber - numberToSubtract;
            numberToSubtract = numberToSubtract + 2;
            result++;
        }
        System.out.println(result);
    }
}


package home;

public class FibonacciSequence {
    public static void main(String[] args) {
        generationAndConclusionArray();
        System.out.println("Это 43 номер  " + calcFibonacci(43));
        primeNumber();
        serialNumber();
    }

    private static void generationAndConclusionArray() {
        int[] arrayFibonacciSequence = new int[18];
        int a = 0, b = 1;
        System.out.print("Это массив первых 19 чисел - " + a + " " + b);
        int numberFibonacci;
        for (int j = 0; j < arrayFibonacciSequence.length; j++) {
            numberFibonacci = a + b;
            a = b;
            b = numberFibonacci;
            arrayFibonacciSequence[j] = numberFibonacci;
            System.out.print(" " + arrayFibonacciSequence[j]);
        }
    }

    static int calcFibonacci(int n) {
        int a = 0, b = 1;
        int numberFibonacci = 1;
        for (int i = 0; i < n; i++) {
            numberFibonacci = a + b;
            a = b;
            b = numberFibonacci;
        }
        return numberFibonacci;
    }

    private static void primeNumber() {
        int maxNumber = 41, a = 0, b = 1, numberFibonacci, i = 0;
        while (i < maxNumber) {
            numberFibonacci = a + b;
            a = b;
            b = numberFibonacci;
            i++;

            if (i == 41 && numberFibonacci % numberFibonacci != 0) {
                System.out.println("");
                System.out.println("Это 41 число - " + numberFibonacci + " и оно является простым");
            } else if (i == 41) {
                System.out.println("");
                System.out.print("Это 41 число - " + numberFibonacci + " и оно является составным");
            }
        }
    }

    private static void serialNumber() {
        int serialNumber = 0;
        int trueNumber = 1836311903;
        int a = 0, b = 1;
        int numberFibonacci = 0;
        while (numberFibonacci <= trueNumber) {
            numberFibonacci = a + b;
            a = b;
            b = numberFibonacci;
            serialNumber++;
            if (numberFibonacci == trueNumber) {
                System.out.println("");
                System.out.println("Это число - " + numberFibonacci + " и его порядковый номер " + serialNumber);
            }
        }
    }
}

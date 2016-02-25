import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        int a;
        Scanner scanner = new Scanner(System.in);

        do {
            a = getNextCoefficient(scanner, "A");
        } while (a == 0);

        int b = getNextCoefficient(scanner, "B");
        int c = getNextCoefficient(scanner, "C");

        int discriminant = b * b - 4 * a * c;
        System.out.println("Дискриминант: " + discriminant);
        if (discriminant < 0) {
            System.out.println("Нет действительных решений уравнения");
        } else if (discriminant == 0) {
            double result = (double) -b / (2 * a);
            System.out.println(result);
        } else if (discriminant > 0) {
            double result = (-b + Math.sqrt(discriminant)) / (2 * a);
            double result2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(result + " " + result2);
        }
    }

    private static int getNextCoefficient(Scanner scanner, String coeff) {
        System.out.print(String.format("Введите коэффициент %s целое число: ", coeff));
        return scanner.nextInt();
    }
}

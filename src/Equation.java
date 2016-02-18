import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        boolean firstCoefficient = true;
        int discriminant;
        int result;
        int result2;
        int a = 0;
        while (firstCoefficient) {
            Scanner scA = new Scanner(System.in);
            System.out.print("Введите целое число: ");
            a = scA.nextInt();
            if (a == 0) {
                System.out.println("Первый коэффициент не может быть 0. Повторите ввод");

            }else firstCoefficient = false;
        }
        Scanner scB = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int b = scB.nextInt();
        Scanner sC = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int c = sC.nextInt();

        discriminant = b * b - 4 * a * c;
        System.out.println(discriminant);
        if (discriminant < 0) {
            System.out.println("Нет действительных решений уравнения");
        } else if (discriminant == 0) {
            result = -1 * b / (2 * a);
            System.out.println(result);
        } else if (discriminant > 0) {
            result = (int) ((-1 * b + Math.sqrt(discriminant)) / 2 * a);
            result2 = (int) ((-1 * b - Math.sqrt(discriminant)) / 2 * a);
            System.out.println(result + " " + result2);
        }
    }
}

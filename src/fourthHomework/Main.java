package fourthHomework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = makeEmployees(10);
        System.out.println(employees);
        System.out.println("Список служащих со стажем 12 лет: ");
        printEmployee(employees, 12);
    }

    private static ArrayList<Employee> makeEmployees(int count) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            employee.setSurname(makeSurname());
            employee.setName(makeName());
            employee.setMiddleName(makeMiddleName());
            employee.setWorkAge(makeWorkAge());
            employees.add(employee);
        }
        return employees;
    }

    private static void printEmployee(Collection<Employee> employees, int workAge) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getWorkAge() == workAge) {
                System.out.println(employee);
            }
        }
    }

    private static String makeName() {
        String[] names = {"Сергей", "Андрей", "Владимир", "Петр", "Даниил"};
        int number = ThreadLocalRandom.current().nextInt(names.length);
        return names[number];
    }

    private static String makeSurname() {
        String[] names = {"Сергеев", "Андреев", "Владимиров", "Пончиков", "Абрикосов"};
        int number = ThreadLocalRandom.current().nextInt(names.length);
        return names[number];
    }

    private static String makeMiddleName() {
        String[] names = {"Сергеевич", "Андреевич", "Владимирович", "Петрович", "Александрович"};
        int number = ThreadLocalRandom.current().nextInt(names.length);
        return names[number];
    }

    private static int makeWorkAge() {
        return ThreadLocalRandom.current().nextInt(10, 13);
    }
}

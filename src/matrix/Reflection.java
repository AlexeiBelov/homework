package matrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void reflection(Matrix matrix) {
        Class<? extends Matrix> clazz = matrix.getClass();
        Matrix matrix1;

        try {
            matrix1 = clazz.newInstance();
            matrix1.print();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        Matrix matrix2;
        try {
            Constructor<? extends Matrix> constructor = clazz.getConstructor(int.class, int.class);
            matrix2 = constructor.newInstance(4, 4);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return;
        }

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field);
        }

        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method);
        }

        try {
            Method sum = clazz.getDeclaredMethod("sum", Matrix.class);
            Matrix matrixSum = (Matrix) sum.invoke(matrix1, matrix2);
            matrixSum.print();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Method printPrivate = clazz.getDeclaredMethod("printPrivate");
            printPrivate.setAccessible(true);
            printPrivate.invoke(matrix);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

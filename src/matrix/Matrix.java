package matrix;

import java.util.concurrent.ThreadLocalRandom;

public class Matrix {
    private final int m;
    private final int n;
    private final int[][] matrix;

    public Matrix() {
        this(3, 3);

    }

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    private Matrix initRandom() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(10);
            }
        }
        return this;
    }

    private static Matrix makeIdentityMatrix() {
        final Matrix result = new Matrix();
        result.initIdentity();
        return result;
    }

    private void initIdentity() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i == j ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.initRandom();
        System.out.println("Это инициализация");
        matrix.print();

        Matrix matrix2 = new Matrix().initRandom().print();
        System.out.println("Умножение");
        matrix2.multiplyingMatrix(matrix).print();

        Matrix matrixSum = matrix.sum(matrix2);
        matrixSum.print();

        Matrix matrixSubtraction = matrix.subtraction(matrix2);
        matrixSubtraction.print();

        Matrix matrix3 = makeIdentityMatrix().print().multiplicationByNumber();
        matrix3.print();

       Reflection.reflection(matrix);

    }


    public Matrix print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return this;
    }

    private Matrix printPrivate(){
       return print();
    }

    private Matrix multiplicationByNumber() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * 2;
            }
        }
        return this;
    }

    public Matrix sum(Matrix m) {
        if (this.m != m.m || this.n != m.n) {
            throw new IllegalArgumentException("размерности не совпадают");
        }
        final Matrix result = new Matrix(m.m, m.n);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiplyingMatrix(Matrix m) {
        if (this.n != m.m) {
            throw new IllegalArgumentException("размерности не совпадают");
        }
        final Matrix result = new Matrix(this.m, m.n);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < m.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    result.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Matrix subtraction(Matrix m) {
        if (this.m != m.m || this.n != m.n) {
            throw new IllegalArgumentException("размерности не совпадают");
        }
        final Matrix result = new Matrix(m.m, m.n);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.matrix[i][j] = matrix[i][j] - m.matrix[i][j];
            }
        }
        return result;
    }
}

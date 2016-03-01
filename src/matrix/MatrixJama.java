package matrix;

import Jama.Matrix;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MatrixJama {
    public static void main(String[] args) {
        Matrix matrix = Matrix.random(3, 3);
        matrix.print(4, 2);
        System.out.println(matrix.det());
        System.out.println(matrix.rank());
        matrix.inverse().print(4, 2);
        Matrix.identity(3, 3).print(4, 2);

    }

}
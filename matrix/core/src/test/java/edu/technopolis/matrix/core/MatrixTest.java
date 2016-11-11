package edu.technopolis.matrix.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MatrixTest {

    private static long[][] matrixArray1 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
    };

    private static long[][] matrixArray2 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    private static long[][] matrixArray3 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1},
    };

    private static long[][] matrixArray4 = {
            {1, 2},
            {3, 4}
    };

    private static long[][] matrixArray5 = {
            {-1, 2, 3},
            {0, -1, -2}
    };

    private static long[][] matrixArray6 = {
            {-1, 0, -1},
            {-3, 2, 1}
    };

    private static long[][] matrixArray7 = {
            {1, 5},
            {-3, 1},
            {0, 6},
    };

    @Test(expected = RuntimeException.class)
    public void testMatrix() {
        Matrix matrix = new Matrix(0, 0);
        Matrix matrix1 = new Matrix(-1, -1);
        Matrix matrix2 = new Matrix(matrixArray1);
        assertEquals(4, matrix2.rows());
        assertEquals(3, matrix2.columns());
    }

    @Test(expected = RuntimeException.class)
    public void testAdd() {
        Matrix matrix1 = new Matrix(matrixArray1);
        Matrix matrix2 = new Matrix(matrixArray2);
        Matrix matrix = matrix1.add(matrix2);
        for (int i = 0; i < matrix.rows(); ++i) {
            for (int j = 0; j < matrix.columns(); ++j) {
                assertEquals(j+2, matrix.get(i, j));
            }
        }

        matrix1.add(new Matrix(4, 2));
        matrix1.add(new Matrix(3, 3));
    }

    @Test
    public void testSubtract() {
        Matrix matrix1 = new Matrix(matrixArray1);
        Matrix matrix2 = new Matrix(matrixArray2);
        Matrix matrix = matrix1.subtract(matrix2);
        for (int i = 0; i < matrix.rows(); ++i) {
            for (int j = 0; j < matrix.columns(); ++j) {
                assertEquals(j, matrix.get(i, j));
            }
        }
    }

    @Test(expected = RuntimeException.class)
    public void testMultiply() {
        Matrix matrix = new Matrix(matrixArray4).multiply(new Matrix(matrixArray5));
        assertEquals(new Matrix(matrixArray6), matrix);
        assertEquals(new Matrix(matrixArray3), new Matrix(matrixArray7).multiply(new Matrix(matrixArray3)));

        matrix.multiply(matrix);
        matrix.multiply(new Matrix(matrixArray1));

    }

}

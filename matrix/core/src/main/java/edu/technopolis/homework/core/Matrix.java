package edu.technopolis.homework.core;

import java.util.Arrays;

public class Matrix implements Cloneable{

    private long[][] matrix;

    public Matrix(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new RuntimeException("Matrix dimension can't be " + rows + " x " + columns);
        }
        matrix = new long[rows][columns];
    }

    public Matrix(long[][] matrix) {
        this.matrix = matrix.clone();
    }

    public void set(int i, int j, long value) {
        matrix[i][j] = value;
    }

    public long get(int i, int j) {
        return matrix[i][j];
    }

    public int rows() {
        return matrix.length;
    }

    public int columns() {
        return matrix[0].length;
    }

    public Matrix add(Matrix augend) {
        return summarize(augend, '+');
    }

    public Matrix subtract(Matrix subtrahend) {
        return summarize(subtrahend, '-');
    }

    public Matrix multiply(Matrix multiplier) {
        if (columns() != multiplier.rows() ) {
            throw new RuntimeException(
                    "first matrix columns value: " +
                    columns() +
                    " not equal to second matrix rows value: " +
                    multiplier.rows()
            );
        }

        long[][] result = new long[rows()][multiplier.columns()];
        for (int i = 0; i < rows(); ++i) {
            for (int j = 0; j < multiplier.columns(); ++j) {
                for (int k = 0; k < columns(); ++k) {
                    result[i][j] += matrix[i][k] * multiplier.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Matrix) {
            final Matrix m = (Matrix) obj;
            return Arrays.deepEquals(matrix, m.matrix);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    private Matrix summarize(Matrix summable, char operation) {
        if (rows() != summable.rows() || columns() != summable.columns()) {
            throw new RuntimeException("Matrices have different dimensions");
        }

        long[][] result = new long[rows()][columns()];
        for (int i = 0; i < rows(); ++i) {
            for (int j = 0; j < columns(); ++j) {
                result[i][j] =
                        operation == '+'
                                ? matrix[i][j] + summable.matrix[i][j]
                                : matrix[i][j] - summable.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

}

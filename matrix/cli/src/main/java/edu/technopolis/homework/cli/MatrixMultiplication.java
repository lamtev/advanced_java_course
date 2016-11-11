package edu.technopolis.homework.cli;

import edu.technopolis.matrix.core.Matrix;

public class MatrixMultiplication {

    public static void main(String[] args) {
        MatrixMultiplication app = new MatrixMultiplication();
        app.run(args);
    }

    private void run(String[] args) {
        try {
            ArgumentsParser ap = new ArgumentsParser(args);
            Matrix matrix1 = new Matrix(ap.firstMatrixArray());
            Matrix matrix2 = new Matrix(ap.secondMatrixArray());
            Matrix result = matrix1.multiply(matrix2);
            printMatrix(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.rows(); ++i) {
            for (int j = 0; j < matrix.columns(); ++j) {
                System.out.print(matrix.get(i, j) + " " );
            }
            System.out.println();
        }
    }

}

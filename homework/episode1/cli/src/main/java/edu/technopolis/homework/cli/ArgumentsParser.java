package edu.technopolis.homework.cli;

class ArgumentsParser {

    private String[] args;
    private int n;
    private int m;
    private int x;
    private int y;
    private long[][] firstMatrixArray;
    private long[][] secondMatrixArray;

    ArgumentsParser(String[] args) {
        this.args = args;
        determineDimensions();
        validate();
        determineMatrices();
    }

    long[][] firstMatrixArray() {
        return firstMatrixArray;
    }

    long[][] secondMatrixArray() {
        return secondMatrixArray;
    }

    private void validate() {
        validateDimensions();
        validateNumberOfArguments();
    }

    private void validateDimensions() {
        for (int i = 0; i < 4; ++i) {
            if (Integer.parseInt(args[i]) < 1) {
                throw new RuntimeException("Matrix dimension must be positive");
            }
        }
        int m = Integer.parseInt(args[1]);
        int x = Integer.parseInt(args[2]);
        if (m != x) {
            throw new RuntimeException(
                    "first matrix columns value: " +
                            m +
                            " not equal to second matrix rows value: " +
                            x
            );
        }
    }

    private void validateNumberOfArguments() {
        if (args.length != n*m + x*y + 4) {
            throw new RuntimeException("Wrong number of arguments");
        }
    }

    private void determineDimensions() {
        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
            x = Integer.parseInt(args[2]);
            y = Integer.parseInt(args[3]);
        } catch (RuntimeException e) {
            throw new RuntimeException("Wrong arguments");
        }
    }

    private void determineMatrices() {
        try {
            determineFirstMatrixArray();
            determineSecondMatrixArray();
        } catch (RuntimeException e) {
            throw new RuntimeException("Wrong input");
        }
    }

    private void determineFirstMatrixArray() {
        firstMatrixArray = new long[n][m];
        int k = 3;
        for (int i = 0; i < n; ++ i) {
            for (int j = 0; j < m; ++j) {
                firstMatrixArray[i][j] = Integer.parseInt(args[++k]);
            }
        }
    }

    private void determineSecondMatrixArray() {
        secondMatrixArray = new long[x][y];
        int k = 3 + n*m;
        for (int i = 0; i < x; ++ i) {
            for (int j = 0; j < y; ++j) {
                secondMatrixArray[i][j] = Integer.parseInt(args[++k]);
            }
        }
    }

}

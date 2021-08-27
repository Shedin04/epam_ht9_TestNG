package com.epam.test.automation.java.practice9;

public class MatrixException extends Exception {
    public MatrixException(String message) {
        super(message);
    }

    public static final String NULL_MATRIX = "Matrix is null";
    public static final String INCOMP_MATRIX_SIZE = "Incompatible matrix sizes";

    public static void checkRowAndColumn(int rowcount, int columncount) {
        if (rowcount < 1 || columncount <1 ) throw new UnsupportedOperationException("The number of rows or columns is less than 1");
    }

    public static void checkDoubleMatrix(double[][] twoDimensionalArray) throws MatrixException {
        if (twoDimensionalArray == null) throw new UnsupportedOperationException(NULL_MATRIX);
        if (twoDimensionalArray.length == 0) throw new MatrixException("Array passed with zero number of rows");
        if (twoDimensionalArray[0] == null) throw new UnsupportedOperationException(NULL_MATRIX);
        if (twoDimensionalArray[0].length == 0) throw new MatrixException("Array passed with zero number of columns");
    }

    public static void checkTwoMatrix(Matrix matrix, int rowcount, int columncount) throws MatrixException {
            if (matrix.rows() != rowcount || matrix.columns() != columncount) throw new MatrixException(INCOMP_MATRIX_SIZE);
    }

    public static void checkMultiMatrix(Matrix matrix, int columncount) throws MatrixException {
        if (columncount != matrix.rows()) throw new MatrixException("Incompatible matrix sizes");
    }

    public static void checkCorrectIndex(int row, int column, double[][] actualmatrix) throws MatrixException {
        if (row >= actualmatrix.length || column >= actualmatrix[0].length || row < 0 || column < 0)
            throw new MatrixException(INCOMP_MATRIX_SIZE);
    }
}
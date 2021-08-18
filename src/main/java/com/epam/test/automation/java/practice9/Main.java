package com.epam.test.automation.java.practice9;

public class Main {
    public static void main(String[] args) throws MatrixException {
        System.out.println("Matrix rowXcolumn:");
        Matrix matrix1 = new Matrix(4, 5);
        System.out.println("Rows: " + matrix1.rows() + " | Columns: " + matrix1.columns());
        soutMatrix(matrix1.twoDimensionalArrayOutOfMatrix());

        System.out.println("\nMatrix new double[][]:");
        Matrix matrix2 = new Matrix(new double[][]{{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}});
        System.out.println("Rows: " + matrix2.rows() + " | Columns: " + matrix2.columns());
        soutMatrix(matrix2.twoDimensionalArrayOutOfMatrix());
        System.out.println("Value [1][3] of matrix: " + matrix2.getValue(1,3));
        System.out.println("\nSet '228' on [2][3]");
        matrix2.setValue(2, 3,228);
        soutMatrix(matrix2.twoDimensionalArrayOutOfMatrix());

        Matrix matrix3 = new Matrix(new double[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}});
        System.out.println("\nMatrix addition:");
        soutMatrix(matrix2.addition(matrix3).twoDimensionalArrayOutOfMatrix());
        System.out.println("\nMatrix subtraction:");
        soutMatrix(matrix2.subtraction(matrix3).twoDimensionalArrayOutOfMatrix());
        System.out.println("\nMatrix multiplication:");
        System.out.println("Matrix One:");
        soutMatrix(matrix2.twoDimensionalArrayOutOfMatrix());
        Matrix matrix4 = new Matrix(new double[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}});
        System.out.println("Matrix Two:");
        soutMatrix(matrix4.twoDimensionalArrayOutOfMatrix());
        System.out.println("\nMultiplication:");
        soutMatrix(matrix2.multiplication(matrix4).twoDimensionalArrayOutOfMatrix());
    }


    private static void soutMatrix(double[][] tempmatrix) {
        for (int i = 0; i < tempmatrix.length; i++) {
            for (int j = 0; j < tempmatrix[i].length; j++) {
                System.out.print(tempmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

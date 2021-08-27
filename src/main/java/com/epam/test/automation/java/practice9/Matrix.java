package com.epam.test.automation.java.practice9;

import java.text.DecimalFormat;

public class Matrix {
    private final double[][] actualmatrix;
    private final int rowcount;
    private final int columncount;

    /**
     * Implement a constructor that creates an empty matrix with a given number of rows
     * columns (all values in matrix equal 0.0)
     *
     * @param row    number of rows
     * @param column number of columns
     * @return Returns a new instance of the matrix with the specified parameters
     */
    public Matrix(int row, int column) {
        this.rowcount = row;
        this.columncount = column;
        MatrixException.checkRowAndColumn(rowcount, columncount);
        this.actualmatrix = new double[rowcount][columncount];
        for (int i = 0; i < actualmatrix.length; i++) {
            for (int j = 0; j < actualmatrix[i].length; j++) {
                actualmatrix[i][j] = 0;
            }
        }
    }

    /**
     * Implement a constructor that creating of matrix based on existing two-dimensional array.
     *
     * @param twoDimensionalArray existing two-dimensional array
     * @return Returns a new instance of the matrix based on existing two-dimensional array
     * @throws MatrixException if the incoming array with zero number of rows returns the message "Array passed with zero number of rows",
     *                         if the incoming array with zero number of columns returns the message "Array passed with zero number of columns"
     */
    public Matrix(double[][] twoDimensionalArray) throws MatrixException {
        MatrixException.checkDoubleMatrix(twoDimensionalArray);
        this.actualmatrix = twoDimensionalArray;
        rowcount = actualmatrix.length;
        columncount = actualmatrix[0].length;
    }

    /**
     * @return Returns the number of rows in a matrix
     */
    public final int rows() {
        return rowcount;
    }

    /**
     * @return Returns the number of columns in a matrix
     */
    public final int columns() {
        return columncount;
    }

    /**
     * Receiving of standard two-dimensional array out of matrix.
     *
     * @return Standard two-dimensional array
     */

    public double[][] twoDimensionalArrayOutOfMatrix() {
        return actualmatrix;
    }

    /**
     * Reading of elements via predetermined correct index
     *
     * @param row    number of rows
     * @param column number of columns
     * @return Returns the value of a matrix element <code>[row,column]</code>
     * @throws MatrixException if index incorrect, returns message "Incompatible matrix sizes"
     */
    public double getValue(int row, int column) throws MatrixException {
        MatrixException.checkCorrectIndex(row, column, actualmatrix);
        return actualmatrix[row][column];
    }

    /**
     * Recording value <code>newValue</code> of elements via predetermined correct index <code>[row,column]</code>     *
     *
     * @param row      number of rows
     * @param column   number of columns
     * @param newValue new value of a matrix element
     * @throws MatrixException if index incorrect, returns message "Incompatible matrix sizes"
     */
    public void setValue(int row, int column, double newValue) throws MatrixException {
        MatrixException.checkCorrectIndex(row, column, actualmatrix);
        actualmatrix[row][column] = newValue;
    }

    /**
     * Method of matrix's addition  <code>matrix</code>.
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the second term
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix addition(Matrix matrix) throws MatrixException {
        MatrixException.checkTwoMatrix(matrix, rows(), columns());
        Matrix summatrix = new Matrix(rows(), columns());
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                summatrix.setValue(i, j, actualmatrix[i][j] + matrix.getValue(i, j));
            }
        }
        return summatrix;
    }

    /**
     * Method of matrix's deduction <code>matrix</code> from original.
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the subtracted
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix subtraction(final Matrix matrix) throws MatrixException {
        MatrixException.checkTwoMatrix(matrix, rows(), columns());
        Matrix submatrix = new Matrix(rows(), columns());
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                submatrix.setValue(i, j, actualmatrix[i][j] - matrix.getValue(i, j));
            }
        }
        return submatrix;
    }

    /**
     * Method of matrix's multiplication <code>matrix</code>
     * Result in the original matrix
     *
     * @param matrix matrix corresponding to the second factor
     * @return Returns a new resulting matrix
     * @throws MatrixException if incompatible matrix sizes, returns message "Incompatible matrix sizes"
     */
    public Matrix multiplication(final Matrix matrix) throws MatrixException {
        MatrixException.checkMultiMatrix(matrix, columncount);
        Matrix multimatrix = new Matrix(rows(), matrix.columns());
        for(int i=0;i<rows();i++)
        {
            for(int u=0;u<matrix.columns();u++)
            {
                for(int j=0;j<columns();j++)
                {
                    multimatrix.setValue(i, u, multimatrix.getValue(i,u) + actualmatrix[i][j]*matrix.getValue(j,u));
                }
            }
        }
        return multimatrix;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                try {
                    if (j != this.columns() - 1) {
                        builder.append(decimalFormat.format(getValue(i, j)) + " ");
                    } else {
                        builder.append(decimalFormat.format(getValue(i, j)));
                    }
                } catch (MatrixException e) {
                    e.getMessage();
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
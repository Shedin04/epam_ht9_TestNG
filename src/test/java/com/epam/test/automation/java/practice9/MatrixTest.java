package com.epam.test.automation.java.practice9;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixTest{

    @Test(description = "New correct Matrix(row, columns)")
    public void test1() throws MatrixException {
        Matrix actual = new Matrix(3, 4);
        Matrix expected = new Matrix(new double[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        Assert.assertEquals(actual.toString(), expected.toString());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void test2() throws MatrixException {
        Matrix actual = new Matrix(-4, 4);
    }
}
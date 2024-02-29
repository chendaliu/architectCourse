package com.ydlclass.strategy;

/**
 * @author
 * @createTime 2023-06-01
 */
public class Addition implements Operation{
    @Override
    public double execute(double num1, double num2) {
        return num1 + num2;
    }
}

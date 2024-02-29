package com.ydlclass.strategy;

/**
 * @author 
 * @createTime 2023-06-01
 */
public class Calculator {

    // 客户端可以持有一个算法
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double num1,double num2){
        return operation.execute(num1,num2);
    }

}

package com.ydlclass.interpreter;

import java.util.Map;

/**
 * 加号表达式
 * @author
 * @createTime 2023-06-04
 */
public class Subtract implements Expression{

    private Expression left;
    private Expression right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Integer> variables) {
        return left.interpret(variables) - right.interpret(variables);
    }
}

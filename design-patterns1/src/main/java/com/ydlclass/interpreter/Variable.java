package com.ydlclass.interpreter;

import java.util.Map;

/**
 * 基础变量的表达式
 * @author
 * @createTime 2023-06-04
 */
public class Variable implements Expression{

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Integer> variables) {
        return variables.getOrDefault(name,0);
    }
}

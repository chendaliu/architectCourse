package com.ydlclass.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class Main {

    public static void main(String[] args) {
        Expression variableA = new Variable("a");
        Expression variableB = new Variable("b");
        Expression variableC = new Variable("c");

        Expression add = new Add(variableA,variableB);
        Expression subtract = new Subtract(variableB,variableC);

        // 执行一个加法
        Map<String,Integer> content = new HashMap<>(16);
        content.put("a",10);
        content.put("b",20);
        content.put("c",30);

        // "a + b"  在这里我们从来没有定义a和b这两个变量，在我们的眼中他们都是字符串

        // 执行加法操作
        int addResult = add.interpret(content);
        System.out.println("addResult = " + addResult);
        // 执行减法操作
        int subtractResult = subtract.interpret(content);
        System.out.println("subtractResult = " + subtractResult);
    }

}

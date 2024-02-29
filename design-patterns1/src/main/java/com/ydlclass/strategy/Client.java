package com.ydlclass.strategy;

import java.util.Scanner;

/**
 * @author
 * @createTime 2023-06-01
 */
public class Client {
    public static void main(String[] args) {

//        // 定义一个调用方
//        Calculator calculator = new Calculator();
//
//        // 计算加法
//        Operation operation = new Addition();
//        calculator.setOperation(operation);
//        double result = calculator.calculate(1.2, 2.3);
//        System.out.println(result);
//
//        // 计算减法
//        operation = new Subtraction();
//        calculator.setOperation(operation);
//        result = calculator.calculate(1.2, 2.3);
//        System.out.println(result);

//        Calculator calculator = new Calculator();
//        Scanner scanner = new Scanner(System.in);
//        // 定义两个计算的值
//        double num1 = 2.5 , num2 = 1.2;
//
//        while (true){
//            String next = scanner.next();
//            switch (next){
//                case "+":
//                    calculator.setOperation(new Addition());
//                    break;
//                case "-":
//                    calculator.setOperation(new Subtraction());
//                    break;
//                case "*":
//                    calculator.setOperation(new Multiplication());
//                    break;
//                default:
//                    calculator.setOperation(new Addition());
//                    break;
//            }
//            double calculate = calculator.calculate(num1, num2);
//            System.out.println(calculate);
//        }

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        // 定义两个计算的值
        double num1 = 2.5 , num2 = 1.2;

        while (true){
            String next = scanner.next();
            // 需要对next做合法校验，此处省略
            // 从策略工厂获取具体的策略，并设置
            Operation operation = OperationFactory.getOperation(next);
            calculator.setOperation(operation);
            double calculate = calculator.calculate(num1, num2);
            System.out.println(calculate);
        }


    }
}

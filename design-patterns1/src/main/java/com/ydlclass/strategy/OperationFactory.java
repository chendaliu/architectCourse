package com.ydlclass.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 * @author
 * @createTime 2023-06-01
 */
public class OperationFactory {

    private static Map<String,Operation> operationMap = new HashMap<>(8);

    static {
        operationMap.put("+",new Addition());
        operationMap.put("-",new Subtraction());
        operationMap.put("*",new Multiplication());
        operationMap.put("/",new Division());
    }

    public static Operation getOperation(String type){
        return operationMap.get(type);
    }

}

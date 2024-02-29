package com.ydlclass.interpreter;

import java.util.Map;

/**
 * @author
 * @createTime 2023-06-04
 */
public interface Expression {

    int interpret(Map<String,Integer> variables);

}

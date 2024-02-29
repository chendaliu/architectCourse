package com.ydlclass.chain.array;

import com.ydlclass.chain.linked.Request;

/**
 * @author
 * @createTime 2023-06-02
 */
public interface IHandler {

    /**
     * 抽象的请求处理的方法
     * @param request  传递的请求
     * @return false代表未处理，true代表已经处理
     */
    boolean handle(Request request);

}

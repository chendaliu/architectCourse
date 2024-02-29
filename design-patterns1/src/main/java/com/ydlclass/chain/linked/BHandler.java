package com.ydlclass.chain.linked;

/**
 * @author
 * @createTime 2023-06-02
 */
public class BHandler extends Handler{
    @Override
    public void handle(Request request) {
        // 1、执行具体的业务逻辑
        request.setNum(request.getNum()+10);
        System.out.println("第二个过滤器-->" + request.getNum());
    }
}

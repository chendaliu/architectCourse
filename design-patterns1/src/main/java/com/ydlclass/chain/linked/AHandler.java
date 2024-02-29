package com.ydlclass.chain.linked;

/**
 * @author
 * @createTime 2023-06-02
 */
public class AHandler extends Handler{
    @Override
    public void handle(Request request) {
        // 1、执行具体的业务逻辑
        request.setNum(request.getNum()+1);
        System.out.println("第一个过滤器-->" + request.getNum());
    }
}

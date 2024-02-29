package com.ydlclass.chain.array;

import com.ydlclass.chain.linked.Request;

/**
 * @author 
 * @createTime 2023-06-02
 */
public class AHandler implements IHandler {
    @Override
    public boolean handle(Request request) {
        if(request.getNum() > 5){
            request.setNum(request.getNum() + 30);
            // 该处理器已经处理
            return true;
        }
        return false;
    }
}

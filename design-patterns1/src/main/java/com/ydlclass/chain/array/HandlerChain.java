package com.ydlclass.chain.array;

import com.ydlclass.chain.linked.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @createTime 2023-06-02
 */
public class HandlerChain {

    // 数组
    List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler){
        handlers.add(handler);
    }

    public void doHandle(Request request){
        if(handlers == null || handlers.size() == 0){
            return;
        }

        for (IHandler handler : handlers) {
            boolean handle = handler.handle(request);
            if(handle){
                return;
            }
        }

    }

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new BHandler());
        chain.addHandler(new AHandler());
        chain.addHandler(new BHandler());
        chain.addHandler(new AHandler());
        Request request = new Request();
        chain.doHandle(request);
        System.out.println(request);
    }



}

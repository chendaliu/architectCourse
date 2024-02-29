package com.ydlclass.chain.linked;

/**
 * 不标准，他是每一个处理器都要处理请求，
 * 标准的是，遇到第一个可以处理请求的处理器，进行处理，并且返回
 * @author 
 * @createTime 2023-06-02
 */
public class HandlerChain {

    private Handler head;
    private Handler tail;


    public void addHandler(Handler handler) {
        if(head == null && tail == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setNext(handler);
        tail = handler;
    }

    public void doHandle(Request request) {
        if(head != null){
            Handler p = head;
            do {
               p.handle(request);
               p = p.next;
            } while (p != null);
        }
    }



    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new AHandler());
        chain.addHandler(new BHandler());

        chain.doHandle(new Request());

    }



}

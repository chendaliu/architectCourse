package com.ydlclass.chain.linked;

/**
 * 这是一个处理器
 * @author
 * @createTime 2023-06-02
 */
public abstract class Handler {
    // 拥有具体的处理方法，抽象
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handle(Request request);
}

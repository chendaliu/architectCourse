package pers.czl.architect.designpattern.chain.handler;

import pers.czl.architect.designpattern.chain.PurchaseRequest;

/**
 * 审批者类：抽象处理者
 *
 * @author: daliu
 * @date: 2022-01-04 14:36
 **/
public abstract class Approver {
    protected Approver successor; //定义后继对象
    protected String name; //审批者姓名

    public Approver(String name) {
        this.name = name;
    }

    //设置后继者
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);

}
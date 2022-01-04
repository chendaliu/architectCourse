package pers.czl.architect.designpattern.chain;

import pers.czl.architect.designpattern.chain.handler.Approver;
import pers.czl.architect.designpattern.chain.handler.concreteHandler.Congress;
import pers.czl.architect.designpattern.chain.handler.concreteHandler.Director;
import pers.czl.architect.designpattern.chain.handler.concreteHandler.President;
import pers.czl.architect.designpattern.chain.handler.concreteHandler.VicePresident;

/**
 * 责任链模式
 * 角色：
 * Handler（抽象处理者）
 * ConcreteHandler（具体处理者）
 *
 * 适用场景：多个对象处理同一个请求
 *
 * 这里模拟审批场景
 * @author: daliu
 * @date: 2022-01-04 14:32
 **/
public class Client {

    public static void main(String[] args) {
        Approver wjzhang,gyang,jguo,meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        jguo = new President("郭靖");
        meeting = new Congress("董事会");

        //创建职责链
        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(jguo);
        jguo.setSuccessor(meeting);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
        wjzhang.processRequest(pr1);

        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
        wjzhang.processRequest(pr2);

        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
        wjzhang.processRequest(pr3);

        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        wjzhang.processRequest(pr4);
    }

}
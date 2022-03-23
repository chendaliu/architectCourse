package pers.czl.architect.designpattern.proxy;

/**
 * 接口类
 * @author: daliu
 * @date: 2022-03-23 11:11
 **/
public interface TicketService {

    //售票
    public void sellTicket();

    //问询
    public void inquire();

    //退票
    public void withdraw();

}

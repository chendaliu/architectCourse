package pers.czl.architect.designpattern.proxy;

/**
 * 委托类
 * @author: daliu
 * @date: 2022-03-23 11:12
 **/
public class Station implements TicketService {

    @Override
    public void sellTicket() {
        System.out.println("\n\t售票.....\n");
    }

    @Override
    public void inquire() {
        System.out.println("\n\t问询。。。。\n");
    }

    @Override
    public void withdraw() {
        System.out.println("\n\t退票......\n");
    }

}
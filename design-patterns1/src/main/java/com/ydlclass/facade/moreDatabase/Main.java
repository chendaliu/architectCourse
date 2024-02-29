package com.ydlclass.facade.moreDatabase;

/**
 * @author 
 * @createTime 2023-05-26
 */
public class Main {
    public static void main(String[] args) {
        DatabaseFacade facade = new DatabaseFacade();
        facade.executeSQL("select * from user;","MYSQL");
    }
}

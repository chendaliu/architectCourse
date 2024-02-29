package com.ydlclass.facade.moreDatabase;

/**
 * @author
 * @createTime 2023-05-26
 */
public class MySQLDatabase implements Database{
    @Override
    public void execute(String sql) {
        System.out.println("Executing " + sql + " in MySQL database");
    }
}

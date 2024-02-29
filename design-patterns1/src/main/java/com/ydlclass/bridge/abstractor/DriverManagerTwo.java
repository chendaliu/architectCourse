package com.ydlclass.bridge.abstractor;

/**
 * @author
 * @createTime 2023-05-24
 */
public class DriverManagerTwo extends DriverManager{

    @Override
    public Connection getConnection() {
        System.out.println("这是由DriverManagerTwo来管理的连接。");
        return super.getConnection();
    }
}

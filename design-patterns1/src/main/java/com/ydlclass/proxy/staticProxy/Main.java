package com.ydlclass.proxy.staticProxy;

/**
 * @author
 * @createTime 2023-05-17
 */
public class Main {
    public static void main(String[] args) {
        DataQuery dataQuery = new DatabaseDataQueryProxy();

        String value = dataQuery.query("key1");
        System.out.println(value);

        value = dataQuery.query("key1");
        System.out.println(value);

        value = dataQuery.query("key2");
        System.out.println(value);

    }
}

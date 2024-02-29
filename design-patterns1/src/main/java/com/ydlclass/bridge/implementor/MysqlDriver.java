package com.ydlclass.bridge.implementor;

import com.ydlclass.bridge.abstractor.Connection;

/**
 * @author
 * @createTime 2023-05-24
 */
public class MysqlDriver implements Driver {
    @Override
    public Connection connect() {
        return new Connection("mysql");
    }
}

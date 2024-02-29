package com.ydlclass.bridge.abstractor;

import com.ydlclass.bridge.implementor.Driver;

/**
 * @author
 * @createTime 2023-05-24
 */
public abstract class DriverManager {

    //依赖于抽象接口而不是具体实现
    private Driver driver;

    public  Connection getConnection(){
        return driver.connect();
    }

    public void register(Driver driver){
        this.driver = driver;
    }

}

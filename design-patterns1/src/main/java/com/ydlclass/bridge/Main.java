package com.ydlclass.bridge;

import com.ydlclass.bridge.abstractor.Connection;
import com.ydlclass.bridge.implementor.Driver;
import com.ydlclass.bridge.abstractor.DriverManager;
import com.ydlclass.bridge.abstractor.DriverManagerOne;

/**
 * @author
 * @createTime 2023-05-24
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 先创建一个驱动实例,我们可以通过反射来构建
        Driver driver = (Driver) Class.forName("com.ydlclass.bridge.implementor.OracleDriver").newInstance();

        // 注册给DriverManager
        DriverManager driverManager = new DriverManagerOne();
        driverManager.register(driver);

        Connection connection = driverManager.getConnection();
        System.out.println(connection);
    }

}

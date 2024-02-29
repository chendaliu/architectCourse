package com.ydlclass.proxy;

import com.ydlclass.proxy.dynamicProxy.aop.DataQuery;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 
 * @createTime 2023-05-17
 */
@SpringBootTest
public class AopTest {

    @Resource
    private DataQuery dataQuery;

    @Test
    public void testAop(){
        dataQuery.query("key1");
        dataQuery.query("key1");
        dataQuery.query("key2");
    }

}

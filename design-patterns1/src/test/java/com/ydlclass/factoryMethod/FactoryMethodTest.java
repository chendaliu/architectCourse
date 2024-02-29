package com.ydlclass.factoryMethod;

import com.ydlclass.factoryMethod2.ResourceLoader;
import com.ydlclass.factoryMethod2.product.AbstractResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author 
 * @createTime 2023-05-10
 */

@Slf4j
public class FactoryMethodTest {

    @Test
    public void testFactoryMethod(){
        String url = "file://D://a.txt";
        ResourceLoader resourceLoader = new ResourceLoader();
        AbstractResource resource = resourceLoader.load(url);
        log.info("resource --> {}",resource.getClass().getName());
    }

}

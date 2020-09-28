package pers.czl.spring.iocbeanlifecicle;

import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-27 10:50
 * @Version:1.0
 **/
@Component
public class FactoryBeanClass implements SmartFactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new FactoryBeanClass2();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
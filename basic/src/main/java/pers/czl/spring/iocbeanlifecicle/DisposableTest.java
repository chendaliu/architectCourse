package pers.czl.spring.iocbeanlifecicle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author: Daliu
 * @CreateTime: 2020-10-07 17:25
 * @Version:1.0
 **/
@Component()
public class DisposableTest implements DisposableBean {

    @Override
    public void destroy() throws Exception {

    }
}
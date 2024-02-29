package com.ydlclass.facade.external;

/**
 * @author 
 * @createTime 2023-05-26
 */
public class Facade {

    private ExternalService externalService2 = new ExternalService2();
    private ExternalService1 externalService1 = new ExternalService1();

    public void doSomeThing1(){
        externalService2.doSomeThing();
    }

    public void doSomeThing2(){
        externalService1.doSomeThing();
    }


}

package com.ydlclass.templateMethod;

/**
 * @author
 * @createTime 2023-05-31
 */
public class ConcreteTemplateA extends AbstractTemplate{
    @Override
    public void step2() {
        System.out.println("步骤2A");
    }

    @Override
    public void step3() {
        System.out.println("步骤3A");
    }
}

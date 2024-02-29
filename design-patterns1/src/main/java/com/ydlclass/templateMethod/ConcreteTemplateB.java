package com.ydlclass.templateMethod;

/**
 * @author
 * @createTime 2023-05-31
 */
public class ConcreteTemplateB extends AbstractTemplate{
    @Override
    public void step2() {
        System.out.println("步骤2B");
    }

    @Override
    public void step3() {
        System.out.println("步骤3B");
    }
}

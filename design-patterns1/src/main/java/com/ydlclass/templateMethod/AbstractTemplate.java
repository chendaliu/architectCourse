package com.ydlclass.templateMethod;

/**
 * @author 
 * @createTime 2023-05-31
 */
public abstract class AbstractTemplate {

    // 1、定义算法估计，理论上算法骨架应该不能被重写
    public final void template(){
        // 执行具体的步骤
        step1();
        step2();
        step3();
        step4();
        step5();
    }

    // 部分步骤由模板提供
    public void step1() {
        System.out.println("步骤1");
    }

    // 抽象方法必须由子类实现
    public abstract void step2();

    public abstract void step3();

    public void step4() {
        System.out.println("步骤4");
    }

    public void step5() {
        System.out.println("步骤5");
    }

}

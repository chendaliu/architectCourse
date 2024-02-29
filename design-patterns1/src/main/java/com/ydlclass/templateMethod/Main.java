package com.ydlclass.templateMethod;

/**
 * @author 
 * @createTime 2023-05-31
 */
public class Main {
    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplateA();
        // 调用模板方法，具体的步骤可能是子类的实现，也有可能是模板中的实现
        template.template();
    }
}

package pers.czl.elsetest.dynamicProxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

    private Object delegate;

    private String interfaceClazz;

    /*public JdkDynamicProxy(Object bookService){
        this.delegate = bookService;
    }*/

    public JdkDynamicProxy(String interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        //return (T) Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
        Class interfaceClass = null;
        Object instance = null;
        try {
            interfaceClass = Class.forName(interfaceClazz);

            //ClassLoader classLoader = delegate.getClass().getClassLoader();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            instance = Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, this);

            Field hashCodeFeild = null;
            hashCodeFeild = instance.getClass().getDeclaredField("m0");
            hashCodeFeild.setAccessible(true);
            Method hashCodeMethod = (Method) hashCodeFeild.get(instance);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        prepareMoneyForBuyBook();
        Object obj = method.invoke(delegate, args);
        readBookAfterBuy();
        return obj;
    }

    private void prepareMoneyForBuyBook() {
        System.out.println("为买本准备好钱...");
    }

    private void readBookAfterBuy() {
        System.out.println("终于可以看自己喜欢的书了...");
    }
}
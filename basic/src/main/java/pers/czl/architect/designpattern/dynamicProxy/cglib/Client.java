package pers.czl.architect.designpattern.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import pers.czl.architect.designpattern.dynamicProxy.jdk.ProxyUtils;

/**
 * @author: daliu
 * @date: 2022-03-23 16:05
 **/
public class Client {

    public static void main(String[] args) {
        Programmer progammer = new Programmer();

        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(progammer.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);
        Programmer proxyProgrammer = (Programmer) enhancer.create();

        proxyProgrammer.code();

        ProxyUtils.generateClassFile(proxyProgrammer.getClass(), "ProgrammerProxy");
    }

}
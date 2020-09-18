package pers.czl.architect.designpattern.flyweight.base;

import java.util.HashMap;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:34
 * @Version:1.0
 **/
public class FlyweightFactory {

    private static volatile FlyweightFactory flyweightFactory;

    public static FlyweightFactory getInstance() {
        if (flyweightFactory == null) {
            synchronized (FlyweightFactory.class) {
                if (flyweightFactory == null) {
                    flyweightFactory = new FlyweightFactory();
                }
            }
        }
        return flyweightFactory;
    }

    private static HashMap<String, AbstractFlyweight> pool = new HashMap<>();

    //享元工厂
    public AbstractFlyweight getFlyweight(String extrinsic) {
        AbstractFlyweight flyweight = null;

        if(pool.containsKey(extrinsic)) {    //池中有该对象
            flyweight = pool.get(extrinsic);
            System.out.print("已有 " + extrinsic + " 直接从池中取---->");
        } else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight(extrinsic);
            //放入池中
            pool.put(extrinsic, flyweight);
            System.out.print("创建 " + extrinsic + " 并从池中取出---->");
        }

        return flyweight;
    }

}
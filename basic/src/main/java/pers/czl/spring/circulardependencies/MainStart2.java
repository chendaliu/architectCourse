package pers.czl.spring.circulardependencies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class MainStart2 {

    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    /**
     * 读取bean定义，当然在spring中肯定是根据配置 动态扫描注册
     */
    public static void loadBeanDefinitions() {
        RootBeanDefinition aBeanDefinition = new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition bBeanDefinition = new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA", aBeanDefinition);
        beanDefinitionMap.put("instanceB", bBeanDefinition);
    }

    public static void main(String[] args) throws Exception {
        // 加载了BeanDefinition
        loadBeanDefinitions();
        // 注册Bean的后置处理器

        // 循环创建Bean
        /*for (String key : beanDefinitionMap.keySet()) {
            // 先创建A
            getBean(key);
        }*/
        getBean("instanceA");
        InstanceA instanceA = (InstanceA) getBean("instanceA");
        instanceA.say();
    }

    // 一级缓存
    public static Map<String, Object> singletonObjects = new ConcurrentHashMap<>();


    // 二级缓存： 为了将 成熟Bean和纯净Bean分离，避免读取到不完整得Bean
    public static Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();


    // 假设A 使用了Aop @PointCut("execution(* *..InstanceA.*(..))")   要给A创建动态代理
    // 获取Bean
    public static Object getBean(String beanName) throws Exception {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }

        // 实例化
        RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        Object instanceBean = beanClass.newInstance();  // 通过无参构造函数

        // 创建动态代理  （耦合 、BeanPostProcessor)    Spring还是希望正常的Bean 还是再初始化后创建

        // 添加到二级缓存
        earlySingletonObjects.put(beanName, instanceBean);

        // 属性赋值
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            // 说明属性上面有Autowired
            if (annotation != null) {
                declaredField.setAccessible(true);
                // byname  bytype  byconstrator
                // instanceB
                String name = declaredField.getName();
                Object fileObject = getBean(name);   //拿到B得Bean
                declaredField.set(instanceBean, fileObject);
            }

        }


        // 初始化   init-mthod
        // 放在这里创建已经完了  B里面的A 不是proxy
        // 正常情况下会再 初始化之后创建proxy


        // 由于递归完后A 还是原实例，， 所以要从二级缓存中拿到proxy 。
        /*if (earlySingletonObjects.containsKey(beanName)) {
            instanceBean = earlySingletonObjects.get(beanName);
        }*/

        // 添加到一级缓存   A
        singletonObjects.put(beanName, instanceBean);


        // remove 二级缓存和三级缓存
        return instanceBean;
    }


    public static Object getSingleton(String beanName) {
        // 先从一级缓存中拿
        Object bean = singletonObjects.get(beanName);

        // 说明是循环依赖
        if (bean == null) {
            bean = earlySingletonObjects.get(beanName);
        }

        return bean;

    }

}

package pers.czl.elsetest.java8;

import java.util.Optional;

/**
 * @Title:
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-06-01 13:48
 * @Version:1.0
 **/
public class OptionalTest {

    public static void main(String[] args)  {
        //of
        //创建一个值为张三的String类型的Optional
        Optional<String> ofOptional = Optional.of("张三");
        //如果我们用of方法创建Optional对象时，所传入的值为null，则抛出NullPointerException如下图所示
        //Optional<String> nullOptional = Optional.of(null);

        //ofNullable
        //为指定的值创建Optional对象，不管所传入的值为null不为null，创建的时候都不会报错
        Optional<String> nullOptional1 = Optional.ofNullable(null);
        Optional<String> nullOptional2 = Optional.ofNullable("lisi");

        //get
        //如果我们创建的Optional对象中有值存在则返回此值，如果没有值存在，则会抛出NoSuchElementException异常
        Optional<String> stringOptional = Optional.of("张三");
        System.out.println(stringOptional.get());
        Optional optional = Optional.empty();
        //会报错
        //System.out.println(optional.get());

        //orElse
        //如果创建的Optional中有值存在，则返回此值，否则返回一个默认值
        Optional<String> stringOptional3 = Optional.of("张三");
        System.out.println(stringOptional3.orElse("zhangsan"));

        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.orElse("李四"));

        //orElseGet
        //如果创建的Optional中有值存在，则返回此值，否则返回一个由Supplier接口生成的值
        Optional<String> stringOptional5 = Optional.of("张三");
        System.out.println(stringOptional5.orElseGet(() -> "zhangsan"));

        Optional<String> emptyOptional6 = Optional.empty();
        System.out.println(emptyOptional6.orElseGet(() -> "orElseGet"));

        //orElseThrow
        //如果创建的Optional中有值存在，则返回此值，否则抛出一个由指定的Supplier接口生成的异常
        Optional<String> stringOptional7 = Optional.of("张三");
        System.out.println(stringOptional7.orElseThrow(CustomException::new));

        Optional<String> emptyOptional8 = Optional.empty();
        //System.out.println(emptyOptional8.orElseThrow(CustomException::new));

        //filter
        //如果创建的Optional中的值满足filter中的条件，则返回包含该值的Optional对象，否则返回一个空的Optional对象
        //注意Optional中的filter方法和Stream中的filter方法是有点不一样的，Stream中的filter方法是对一堆元素进
        //行过滤，而Optional中的filter方法只是对一个元素进行过滤，可以把Optional看成是最多只包含一个元素的Stream。
        Optional<String> stringOptional9 = Optional.of("zhangsan");
        System.out.println(stringOptional9.filter(e -> e.length() > 5).orElse("王五"));

        stringOptional9 = Optional.empty();
        System.out.println(stringOptional9.filter(e -> e.length() > 5).orElse("lisi"));

        //map
        //如果创建的Optional中的值存在，对该值执行提供的Function函数调用
        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改,修改后的返回值仍然是一个Optional对象
        Optional<String> stringOptional10 = Optional.of("zhangsan");
        System.out.println(stringOptional10.map(e -> e.toUpperCase()).orElse("失败"));

        stringOptional10 = Optional.empty();
        System.out.println(stringOptional10.map(e -> e.toUpperCase()).orElse("失败"));

        //flagMap
        //如果创建的Optional中的值存在，就对该值执行提供的Function函数调用，返回一个Optional类型的值，否
        //则就返回一个空的Optional对象.flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回
        //值必须是Optional，map方法的mapping函数返回值可以是任何类型T。调用结束时，flatMap不会对结果用Optional封装
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例
        Optional<String> stringOptional11 = Optional.of("zhangsan");
        System.out.println(stringOptional11.flatMap(e -> Optional.of("lisi")).orElse("失败"));

        stringOptional11 = Optional.empty();
        System.out.println(stringOptional11.flatMap(e -> Optional.empty()).orElse("失败"));

        //ifPresent
        //ifPresent方法的参数是一个Consumer的实现类，Consumer类包含一个抽象方法，该抽象方法对传入的值进行处理，只处理没有返回值。
        //如果 Optional 是null值则不处理，非null值才处理
        Optional<String> stringOptional12 = Optional.of("zhangsan");
        stringOptional12.ifPresent(e-> System.out.println("我被处理了。。。"+e));

        stringOptional12 = Optional.empty();
        stringOptional12.ifPresent(e-> System.out.println("我被处理了。。。"+e));
    }

    private static class CustomException extends RuntimeException {
        private static final long serialVersionUID = -4399699891687593264L;

        public CustomException() {
            super("自定义异常");
        }

        public CustomException(String message) {
            super(message);
        }
    }
}
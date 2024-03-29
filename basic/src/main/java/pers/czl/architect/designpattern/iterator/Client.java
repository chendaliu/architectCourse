package pers.czl.architect.designpattern.iterator;

import pers.czl.architect.designpattern.iterator.aggregate.AbstractObjectList;
import pers.czl.architect.designpattern.iterator.aggregate.ProductList;
import pers.czl.architect.designpattern.iterator.iterator.AbstractIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * Iterator（抽象迭代器），可以是抽象类或接口
 * ConcreteIterator（具体迭代器）
 * Aggregate（抽象聚合类）
 * ConcreteAggregate（具体聚合类）
 *
 * @author: daliu
 * @date: 2022-03-29 16:44
 **/
public class Client {

    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("四十二章经");

        AbstractObjectList list;
        AbstractIterator iterator;

        list = new ProductList(products); //创建聚合对象
        iterator = list.createIterator();	//创建迭代器对象

        System.out.println("正向遍历：");
        while(!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + "，");
            iterator.next();
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");
        while(!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + "，");
            iterator.previous();
        }

    }
}
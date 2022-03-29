package pers.czl.architect.designpattern.iterator.aggregate;

import pers.czl.architect.designpattern.iterator.iterator.AbstractIterator;
import pers.czl.architect.designpattern.iterator.iterator.ProductIterator;

import java.util.List;

/**
 * 商品数据类：具体聚合类
 * @author: daliu
 * @date: 2022-03-29 16:49
 **/
public class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }

    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
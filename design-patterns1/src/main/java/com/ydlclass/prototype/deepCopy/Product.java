package com.ydlclass.prototype.deepCopy;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * @createTime 2023-05-15
 */
@Data
class Product implements Cloneable, Serializable {
    private String name;
    private double price;
    private int stock;

    // 省略构造函数、getter和setter方法

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

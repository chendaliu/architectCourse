package com.ydlclass.prototype.deepCopy;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * @createTime 2023-05-15
 */
@Data
public class PromotionRule implements Cloneable, Serializable {
    private String type;
    private double discount;
    private Product product;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        PromotionRule promotionRule = (PromotionRule)super.clone();
        if(product != null){
            Product cloneProduct = product.clone();
            promotionRule.setProduct(cloneProduct);
        }
        return promotionRule;
    }
}

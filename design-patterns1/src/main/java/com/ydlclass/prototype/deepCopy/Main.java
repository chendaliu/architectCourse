package com.ydlclass.prototype.deepCopy;

import java.util.Date;
import java.util.List;

/**
 * @author 
 * @createTime 2023-05-15
 */
public class Main {
    public static void main(String[] args) {
        PromotionEvent promotionEvent = new PromotionEvent();
        promotionEvent.setStartDate(new Date());
        PromotionRule promotionRule = new PromotionRule();
        promotionRule.setType("折扣");
        promotionRule.setDiscount(0.9);
        Product product = new Product();
        promotionRule.setProduct(product);
        promotionEvent.setRules(List.of(promotionRule));

        // 深拷贝
        PromotionEvent clonePromotionEvent = promotionEvent.clone();
        System.out.println(clonePromotionEvent.getRules().get(0).getProduct() == product);
        clonePromotionEvent.getRules().get(0).setDiscount(0.7);

    }
}

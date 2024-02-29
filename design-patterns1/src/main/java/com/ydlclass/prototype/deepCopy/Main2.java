package com.ydlclass.prototype.deepCopy;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @createTime 2023-05-15
 */
public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PromotionEvent promotionEvent = new PromotionEvent();
        promotionEvent.setStartDate(new Date());
        PromotionRule promotionRule = new PromotionRule();
        promotionRule.setType("折扣");
        promotionRule.setDiscount(0.9);
        Product product = new Product();
        promotionRule.setProduct(product);
        promotionEvent.setRules(List.of(promotionRule));

        // 深拷贝
        // 1、将对象转化为二进制流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(promotionEvent);
        byte[] bytes = outputStream.toByteArray();

        // 2、使用字节流进行反序列化，得到一个实例
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        PromotionEvent copyPromotionEvent = (PromotionEvent)ois.readObject();

        // 3、测试
        System.out.println(promotionEvent == copyPromotionEvent);
        System.out.println(
                copyPromotionEvent.getRules().get(0).getProduct() ==
                        promotionEvent.getRules().get(0).getProduct()
        );



    }
}

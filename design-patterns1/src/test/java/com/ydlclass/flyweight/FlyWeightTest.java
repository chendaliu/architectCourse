package com.ydlclass.flyweight;

import org.junit.jupiter.api.Test;

/**
 * @author
 * @createTime 2023-05-29
 */
public class FlyWeightTest {

    @Test
    public void testInteger(){
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);

        System.out.println("------------------------------");

        i1 = 129;
        i2 = 129;
        i3 = new Integer(129);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);

    }

    @Test
    public void testString(){
        String s1 = "itnanls";
        String s2 = "itnanls";
        String s3 = new String("itnanls");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

    }

}

package com.ydlclass.decoretor;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 
 * @createTime 2023-05-23
 */
public class DecoratorTest {

    @Test
    public void testIo() throws IOException {

        // 1、创建一个io流
        InputStream in = new FileInputStream("D:/test.txt");
        // 2、读取
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > -1){
            System.out.println(new String(buf,0,len));
        }
        // 3、关闭资源
        in.close();
    }

    @Test
    public void testBuf() throws IOException {

        // 1、创建一个io流
        InputStream in = new FileInputStream("D:/test.txt");
        in = new BufferedInputStream(in);
        // 2、读取
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > -1){
            System.out.println(new String(buf,0,len));
        }
        // 3、关闭资源
        in.close();
    }


}

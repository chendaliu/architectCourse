package com.ydlclass.creational;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * @author
 * @createTime 2023-05-08
 */
@Slf4j
public class SingletonTest {

    @Test
    public void testSingleton(){

        System.out.println("EagerSingleton.getInstance() == EagerSingleton.getInstance() -> " + (EagerSingleton.getInstance() == EagerSingleton.getInstance()));
        System.out.println("LazySingleton.getInstance() == LazySingleton.getInstance() -> " + (LazySingleton.getInstance() == LazySingleton.getInstance()));
        System.out.println("DclSingleton.getInstance() == DclSingleton.getInstance() -> " + (DclSingleton.getInstance() == DclSingleton.getInstance()));
    }

    // 通过反射破坏单例
    @Test
    public void testReflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<DclSingleton> clazz = DclSingleton.class;
        Constructor<DclSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        boolean flag = DclSingleton.getInstance() == constructor.newInstance();

        log.info("flag -> {}",flag);
    }

    @Test
    public void testSerialize() throws IllegalAccessException, NoSuchMethodException, IOException, ClassNotFoundException {
        // 获取单例并序列化
        DclSingleton singleton = DclSingleton.getInstance();
        FileOutputStream fout = new FileOutputStream("D://test//singleton.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(singleton);
        // 将实例反序列化出来
        FileInputStream fin = new FileInputStream("D://test//singleton.txt");
        ObjectInputStream in = new ObjectInputStream(fin);
        Object o = in.readObject();
        log.info("他们是同一个实例吗？{}",o == singleton);
    }

    @Test
    public void testRunTime() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("ping 127.0.0.1");
        InputStream inputStream = exec.getInputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) > 0 ){
            System.out.println(new String(buffer,0,len, Charset.forName("GBK")));
        }

        long maxMemory = runtime.maxMemory();
        log.info("maxMemory-->{}", maxMemory);
    }

    @Test
    public void testLogger(){
        Logger ydl = LoggerFactory.getLogger("ydl");
        Logger ydl2 = LoggerFactory.getLogger("ydl");
        Logger ydlclass = LoggerFactory.getLogger("ydlclass");
        log.info("ydl == ydl2 -->{}", ydl == ydl2);
        log.info("ydl == ydlclass --> {}", ydl == ydlclass);
    }

}

package pers.czl.architect.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 内存溢出测试
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-07-01 10:32
 * @Version:1.0
 **/
public class OOMTest {

    public static void main(String[] args) throws InterruptedException {
        OOMTest oomTest = new OOMTest();
        oomTest.heapOom();
    }

    /**
     * -Xms5M -Xmx5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvmOomDump.dump
     * 加上以上参数在发生内存溢出时会导出dump
     * @throws InterruptedException
     */
    public void heapOom() throws InterruptedException {
        Student student;
        List<Student> list = new ArrayList<>();
        int i = 0;
        for(;;) {
            System.out.println(i++);
            list.add(new Student());
            Thread.sleep(100);
        }
    }

    static class Student {
        byte[] bytes = new byte[1024];
    }
}
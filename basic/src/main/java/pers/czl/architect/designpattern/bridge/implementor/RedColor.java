package pers.czl.architect.designpattern.bridge.implementor;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:29
 * @Version:1.0
 **/
public class RedColor implements Color {

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + "画红色的" + name);
    }
}
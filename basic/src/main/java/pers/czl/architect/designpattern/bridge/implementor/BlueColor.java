package pers.czl.architect.designpattern.bridge.implementor;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:32
 * @Version:1.0
 **/
public class BlueColor implements Color {

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + "画蓝色的" + name);
    }
}
package pers.czl.architect.designpattern.bradge;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:31
 * @Version:1.0
 **/
public class GreenColor implements Color {

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + "画绿色的" + name);
    }
}
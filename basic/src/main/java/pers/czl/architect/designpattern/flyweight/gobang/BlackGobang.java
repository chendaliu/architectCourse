package pers.czl.architect.designpattern.flyweight.gobang;

/**
 * @Title: 黑色五子棋
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-18 11:25
 * @Version:1.0
 **/
public class BlackGobang extends AbstractGobang {

    protected BlackGobang() {
        super(GolangColorEnum.COLOR_BLACK.getColor());
    }

}